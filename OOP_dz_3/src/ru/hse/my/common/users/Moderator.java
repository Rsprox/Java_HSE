package ru.hse.my.common.users;

import ru.hse.my.common.Interactable;
import ru.hse.my.common.RightsLevel;

import java.util.List;

public class Moderator extends User implements Interactable {
    private List<String> subjects;
    private RightsLevel level = RightsLevel.MODERATOR;

    Moderator(String username, String email, String password) {
        super(username, email, password);
    }

    // перегрузка конструктора
    Moderator(String username, String email, String password, List<String> subjects) {
        super(username, email, password);
        this.subjects = subjects;
    }

    // удалить комментарий пользователя
    public void deleteComment(Integer commentID) {
        System.out.println("Не реализовано!");
    }

    // удалить запись пользователя
    public void deletePost(Integer postID) {
        System.out.println("Не реализовано!");
    }
}
