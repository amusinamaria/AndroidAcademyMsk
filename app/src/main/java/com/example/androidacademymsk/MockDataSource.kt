package com.example.androidacademymsk

class MockDataSource {
    fun getMovieCards(): List<MovieCard> {
        return listOf(
            MovieCard("Avatar"),
            MovieCard("Tomorrow"),
            MovieCard("Hi, Mike"),
            MovieCard("The old street"),
            MovieCard("Thirteen Days"),
            MovieCard("Ironclad"),
            MovieCard("Stone"),
            MovieCard("The Oranges"),
            MovieCard("Superman Returns"),
            MovieCard("Due Date"),
            MovieCard("Ghost in the Shell"),
        )
    }
}