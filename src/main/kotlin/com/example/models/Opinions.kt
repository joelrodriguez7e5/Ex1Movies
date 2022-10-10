package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Opinions (val id: Int, val idMovie: Int, val coment: String)

val opinionStorage = mutableListOf<Opinions>(
    Opinions(19292, 15, "asdasd")
)