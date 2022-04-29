package com.example.cryptocurrency.APIclient.model.shared

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val thumb: String,
    val small: String,
    val large: String? = null,
)