package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Movies(val id: String, val titol: String, val any: Int, val genere: String, val director: String, val idMovie: String)

val customerStorage = mutableListOf<Movies>()

