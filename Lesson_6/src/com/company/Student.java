package com.company;

public class Student {
    // поля класса
    String name;
    String surname;
    int course; // номер курса

    // конструктор
    Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // перегрузка конструктора для курса
    Student(String name, String surname, int course) {
        this(name, surname); // обращение к существующему конструктору
        this.course = course;
    }

    void show() {
        System.out.printf("%s %s %d курс\n", surname, name, course);
    }
}
