package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(val id: Int,
                  val titol: String,
                  val any: Int,
                  val genere: String,
                  val director: String,
                  val idMovie: Int)

val movieStorage = mutableListOf<Movie>(
    Movie(22, "FastAndFurious", 2015, "Accion", "Jan LI", 85),
    Movie(29, "Matrix", 2010, "Accion", "Neo", 50))

