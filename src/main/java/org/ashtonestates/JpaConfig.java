/*
 *
 */
package org.ashtonestates;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(basePackages = { "org.ashtonestates.repository" })
@EnableTransactionManagement
@Slf4j
public class JpaConfig {

	@Bean(name = "passwordEncoder")
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Entity manager factory.
	 *
	 * @return the local container entity manager factory bean
	 */
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getProdEntityManagerFactory(final DataSource dataSource) {
		return createEntityManagerFactoryBean(dataSource, getHibernateDialect());
	}

	/**
	 * Transaction manager.
	 *
	 * @param entityManagerFactory
	 *            the entity manager factory
	 * @return the jpa transaction manager
	 */
	@Bean(name = "transactionManager")
	public JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean(name = "dataSource")
	@Profile("development")
	public DataSource getDevDataSource() {
		log.debug("*** Using development datasource");
		final DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		ds.setUrl("jdbc:mysql://localhost:3306/ashtones_hoa?useSSL=false");
		ds.setUsername("ashtones_hoaUser");
		ds.setPassword("Ashton3states!");
		return ds;
	}

	@Bean(name = "dataSource")
	@Profile("production")
	public DataSource getProdDataSource() {
		log.debug("*** Using production datasource");
		final DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		ds.setUrl("jdbc:mysql://ashtonestates.org:3306/ashtones_hoa?useSSL=false");
		ds.setUsername("ashtones_hoaUser");
		ds.setPassword("Ashton3states!");
		return ds;
	}

	/**
	 * Gets the hibernate dialect.
	 *
	 * @return the hibernate dialect
	 */
	protected String getHibernateDialect() {
		return MySQL5InnoDBDialect.class.getName();
	}

	/**
	 * Creates the entity manager factory bean and sets the model classes to persist
	 *
	 * @param dataSource
	 *            the data source
	 * @param dialectClassName
	 *            the dialect class name
	 * @return the local container entity manager factory bean
	 */
	protected LocalContainerEntityManagerFactoryBean createEntityManagerFactoryBean(final DataSource dataSource, final String dialectClassName) {
		final Map<String, String> properties = new HashMap<>();
		properties.put(org.hibernate.cfg.Environment.DIALECT, dialectClassName);
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, "false");
		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");

		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { "org.ashtonestates.model" });
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		em.setJpaPropertyMap(properties);
		em.setJpaVendorAdapter(jpaVendorAdapter);

		em.afterPropertiesSet();
		return em;
	}

	/**
	 * Exception translation.
	 *
	 * @return the persistence exception translation post processor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}