package com.example.frontend

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class PeliculaAdapter(var peliculas: ArrayList<Pelicula>): Adapter<PeliculaPrototype>() {
    //Crea el prototypo para cada Registro
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaPrototype {
        val view = LayoutInflater.from(
            parent.context).inflate(R.layout.prototype_cartelera, parent, false)
        return PeliculaPrototype(view)
    }

    //Vincula la información de cada Registro
    override fun onBindViewHolder(holder: PeliculaPrototype, position: Int) {
        holder.bind(peliculas.get(position))

    }

    //Controla el tamaño
    override fun getItemCount(): Int {
        return peliculas.size
    }

}

class PeliculaPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvTituloP = itemView.findViewById<TextView>(R.id.tvTituloP)
    val tvCategorias = itemView.findViewById<TextView>(R.id.tvCategorias)

    fun bind(pelicula: Pelicula){
        tvTituloP.text=pelicula.titulo
        tvCategorias.text=pelicula.categorias
    }
}
