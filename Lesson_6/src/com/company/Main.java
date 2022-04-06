package com.company;

/*
    ООП
 */


// импорт другого пакета
import University.Student; // далее именовать пакеты с маленькой буквы

public class Main {

    public static void main(String[] args) {
        Student s = null;
        s = new Student("Иван", "Иванов");

        Student s1 = new Student("Петр", "Петров", 1);

        s.show();
        s1.show();
        // создание объекта и вызов метода, без сохранения куда-либо
        new Student("Иван_2", "Иванов", 3).show();

        s.setCourse(100); // кривой курс
        s.show();

        Student.showClass(); // статический метод класса
    }
}
