package com.madadipouya.example.multiple.datasource.lyrics.service

import com.madadipouya.example.multiple.datasource.song.entity.Song

interface LyricsService {

    fun addLyrics(artistName: String, songName: String, lyrics: String): Song
}