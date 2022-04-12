package ru.hse.my;

import java.util.ArrayList;

/*
    Наследование. Интерфейсы. Перечисления
 */
public class Main {

    public static void main(String[] args) {
        new Point(5,6).show(); // двумерная точка

        new Point3D(1, 2, 3).show(); // трёхмерная точка

        Point p = new Point3D(4, 5, 6); // базовый класс можно использовать как ссылку на всех его потомков
        p.show();

        // массив объектов
        System.out.println("По массиву!");
        AbstractPoint[] pointsArr = {new Point3D(5, 10 ,1), new Point(1, 4), new Point3D(0,1,2)};
        for (AbstractPoint point :
                pointsArr) {
            // только объекты класса Point
            if (!(point instanceof Point3D))
                point.show();
        }

        // зоопарк еба!
        // посчитать сколько всего собак и кошек
        System.out.println("\nЖивотинки");
        Animal[] zoo = {new Cat(), new Cow(), new Dog(), new Dog(), new Cow(),  new Dog(), new Cat(), new Horse(),
                        new Cow(), new Horse()};
        int counter = 0;
        for (Animal a :
                zoo) {
            if (a instanceof Cat || a instanceof Dog) {
                counter++;
                a.talk();
            }
        }
        System.out.printf("Собак и кошек всего: %d", counter);

        // общий интерфейс, можно через интерфейс ссылаться на объекты
        System.out.println("\nИнтерфейс!");
        Showable[] objArr = {new Point3D(5, 10 ,1),
                new Person(),
                new Point(1, 4), new Point3D(0,1,2)};
        for (Showable i :
                objArr) {
            i.show();
        }

        // коллекция обобщённый список
        System.out.println("\nКоллекция нетипизированный список!");
        ArrayList arr = new ArrayList();
        arr.add(5);
        arr.add("test");
        arr.add(3.5);

        for (Object o :
                arr) {
            System.out.println(o);
        }

        // коллекция список целых чисел
        System.out.println("\nКоллекция список целых чисел!");
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        intArr.add(5);
        intArr.add(8);
        intArr.add(10);

        int sum = 0;
        for (int i :
                intArr) {
            System.out.println(i);
            sum+=i;
        }

    }
}
