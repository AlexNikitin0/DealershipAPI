package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

    @Component
    public class DbConfiguration {

        private BasicDataSource basicDataSource;

        @Bean
        public DataSource dataSource() {
            return basicDataSource;
        }

        public DbConfiguration(@Value("${datasource.url}") String url,
                               @Value("${datasource.username}") String username,
                               @Value("${datasource.password}") String password
        ) {
            basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);
        }

    }

