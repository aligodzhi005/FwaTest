package edu.school21.javaRush.models;

import java.util.ArrayList;
import java.util.List;

//Singleton для хранения пользователей
public class listModel {
    private static listModel instance = new listModel();

    private List<User> list;
    public static listModel getInstance() {
        return instance;
    }
    private listModel() {
        list = new ArrayList<User>();
    }
    public void add(User user) {
        list.add(user);
    }
    public List<User> getList() {
        return this.list;
    }
}
