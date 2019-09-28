package com.madadipouya.example.multiple.datasource.lyrics.entity

import javax.persistence.*

@Entity
@Table(name = "lyrics")
data class Lyrics(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val content: String
)