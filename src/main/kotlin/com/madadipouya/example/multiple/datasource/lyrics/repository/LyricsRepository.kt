package com.madadipouya.example.multiple.datasource.lyrics.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LyricsRepository : JpaRepository<LyricsRepository, Int>