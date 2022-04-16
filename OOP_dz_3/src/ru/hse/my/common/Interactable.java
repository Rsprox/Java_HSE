package ru.hse.my.common;

public interface Interactable {
    void createPost(String post, String subject);
    void makeComment(String comment, Integer postID);
}
