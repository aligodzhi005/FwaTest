package edu.school21.javaRush.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "edu.school21.javaRush")
//@PropertySource("src/main/webapp/WEB-INF/application.properties")
public class ApplicationConfig {

//    @Autowired
//    private Environment environment;
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${userName}")
    private String userName;
    @Value("${userPassword}")
    private String userPassword;
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setConnectionProperties("");

        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("root");

        return driverManagerDataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
