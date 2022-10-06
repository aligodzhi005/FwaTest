package edu.school21.javaRush.repositories;

import edu.school21.javaRush.config.ApplicationConfig;
import edu.school21.javaRush.models.User;
import edu.school21.javaRush.models.listModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    private listModel model = listModel.getInstance();;
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Autowired
//    UserRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
    public User findUserByEmail(String email) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", new userMapper(), email);
            return user;
        } catch(Exception e) {
            return null;
        }
    }
    public void saveUser(User user) {
        System.out.println("Before saveUser method");
        try {
            jdbcTemplate.update("INSERT INTO users (firstname, lastname, email, password, phonenumber) VALUES (?, ?, ?, ?, ?)",
                    user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
        } catch (Exception e) {

        }
    }

    private class userMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setFirstName(rs.getString("firstname"));
            user.setLastName(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setPhoneNumber(rs.getString("phonenumber"));
            return user;
        }
    }
}
