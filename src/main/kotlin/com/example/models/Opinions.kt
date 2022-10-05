package com.example.models

data class Coments (val id: String, val idMovie: String, val coment: String)

val opinionStorage = mutableListOf<Coments>(
    Coments("19292", "adas", "asdasd")
)