package com.example.hoaxhunterv2.database.remote

import com.google.gson.annotations.SerializedName

data class modelhoax (

        @field:SerializedName("picture1")
        val picture1: String,

        @field:SerializedName("classification")
        val classification: String,

        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("id")
        val id: String,

        @field:SerializedName("date")
        val date: String
)