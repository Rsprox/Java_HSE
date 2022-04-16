package ru.hse.my.common.users;

import ru.hse.my.common.Interactable;
import ru.hse.my.common.RightsLevel;
import ru.hse.my.common.SystemUser;

import java.util.List;

public class User extends SystemUser implements Interactable {
    protected static List<User> users;
    protected static List<String> posts;

    private RightsLevel level = RightsLevel.USER;
    private String username;
    private String email;
    private String password;

    // конструктор
    User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;

        users.add(this);
    }

    // инициализируем статически несколько инстансов юзеров
    static {
        new User("user1", "user1@example.com", "1234");
        new User("user2", "user2@example.com", "12345");
        new User("user3", "user3@example.com", "123456");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // сохранить запись пользователя
    @Override
    public void createPost(String post, String subject) {
        System.out.println("Не реализовано!");
    }

    // оставить комментарий к записи
    @Override
    public void makeComment(String comment, Integer postID) {
        System.out.println("Не реализовано!");
    }
}
