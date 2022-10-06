package edu.school21.javaRush.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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
//@ComponentScan(basePackages = "edu.school21.javaRush")
public class ApplicationConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate(dataSource());

//        String schema = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/schema.sql")), StandardCharsets.UTF_8);
//        String data = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/data.sql")), StandardCharsets.UTF_8);
//        template.execute(schema);
//        template.execute(data);

        return template;
    }
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig("src/main/webapp/WEB-INF/application.properties");

        return new HikariDataSource(config);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
