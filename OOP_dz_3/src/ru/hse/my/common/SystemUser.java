package ru.hse.my.common;


public abstract class SystemUser implements Interactable{


    public abstract void createPost(String post, String subject); // выложить запись
    public abstract void makeComment(String comment, Integer postID); // прокомментировать запись
}
