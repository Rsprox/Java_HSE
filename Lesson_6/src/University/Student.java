package University;

public class Student {
    // поля класса
    String name;
    String surname;
    private int course; // номер курса инкапсулирован

    // конструктор
    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.course = 1;
    }

    // перегрузка конструктора для курса
    public Student(String name, String surname, int course) {
        this(name, surname); // обращение к существующему конструктору
        this.setCourse(course);
    }

    // геттер
    public int getCourse() {
        return course;
    }

    // сеттер
    public void setCourse(int course) {
        if (course>0 && course<7) {
            this.course = course;
        } else {
            System.out.println("Ошибка! Неподходящий курс!");
        }

    }

    public void show() {
        System.out.printf("%s %s %d курс\n", surname, name, course);
    }

    public static void showClass() {
        System.out.println("Класс Student!");
    }
}
