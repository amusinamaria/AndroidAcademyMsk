package com.example.androidacademymsk

class MockDataSource {
    fun getMovieCards(): List<MovieCard> {
        return listOf(
            MovieCard("Black Widow", 137, "13+", 4),
            MovieCard("Tomorrow", 132, "16+", 3),
            MovieCard("Hi, Mike", 120, "6+", 4),
            MovieCard("The old street", 145, "13+", 5),
            MovieCard("Thirteen Days", 118, "6+", 5),
            MovieCard("Ironclad", 124, "18+", 4),
            MovieCard("Stone", 112, "16+", 4),
            MovieCard("The Oranges", 160, "6+", 5),
            MovieCard("Superman Returns", 121, "6+", 5),
            MovieCard("Due Date", 108, "13+", 5),
            MovieCard("Ghost in the Shell", 95, "18+", 3)
        )
    }
}