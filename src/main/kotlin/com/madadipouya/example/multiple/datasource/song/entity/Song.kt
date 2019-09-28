package com.madadipouya.example.multiple.datasource.song.entity

import javax.persistence.*

@Entity
@Table(name = "songs")
data class Song(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(name = "artist_name", nullable = false)
        val artistName: String,

        @Column(name = "song_name", nullable = false)
        val songName: String,

        @Column(name = "lyrics_id", nullable = false)
        val lyricsId: Int
)


