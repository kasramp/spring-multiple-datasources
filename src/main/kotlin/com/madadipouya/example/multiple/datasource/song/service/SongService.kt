package com.madadipouya.example.multiple.datasource.song.service

import com.madadipouya.example.multiple.datasource.song.entity.Song

interface SongService {

    fun addSong(artistName: String, songName: String, lyricsId: Int) : Song
}