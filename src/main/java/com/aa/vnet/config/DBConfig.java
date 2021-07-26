package com.aa.vnet.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(basePackages="com.aa.vnet.repository")
@EnableTransactionManagement
@Slf4j
public class DBConfig
{

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource)
    {
	LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
	entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	entityManager.setJpaProperties(additionalProperties());
	entityManager.setDataSource(dataSource);
	entityManager.setPackagesToScan("com.aa.*");
	entityManager.afterPropertiesSet();
	return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
    {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(entityManagerFactory);
	return transactionManager;
    }


    Properties additionalProperties()
    {
	Properties properties = new Properties();
	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
	properties.setProperty("hibernate.show_sql", String.valueOf(true));
	return properties;
    }



    @Bean(name="dataSource")
    public DataSource dataSource(){
	DataSource ds = null;
	try
	{


	    log.info("Initializing DataSource jdbc/cme-teams");
	    final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	    dataSourceLookup.setResourceRef(true);
	    ds = dataSourceLookup.getDataSource("java:comp/env/jdbc/cme-teams-db");
	} catch (Exception e)
	{
	    log.error("DataSource not loaded error,", e);
	}
	return ds;
    }



}
