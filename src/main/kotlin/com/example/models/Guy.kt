package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Guy(val id: String, val name: String, val image: String)

val guyList = mutableListOf<Guy>()