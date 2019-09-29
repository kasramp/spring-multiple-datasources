package com.madadipouya.example.multiple.datasource.song.service.impl

import com.madadipouya.example.multiple.datasource.song.entity.Song
import com.madadipouya.example.multiple.datasource.song.repository.SongRepository
import com.madadipouya.example.multiple.datasource.song.service.SongService
import org.springframework.stereotype.Service

@Service
class DefaultSongService(val songRepository: SongRepository) : SongService {

    override fun addSong(artistName: String, songName: String, lyricsId: Int): Song {
        return songRepository.save(Song(artistName, songName, lyricsId))
    }
}