import java.util.Scanner;
/**
 * @author RusskikhAV
 * в данной программе я реализовал
 * @see Task#menu() - некое меню из которого мы можем выбрать алгоритм, который хотим протестировать
 * @see Task#firstAlgorithm() - метод в котором мы проверяем работу алгоритма, в каждом из методов,
 * в цикле считыватся данные и проверяются согласно алгоритму, что-бы выйти из работы алгоритма введите "Выход"
 *
 *
 */
public class Task {
    Scanner scanner = new Scanner(System.in);
    String firstAlgorithmDescription = "Алгоритм №1: если введенное число больше 7, то вывести \"Привет\"";
    String secondAlgorithmDescription = "Алгоритм №2: если введенное имя совпадает с Вячеслав, то вывести \"Привет, " +
            "Вячеслав\", если нет, то вывести \"Нет такого имени\"";
    String thirdAlgorithmDescription = "Алгоритм №3: на входе есть числовой массив, " +
            "необходимо вывести элементы массива кратные 3";
    String exit = "Что бы перейти в меню выбора алгоритма введите \"Выход\"";
    String exitWord = "Выход";

    public static void main(String[] args) {
        Task task = new Task();
        task.menu();

    }

    private void menu() {
        System.out.println(firstAlgorithmDescription + "\n" + secondAlgorithmDescription + "\n" + thirdAlgorithmDescription);

        while (true) {
            System.out.print("Введите номер алгоритма: ");
            String numberOfAlgorithm = "";
            try {
                numberOfAlgorithm = scanner.nextLine();
            } catch (NumberFormatException nfe) {
                 System.out.println("Вы ввели некорректное значение");
            }

            switch (numberOfAlgorithm) {
                case "1":
                    firstAlgorithm();
                    break;
                case "2":
                    secondAlgorithm();
                    break;
                case "3":
                    thirdAlgorithm();
                    break;
                default:
                    if (numberOfAlgorithm.equalsIgnoreCase(exitWord)) {
                        System.out.println("-----------------------------------------------------------\n");
                        return;
                    } else System.out.println("Такого алгоритма не существует, введите номер от 1 до 3");
            }
        }
    }

    private void firstAlgorithm() {
        System.out.println(firstAlgorithmDescription);
        System.out.println(exit);

        while (true) {
            System.out.print("Введите число:");
            String inputString = scanner.nextLine();
            try {
                this.compareInt(Integer.parseInt(inputString));
            } catch (NumberFormatException nfe) {
                if (inputString.equalsIgnoreCase(exitWord)) {
                    System.out.println("-----------------------------------------------------------\n");
                    menu();
                    return;
                } else System.out.println("Вы ввели некорректное значение");
            }
        }

    }

    private void secondAlgorithm() {
        System.out.println(secondAlgorithmDescription);
        System.out.println(exit);

        while (true) {
            System.out.print("Введите строку: ");
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase(exitWord)) {
                System.out.println("-----------------------------------------------------------\n");
                menu();
            }
            this.compareString(inputString);
        }
    }

    private void thirdAlgorithm() {
        System.out.println(thirdAlgorithmDescription);
        System.out.println(exit);

        while (true) {
            System.out.print("Введите целые числа элементы массива, друг за другом через пробел: ");
            String input = scanner.nextLine();
            var stringArray = input.split(" ");
            int[] b = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                try {
                    b[i] = Integer.parseInt(stringArray[i]);
                } catch (NumberFormatException nfe) {
                    if (input.equalsIgnoreCase(exitWord)) {
                        System.out.println("-----------------------------------------------------------\n");
                        menu();
                    }
                    System.out.println("Введите только целые числа");
                    thirdAlgorithm();
                }
            }
            isDivideОfThree(b);

        }
    }

    public void compareInt(int a) {
        if (a > 7) {
            System.out.println("Привет");
        }
    }

    public void compareString(String str) {
        String name = "Вячеслав";
        System.out.println(str.equals(name) ? String.format("Привет, %s", name) : "Нет такого имени");

// имя можно так же сравнить игнорируя регистр
//        System.out.println(str.equalsIgnoreCase(name) ? String.format("Привет, %s\n", name) : "Нет такого имени");

    }

    public void isDivideОfThree(int[] array) {
        for (int j : array) {
            if (j % 3 == 0 && j != 0)
                System.out.println(j);
        }
    }
}
