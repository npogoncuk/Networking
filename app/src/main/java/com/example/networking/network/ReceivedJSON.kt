package com.example.networking.network

data class ReceivedJSON(val results: List<User>, val info: info)

data class User(val name: name, val picture: picture)
data class name(val title: String, val first: String, val last: String)
data class picture(val large: String, val medium: String, val thumbnail: String)
data class info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)