package com.madadipouya.example.multiple.datasource.lyrics.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import jakarta.persistence.EntityManagerFactory
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "lyricsEntityManagerFactory",
        transactionManagerRef = "lyricsTransactionManager",
        basePackages = ["com.madadipouya.example.multiple.datasource.lyrics"])
class LyricsDatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource2")
    fun lyricsDatasource(): DataSource = DataSourceBuilder.create().build()

    @Bean(name = ["lyricsTransactionManager"])
    fun lyricsTransactionManager(@Qualifier("lyricsEntityManagerFactory") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory
        return transactionManager
    }

    @Bean(name = ["lyricsEntityManagerFactory"])
    fun lyricsEntityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val entityManager = LocalContainerEntityManagerFactoryBean()
        entityManager.dataSource = lyricsDatasource()
        entityManager.setPackagesToScan("com.madadipouya.example.multiple.datasource.lyrics")
        entityManager.persistenceUnitName = "lyricsDatasource"

        val vendorAdapter = HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(true)
        entityManager.jpaVendorAdapter = vendorAdapter
        return entityManager
    }
}