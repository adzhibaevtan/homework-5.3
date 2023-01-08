package com.pixabay.homework_53.data.model

data class PixaModel(
    var hits: List<ImageModel>?
)

data class ImageModel (
    var largeImageURL: String?
)
