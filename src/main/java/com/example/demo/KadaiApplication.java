package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(
	    scanBasePackages = "com.example.demo.infratest",
	    exclude = {
	        DataSourceAutoConfiguration.class,
	        DataSourceTransactionManagerAutoConfiguration.class,
	        HibernateJpaAutoConfiguration.class,
	        JpaRepositoriesAutoConfiguration.class
	    }
	)
	public class KadaiApplication extends SpringBootServletInitializer {

	    public static void main(String[] args) {
	        SpringApplication.run(KadaiApplication.class, args);
	    }

	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(KadaiApplication.class);
	    }
	}
