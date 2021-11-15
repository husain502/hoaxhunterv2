package com.example.hoaxhunterv2.database.remote.hoax

data class detailhoax (
        val id: Int,
        val classification: String,
        val title: String,
        val picture1: String,
        val content: String,
        val fact: String,
        val reference: String,
        val date: Int
        )
