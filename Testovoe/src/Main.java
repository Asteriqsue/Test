import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение");
        String a;
        a = s.nextLine();
        System.out.println(calc(a));
    }
    public static String calc(String input) {
        int sc = 0;
        char c = 'c';
        String[] parts = input.split("[+\\-*/]");
        if (parts.length < 2 || parts.length >= 3) {
            throw new RuntimeException("Неверный формат операции, 2 операнда, одна операция");
        }
        String part1 = parts[0];
        String part2 = parts[1];
        part1 = part1.replaceAll(" ", "");
        part2 = part2.replaceAll(" ", "");
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                c = input.charAt(i);
                sc++;
            }
        }
        Integer num1;
        Integer num2;
        try {
            num1 = Integer.parseInt(part1);
        }
            catch(Exception exception)
            {
            throw new RuntimeException("Неверный формат операнда номер 1");
        }

        try {
            num2 = Integer.parseInt(part2);
        }
        catch(Exception exception)
        {
            throw new RuntimeException("Неверный формат операнда номер 2S");
        }
        if (sc != 1) {
            throw new RuntimeException("Неверный формат выражения, два операнда, одна операция");
        }

        if (num1 > 10 || num1 < 1 ) {
            throw new RuntimeException("Неверный формат операнда номер 1");
        }

        if (num2 > 10 || num2 < 1 ) {
            throw new RuntimeException("Неверный формат операнда номер 2");
        }
        Integer res = null;
        switch (c) {
            case ('+'):
                res = (num1 + num2);
                break;
            case ('-'):
                res = (num1 - num2);
                break;
            case ('*'):
                res = ((num1 * num2));
                break;
            case ('/'):
                res = (num1 / num2);
                break;
        }
        return res.toString();
    }
}
