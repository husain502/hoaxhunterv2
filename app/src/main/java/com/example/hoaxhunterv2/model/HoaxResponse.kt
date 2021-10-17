package com.example.hoaxhunterv2.model

import com.google.gson.annotations.SerializedName


data class HoaxResponse(
    val id: Int,
    val classification: String,
    val title: String,
    val content: String,
    val fact: String,
    val tanggal: String,
    val conclusion: String,
    val picture1: String
)
