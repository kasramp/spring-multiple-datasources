package com.madadipouya.example.multiple.datasource.song.entity

import com.madadipouya.example.multiple.datasource.entity.AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "songs")
class Song(
        @Column(name = "artist_name", nullable = false)
        val artistName: String,

        @Column(name = "song_name", nullable = false)
        val songName: String,

        @Column(name = "lyrics_id", nullable = false)
        val lyricsId: Int
) : AbstractJpaPersistable<Int>()