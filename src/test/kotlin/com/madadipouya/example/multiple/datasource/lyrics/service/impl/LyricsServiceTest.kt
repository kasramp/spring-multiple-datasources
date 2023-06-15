package com.madadipouya.example.multiple.datasource.lyrics.service.impl

import com.madadipouya.example.multiple.datasource.lyrics.repository.LyricsRepository
import com.madadipouya.example.multiple.datasource.song.repository.SongRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@Testcontainers
@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class LyricsServiceTest {

    companion object {
        @Container
        private val mysqlContainer = MySQLContainer(DockerImageName.parse("mysql:8.0.33"))

        @Container
        private val postgresqlContainer = PostgreSQLContainer(DockerImageName.parse("postgres:15.3"))

        @JvmStatic
        @DynamicPropertySource
        fun dataSourcesProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.jdbcUrl") { mysqlContainer.jdbcUrl }
            registry.add("spring.datasource.username") { mysqlContainer.username }
            registry.add("spring.datasource.password") { mysqlContainer.password }

            registry.add("spring.datasource2.jdbcUrl") { postgresqlContainer.jdbcUrl }
            registry.add("spring.datasource2.username") { postgresqlContainer.username }
            registry.add("spring.datasource2.password") { postgresqlContainer.password }
        }
    }

    @Autowired
    lateinit var lyricsService: DefaultLyricsService

    @Autowired
    lateinit var songRepository: SongRepository

    @Autowired
    lateinit var lyricsRepository: LyricsRepository

    @Test
    fun `should insert a song with lyrics to two datasources`() {
        val result = lyricsService.addLyrics("Nightwish", "Two for Tragedy", getTwoForTragedyLyrics())

        result.id?.let {
            assertTrue(songRepository.existsById(it))
        }
        assertTrue(lyricsRepository.existsById(result.lyricsId))

        assertEquals(1, songRepository.findAll().size)
        assertEquals(1, lyricsRepository.findAll().size)
    }

    fun getTwoForTragedyLyrics() = """
        Sleep Eden sleep
        My fallen son
        Slumber in peace
        
        Cease the pain
        Life's just in vain
        For us to gain
        Nothing but all the same
        
        No healing hand
        For your disease
        Drinking scorn like water
        Cascading with my tears
        
        Beneath the candle bed
        Two saddened angels - in heaven, in death
        
        Now let us lie
        Sad we lived sad we die
        Even in your pride
        I never blamed you
        
        A mother's love
        Is a sacrifice
        Together sleeping
        Keeping it all
        No sympathy
        No eternity
        One light for each undeserved tear
        Beneath the candle bed
        Two souls with everything yet to be said
        """
}