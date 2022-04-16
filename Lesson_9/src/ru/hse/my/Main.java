package ru.hse.my;

/*
    Исключения
 */
public class Main {
    // если выбрасываем новое исключение, то надо прописать
    private static void subroutine() throws Exception {
        int a = 5;
        int b = 0; // для деления на 0
        String s = "test"; // нет строки для ошибки

        try {

            int c = a / b + s.length();
            System.out.println(c);
        }
        // ошибка с арифметикой, к примеру деление на 0
        catch (ArithmeticException e) {
            System.out.println("Error! " + e.getMessage());
            // e.printStackTrace();
            throw new Exception("Всё плохо!", e); // выбрасываем исключение к вызывающему методу
        }


    }

    public static void main(String[] args) {

        try {
            subroutine(); // вызов метода с возможным исключением должен быть либо в try, либо объявлено пробрасывание исключения наверх
        }
        // обобщённое исключение - строки не существует
        catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            System.out.println("Программа завершена!");
        }

    }
}
