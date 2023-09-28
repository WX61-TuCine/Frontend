package com.example.tucineapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tucineapp.models.Movie
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselGravity
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.model.CarouselType



class MainActivity : AppCompatActivity() {
    var Movies = mutableListOf<Movie>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        loadMovies()
        loadCarrousel()
    }

    private fun loadMovies() {
        //Add movies to Movies
        this.Movies.add(Movie(1, "THE WAY OF THE WATER", "https://i.pinimg.com/originals/91/1a/2d/911a2db55ff3a1faa44a7e766b9a1b3e.jpg"))
        this.Movies.add(Movie(2,"PUSS IN BOTS", "https://i.imgur.com/hql5Z4x.png"))
        this.Movies.add(Movie(3, "FAST & FURIOS X", "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/VW6GWH7SPFG67A4SJP3E7KVBTI.jpeg"))
        this.Movies.add(Movie(4, "ELEMENTAL", "https://mx.web.img3.acsta.net/r_1280_720/pictures/22/09/10/02/56/2741769.jpg"))
        this.Movies.add(Movie(5, "DOCTOR STRANGE","https://m.media-amazon.com/images/M/MV5BNWM0ZGJlMzMtZmYwMi00NzI3LTgzMzMtNjMzNjliNDRmZmFlXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_.jpg"))
    }

    private fun loadCarrousel() {
        val carousel: ImageCarousel = findViewById(R.id.carousel)
        carousel.carouselType = CarouselType.SHOWCASE
        carousel.scaleOnScroll = true
        carousel.scalingFactor = 0.2f // 0 to 1; 1 means 100
        carousel.autoWidthFixing = true
        carousel.showTopShadow = false
        carousel.showBottomShadow = false
        carousel.carouselGravity = CarouselGravity.CENTER
        carousel.showNavigationButtons = false

        for (movie in this.Movies) {
            carousel.addData(CarouselItem(movie.urlImage))
        }
    }

    private fun loadData() {
        val tvCineClubName = findViewById<TextView>(R.id.tvCineClubName)
        tvCineClubName.text = "LimaPark"
        val tvLocationCineClubName = findViewById<TextView>(R.id.tvLocationCineClubName)
        tvLocationCineClubName.text = "San Miguel 15666"
        val ivPerfilCineClub = findViewById<ImageView>(R.id.ivPerfilCineClub)
        ivPerfilCineClub.setImageResource(R.drawable.lima_park_logo)

        val ivPerfil = findViewById<ImageView>(R.id.ivPerfil)
        ivPerfil.setImageResource(R.drawable.perfil)


        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = "Hola, Ferrucio Tuccine!"

    }
}