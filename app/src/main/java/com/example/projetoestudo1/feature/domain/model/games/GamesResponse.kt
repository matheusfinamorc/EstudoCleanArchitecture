package com.example.projetoestudo1.feature.domain.model.games

import java.io.Serializable

data class GamesResponse(
    val title: String = "",
    val thumbnail: String = "",
    val short_description: String = "",
    val platform: String = "",
    var expandable: Boolean = false
): Serializable
