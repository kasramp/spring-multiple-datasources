package com.madadipouya.example.multiple.datasource.lyrics.entity

import com.madadipouya.example.multiple.datasource.entity.AbstractJpaPersistable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "lyrics")
open class Lyrics(
        @Column(nullable = false)
        open val content: String
) : AbstractJpaPersistable<Int>()