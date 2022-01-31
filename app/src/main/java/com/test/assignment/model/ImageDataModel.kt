package com.test.assignment.model

import com.google.gson.annotations.SerializedName

data class ImageDataModel (

        val photos: List<Photos>,
        val next_page: String,
        val prev_page: String
    )


    data class Photos (
        val photographer: String,
        val alt: String,
        val src: Src,

        @SerializedName("photographer_url")
        val photographerUrl: String


    )
data class Src (
    val medium: String
)
