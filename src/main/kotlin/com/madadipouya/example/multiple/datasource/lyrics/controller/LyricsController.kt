package com.madadipouya.example.multiple.datasource.lyrics.controller

import com.madadipouya.example.multiple.datasource.lyrics.service.LyricsService
import com.madadipouya.example.multiple.datasource.song.entity.Song
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import jakarta.validation.constraints.NotBlank

@RestController
@RequestMapping("/v1/lyrics")
class LyricsController(val lyricsService: LyricsService) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private fun addLyrics(@RequestBody @Validated songMetaData: SongMetaData): Song {
        return lyricsService.addLyrics(songMetaData.artistName, songMetaData.songName, songMetaData.lyrics.content)
    }

    data class SongMetaData(@get:NotBlank val artistName: String, @get:NotBlank val songName: String, val lyrics: LyricsDto)
    data class LyricsDto(@get:NotBlank val content: String)
}