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

    fun getCastCards(): List<CastCard> {
        return listOf(
            CastCard(
                "Justin Dru Bieber",
                "https://upload.wikimedia.org/wikipedia/commons/d/d9/Robin_Wright_Cannes_2017_%28cropped%29.jpg"
            ),
            CastCard(
                "Mark Ruffalo",
                "https://upload.wikimedia.org/wikipedia/commons/2/2c/Connie_Nielsen_by_Gage_Skidmore.jpg"
            ),
            CastCard(
                "Robert Downey Jr.",
                "https://st.kp.yandex.net/im/kadr/1/2/4/kinopoisk.ru-Kenneth-Branagh-1241673.jpg"
            ),
            CastCard(
                "Chris Evans",
                "https://upload.wikimedia.org/wikipedia/commons/c/c5/Pedro_Pascal_by_Gage_Skidmore.jpg"
            ),
            CastCard(
                "Blake Jenner",
                "https://upload.wikimedia.org/wikipedia/commons/8/84/David_Harbour_by_Gage_Skidmore.jpg"
            ),
            CastCard(
                "Benedict Cumberbatch",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/Rachel_Weisz_2018.jpg"
            ),
            CastCard(
                "Chris Hemsworth",
                "https://toronto.citynews.ca/wp-content/blogs.dir/sites/10/2019/06/NYET414-618_2019_013921.jpg"
            ),
        )
    }
}