package edu.school21.javaRush.services;

import edu.school21.javaRush.models.User;
import edu.school21.javaRush.models.listModel;
import edu.school21.javaRush.repositories.UserRepository;

import java.util.List;

//Класс, который будет создавать пользователя, проверять введенные данные и т.п. (класс который работает с данными из класса User)
public class UserServices {
//    private listModel model = listModel.getInstance();

    private UserRepository userRepository = new UserRepository();

    public User createUser(String firstName, String lastName, String email, String password, String phoneNumber) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
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
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    private void validate(String firstName, String lastName, String password, String phoneNumber) {
        if (firstName == null) {

        }
    }
}
