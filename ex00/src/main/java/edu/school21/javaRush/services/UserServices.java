package edu.school21.javaRush.services;

import edu.school21.javaRush.models.User;
import edu.school21.javaRush.models.listModel;
import edu.school21.javaRush.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

//Класс, который будет создавать пользователя, проверять введенные данные и т.п. (класс который работает с данными из класса User)
@Component
public class UserServices {
//    private listModel model = listModel.getInstance();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhoneNumber(phoneNumber);
        if (userRepository.findUserByEmail(email) == null) {
            userRepository.saveUser(user);
            System.out.println("User is created!!");
            return user;
        }
        return null;
    }

    public User login(String email, String password) {
//        listModel model = listModel.getInstance();
//        List<User> list = model.getList();
//        for (User userTmp: list) {
//            System.out.println(userTmp.getEmail());
//        }
        User user = userRepository.findUserByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }
        return user;
    }

    private void validate(String firstName, String lastName, String password, String phoneNumber) {
        if (firstName == null) {

        }
    }
}
