package com.example.frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CinemaSelection : AppCompatActivity() {

    var peliculas = ArrayList<Pelicula>()
    var peliculaAdapter = PeliculaAdapter(peliculas)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinema_selection)

        loadPeliculas()

        initView()
    }

    private fun initView() {
        val rvAgendaPeliculas = findViewById<RecyclerView>(R.id.rvPeliculasCartelera)
        rvAgendaPeliculas.adapter = peliculaAdapter
        rvAgendaPeliculas.layoutManager = LinearLayoutManager(this)
    }

    private fun loadPeliculas() {
        peliculas.add(Pelicula("Todo en todas partes al mismo tiempo", "C1, C2, C3"))
        peliculas.add(Pelicula("El gato con botas", "C1, C2, C3"))
        peliculas.add(Pelicula("Sound of Freedom", "C1, C2, C3"))
    }
}