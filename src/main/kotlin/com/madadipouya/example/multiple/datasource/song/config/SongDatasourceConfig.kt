package com.madadipouya.example.multiple.datasource.song.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "songEntityManagerFactory",
        transactionManagerRef = "songTransactionManager")
class SongDatasourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    fun songDatasource(): DataSource = DataSourceBuilder.create().build()

    @Bean(name = ["songTransactionManager"])
    @Primary
    fun songTransactionManager(dataSource1EntityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = dataSource1EntityManagerFactory
        return transactionManager
    }

    @Bean(name = ["songEntityManagerFactory"])
    @Primary
    fun songEntityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val entityManager = LocalContainerEntityManagerFactoryBean()
        entityManager.dataSource = songDatasource()
        entityManager.setPackagesToScan("com.madadipouya.example.multiple.datasource.song")
        entityManager.persistenceUnitName = "songDatasource"

        val vendorAdapter = HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl(true)
        entityManager.jpaVendorAdapter = vendorAdapter
        return entityManager
    }
}