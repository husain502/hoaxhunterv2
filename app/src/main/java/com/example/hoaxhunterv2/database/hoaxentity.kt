package com.example.hoaxhunterv2.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hoax")
data class hoaxentity (
        @PrimaryKey
        var id: Int,
        var classification: String,
        var title: String,
        var content: String,
        var fact: String,
        var tanggal: String,
        var conclusion: String,
        var picture1: String
        )