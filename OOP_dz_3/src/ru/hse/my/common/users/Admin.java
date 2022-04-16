package ru.hse.my.common.users;

import ru.hse.my.common.Interactable;
import ru.hse.my.common.RightsLevel;

public class Admin extends Moderator implements Interactable {
    private RightsLevel level = RightsLevel.ADMIN;

    Admin(String username, String email, String password) {
        super(username, email, password);
    }

    public void deleteUser(String userType) {

    }
}
