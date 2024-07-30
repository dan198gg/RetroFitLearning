package com.example.retrofitlearning.datauser

data class DataPostUser(
    val expiresInMins: Int,
    val password: String,
    val username: String
)