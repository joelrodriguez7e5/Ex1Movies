package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(val id: String,
                  val titol: String,
                  val any: Int,
                  val genere: String,
                  val director: String,
                  val idMovie: String)

val movieStorage = mutableListOf<Movie>(
    Movie("292", "Hola", 29292, "idk", "director", "92"),
    Movie("292", "Hola", 29292, "idk", "director", "92"))

