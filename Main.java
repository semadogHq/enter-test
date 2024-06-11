import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Создаем экзэмпляр класса чтобы использовать его методы, в скобках in - указывает ввод данных с консоли
        System.out.println("Введите арифметическое выражение:");
        String input = scanner.nextLine(); // Эта строка будет обозначать что мы будем вводить в консоль выражение с клавиатуры
        scanner.close(); // Закрываем ресурс

        try { // Оборачиваем вызов метода calc в блок try-catch так как он может выбросить исключение
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {  // Отлавливаем ошибку в данном блоке и пишем что будет выведено при ошибке
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] parts = input.split(" "); // разбиваем строку input на подстроки, используя пробел в качестве разделителя. Результат разбиения сохраняем в массив строк parts.
        if (parts.length != 3) { // Проверяем чтобы длинна массива не была меньше 3 так как у нас 2 числа и операция - это 3 элемента
           throw new IllegalArgumentException("Некорректное выражение"); // Если меньше то выбрасываем исключение
        }

        int num1 = Integer.parseInt(parts[0]); // Добавляем в массив в нулевой индекс первое число введенное с клавиатуры
        char operator = parts[1].charAt(0); // Добавляем в массив в первый индекс операцию проводимую между числами
        int num2 = Integer.parseInt(parts[2]); // Добавляем в массив во второй  индекс второе число введенное с клавиатуры

        int result;
        checkedNum(num1, num2); // Вызываем метод который проверяет больше ли введенные числа 10
        switch (operator) {   // В зависимости от выбранной операции проводим ту или иную операцию
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль");
                }
                result = num1 / num2;
                break;
            default:  // Если было выбрано что то другое по мимо операций которые выше, выбрасываем исключение
                throw new IllegalArgumentException("Некорректная операция");
        }

        return String.valueOf(result); // Оборачиваем результат операции в String и возвращаем
    }

    public static void checkedNum(Integer num1, Integer num2) {
        if (num1 > 10 || num2 > 10) {
            throw new IllegalArgumentException("Введенное число больше 10");
        }
    }
}

