package com.madadipouya.example.multiple.datasource.song.repository

import com.madadipouya.example.multiple.datasource.song.entity.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : JpaRepository<Song, Int>