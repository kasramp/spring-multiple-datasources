package com.madadipouya.example.multiple.datasource.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.transaction.ChainedTransactionManager
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class ChainedTransactionManagerConfig {

    @Bean(name = ["chainedTransactionManager"])
    fun createChainedTransactionManager(@Qualifier("lyricsTransactionManager") lyricsEntityManagerFactory: PlatformTransactionManager,
                                        @Qualifier("songTransactionManager") songsEntityManagerFactory: PlatformTransactionManager): ChainedTransactionManager {
        return ChainedTransactionManager(lyricsEntityManagerFactory, songsEntityManagerFactory)
    }
}