package com.example.cryptocurrency.APIclient.model.coins.data

import kotlinx.serialization.Serializable

@Serializable
data class ReposUrl(
    val github: List<String>,
    val bitbucket: List<String>
)