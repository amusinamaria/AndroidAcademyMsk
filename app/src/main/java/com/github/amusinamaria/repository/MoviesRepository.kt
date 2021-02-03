package com.github.amusinamaria.repository

import com.github.amusinamaria.repository.data.Actor
import com.github.amusinamaria.repository.data.Genre
import com.github.amusinamaria.repository.data.JsonMovie
import com.github.amusinamaria.repository.data.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MoviesRepository @Inject constructor() {

    private val jsonFormat = Json { ignoreUnknownKeys = true }

    private suspend fun loadGenres(): List<Genre> = withContext(Dispatchers.IO) {
        val data = readAssetFileToString("genres.json")
        parseGenres(data)
    }

    private fun parseGenres(data: String): List<Genre> {
        return jsonFormat.decodeFromString(data)
    }

    private fun readAssetFileToString(fileName: String): String {
        val stream = javaClass.getResourceAsStream("/assets/$fileName")
        return stream!!.bufferedReader().readText()
    }

    private suspend fun loadActors(): List<Actor> = withContext(Dispatchers.IO) {
        val data = readAssetFileToString("people.json")
        parseActors(data)
    }

    private fun parseActors(data: String): List<Actor> {
        return jsonFormat.decodeFromString(data)
    }

    internal suspend fun loadMovies(): List<Movie> = withContext(Dispatchers.IO) {
        var genresMap = listOf<Genre>()
        var actorsMap = listOf<Actor>()
        var data = ""
        coroutineScope {
            launch {
                genresMap = loadGenres()
            }
            launch {
                actorsMap = loadActors()
            }
            launch {
                data = readAssetFileToString("data.json")
            }
        }
        parseMovies(data, genresMap, actorsMap)
    }

    private fun parseMovies(
        data: String,
        genres: List<Genre>,
        actors: List<Actor>
    ): List<Movie> {
        val genresMap = genres.associateBy { it.id }
        val actorsMap = actors.associateBy { it.id }

        val jsonMovies = jsonFormat.decodeFromString<List<JsonMovie>>(data)

        return jsonMovies.map { jsonMovie ->
            Movie(
                id = jsonMovie.id,
                title = jsonMovie.title,
                overview = jsonMovie.overview,
                poster = jsonMovie.posterPicture,
                backdrop = jsonMovie.backdropPicture,
                ratings = jsonMovie.ratings,
                numberOfRatings = jsonMovie.votesCount,
                minimumAge = if (jsonMovie.adult) 16 else 13,
                runtime = jsonMovie.runtime,
                genres = jsonMovie.genreIds.map {
                    genresMap[it] ?: throw IllegalArgumentException("Genre not found")
                },
                actors = jsonMovie.actors.map {
                    actorsMap[it] ?: throw IllegalArgumentException("Actor not found")
                }
            )
        }
    }
}
