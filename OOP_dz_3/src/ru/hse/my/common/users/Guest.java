package ru.hse.my.common.users;

import ru.hse.my.common.Interactable;
import ru.hse.my.common.RightsLevel;
import ru.hse.my.common.SystemUser;

public class Guest extends SystemUser implements Interactable {
    private RightsLevel level = RightsLevel.GUEST;

    @Override
    public void createPost(String post, String subject) {
        System.out.println("Только зарегистрированные пользователи могут добавлять записи!");
    }

    @Override
    public void makeComment(String comment, Integer postID) {
        System.out.println("Только зарегистрированные пользователи могут оставлять комментарии!");
    }
}
