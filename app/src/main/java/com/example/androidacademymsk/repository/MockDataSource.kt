package com.example.androidacademymsk.repository

class MockDataSource {
    fun getMovieCards(): List<MovieCard> {
        return listOf(
            MovieCard(
                "Black Widow",
                137,
                "13+",
                4,
                "https://pbs.twimg.com/media/EP0DkmiWkAAJMm5.jpg"
            ),
            MovieCard(
                "Tomorrow",
                132,
                "16+",
                3,
                "https://ros-serial.online/uploads/posts/2020-07/1594236243-309999380-voroniny-smotret.jpg"
            ),
            MovieCard(
                "Hi, Mike",
                120,
                "6+",
                4,
                "https://otvet.imgsmail.ru/download/94682245_2ad18d8e09dd221760b8896defe7d891_800.jpg"
            ),
            MovieCard(
                "The old street",
                145,
                "13+",
                5,
                "https://images.iptv.rt.ru/sdp/nc-poster1579792121559.jpg"
            ),
            MovieCard(
                "Thirteen Days",
                118,
                "6+",
                5,
                "https://filmaghd.website/uploads/posts/2019-11/1572683340-1903242084.jpg"
            ),
            MovieCard(
                "Ironclad",
                124,
                "18+",
                4,
                "https://tvbesedka.com/resized/450/upload/2017/4/10/21/42/44/483cf5d7-d12f-4ece-8390-95e9ff01f737.jpg"
            ),
            MovieCard("Stone", 112, "16+", 4, "https://kinos.do.am/_ld/0/39949696.jpg"),
            MovieCard(
                "The Oranges",
                160,
                "6+",
                5,
                "https://www.vokrug.tv/pic/product/a/4/7/8/a478cd2bbc5079769a8083a1e5fbb087.jpeg"
            ),
            MovieCard(
                "Superman Returns",
                121,
                "6+",
                5,
                "https://artworks.thetvdb.com/banners/series/309235/seasons/788319/posters/62028073_t.jpg"
            ),
            MovieCard(
                "Wide card for testing",
                100,
                "6+",
                5,
                "https://i.ytimg.com/vi/kUsEzL3VXKA/maxresdefault.jpg"
            )
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