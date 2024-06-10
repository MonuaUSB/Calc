import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами. Введите выражение (например, 2 + 2):");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    public static String calc(String input) throws Exception {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new Exception("Неверный формат выражения");
        }

        int num1 = parseNumber(tokens[0]);
        int num2 = parseNumber(tokens[2]);
        String operator = tokens[1];

        int result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new Exception("Неверный оператор");
        };
        return Integer.toString(result);
    }

    private static int parseNumber(String str) throws Exception {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат числа");
        }
        if (num < 1 || num > 10) {
            throw new Exception("Число вне допустимого диапазона (1-10)");
        }
        return num;
    }
}