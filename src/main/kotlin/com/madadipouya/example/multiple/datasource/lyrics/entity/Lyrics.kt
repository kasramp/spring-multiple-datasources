package com.madadipouya.example.multiple.datasource.lyrics.entity

import com.madadipouya.example.multiple.datasource.entity.AbstractJpaPersistable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "lyrics")
open class Lyrics(
        @Column(nullable = false)
        val content: String
) : AbstractJpaPersistable<Int>()