package com.madadipouya.example.multiple.datasource.lyrics.service.impl

import com.madadipouya.example.multiple.datasource.lyrics.entity.Lyrics
import com.madadipouya.example.multiple.datasource.lyrics.repository.LyricsRepository
import com.madadipouya.example.multiple.datasource.lyrics.service.LyricsService
import com.madadipouya.example.multiple.datasource.song.entity.Song
import com.madadipouya.example.multiple.datasource.song.service.SongService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DefaultLyricsService(val songService: SongService, val lyricsRepository: LyricsRepository) : LyricsService {

    @Transactional(value = "chainedTransactionManager", rollbackFor = [Exception::class, java.lang.Exception::class])
    override fun addLyrics(artistName: String, songName: String, lyrics: String): Song {
        val lyricsEntity = lyricsRepository.save(Lyrics(lyrics))
        val lyricsId: Int = lyricsEntity.id!!
        return songService.addSong(artistName, songName, lyricsId)
    }
}