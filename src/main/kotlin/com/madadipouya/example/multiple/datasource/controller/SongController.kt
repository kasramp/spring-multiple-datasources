package com.madadipouya.example.multiple.datasource.controller

import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/v1/songs")
class SongController {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private fun addSong(@RequestBody @Validated songDto: SongDto) = {
        System.out.println("It works!")
    }


    data class SongDto(@get:NotBlank val artistName: String, @get:NotBlank val songName: String, val lyrics: LyricsDto)
    data class LyricsDto(@get:NotBlank val content: String)
}