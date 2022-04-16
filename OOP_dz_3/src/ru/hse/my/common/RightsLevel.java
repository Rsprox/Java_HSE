package ru.hse.my.common;

public enum RightsLevel {

    GUEST ("Неавторизованный пользователь"),
    USER ("Зарегистрированный пользователь"),
    MODERATOR ("Модератор"),
    ADMIN ("Администратор");

    private String title;

    RightsLevel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "RightsLevel{" +
                "title='" + title + '\'' +
                '}';
    }
}
