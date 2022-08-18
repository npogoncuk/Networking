package com.example.networking.network

data class ReceivedJSON(val results: List<User>, val info: Info)

data class User(val name: Name, val picture: Picture)
data class Name(val title: String, val first: String, val last: String)
data class Picture(val large: String, val medium: String, val thumbnail: String)
data class Info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)