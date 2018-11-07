package com.company;


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println("Ведите номер Задания для проверки:\n" +
                "1. Приветствовать любого пользователя при вводе его имени через командную строку.\n" +
                "2. Отобразить в окне консоли аргументы командной строки в обратном порядке.\n" +
                "3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.\n" +
                "4. Ввести пароль из командной строки и сравнить его со строкой-образцом.\n" +
                "5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.\n" +
                "6. Ввести с консоли n целых чисел. На консоль вывести:\n" +
                "   - Четные и нечетные числа.\n" +
                "   - Числа, которые делятся на 3 или на 9.\n" +
                "   - Числа, которые делятся на 5 и на 7.\n" +
                "   - Наибольшее и наименьшее число.\n" +
                "   - Элементы, которые равны полусумме соседних элементов.\n" +
                "7. Ввести с консоли n целых чисел. На консоль вывести:\n" +
                "   - Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.\n" +
                "8. Ввести с консоли n целых чисел. На консоль вывести «Счастливые» числа."
        );

        int a = System.in.read();
        int b = Integer.parseInt(String.valueOf((char) a));
        switch (b) {
            case 1:
                getName();
                break;
            case 2:
                getSysArgsBackwards(args);
                break;
            case 3:
                get50RandomInts();
                break;
            case 4:
                getPasswordCheck();
                break;
            case 5:
                getArgsData(args);
                break;
            case 6:
                getWorkWithNumbers();
                break;
            case 7:
                ThreeDigitNumbers();
                break;
            case 8:
                HappyNumbers();
        }
    }

    private static void HappyNumbers() {
        int n = 6;
        String[] a = new String[n];
        String hd = "Счастливые числа: ";

        for (int i = 0; i < a.length; i++) {
            System.out.println("Введите целое число и жмакните Enter:");
            Scanner digit = new Scanner(System.in);
            a[i] = digit.next();
            byte[] b = a[i].getBytes();
            int suml = 0;
            int sumr = 0;
            for (int j = 0; j < b.length / 2; j++) {
                byte[] c = new byte[1];
                c[0] = b[j];
                String p = new String(c);
                suml += Integer.parseInt(p);
            }

            for (int y = b.length - 1; y > (b.length - 1) / 2; y--) {
                byte[] c = new byte[1];
                c[0] = b[y];
                String p = new String(c);
                sumr += Integer.parseInt(p);
            }
            if (b.length % 2 != 0) {
                System.out.println("Колличество символов во введенном числе нечетное, такое число не может быть счастливым");
            } else {
                if (suml == sumr) hd += a[i] + " ";
            }
        }
        System.out.println(hd);
    }

    private static void ThreeDigitNumbers() {
        int n = 6;
        String[] a = new String[n];
        String dd = "Числа, в десятичной записи которых нет одинаковых цифр: ";
        for (int i = 0; i < a.length; i++) {
            System.out.println("Введите целое число и жмакните Enter:");
            Scanner digit = new Scanner(System.in);
            a[i] = digit.next();
            byte[] b = a[i].getBytes();
            int c = 0;
            if (b.length == 3) {
                if (b[0] != b[1] && b[1] != b[2] && b[2] != b[0]) dd += a[i] + " ";
            } else {
                System.out.println("Во введенном числе не три знака");
            }

        }
        System.out.println(dd);
    }

    private static void getWorkWithNumbers() {
        int n = 6;
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.println("Введите целое число и жмакните Enter:");
            Scanner digit = new Scanner(System.in);
            a[i] = Integer.parseInt(digit.next());
        }

        System.out.println(Arrays.toString(a));
        String ch = "Четные числа: ";
        String nech = "Нечетные числа: ";
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                ch += a[i] + " ";
            } else {
                nech += a[i] + " ";
            }
        }
        System.out.println(ch);
        System.out.println(nech);

        String dev39 = "Кратные 9 или 3: ";
        String dev57 = "Кратные 5 и 7: ";
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 3 == 0 || a[i] % 9 == 0) {
                dev39 += a[i] + " ";
            } else if (a[i] % 5 == 0 && a[i] % 7 == 0) {
                dev57 += a[i] + " ";
            }
        }
        System.out.println(dev39);
        System.out.println(dev57);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp;
                if (a[j] > a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Наибольшее число = " + a[a.length - 1] + "\n" + "Наименьшее число = " + a[0]);

        String hsum = "Элементы, которые равны полусумме соседних элементов: ";
        for (int i = 1; i < a.length - 1; i++) {
            if ((a[i - 1] + a[i + 1]) / 2 == a[i]) {
                hsum += a[i] + " ";
            }
        }
        System.out.println(hsum);

    }

    private static void getArgsData(String[] args) {
        int sumarg = 0;
        int prarg = 1;
        int tsum;
        for (int i = 0; i < args.length; i++) {
            sumarg += Integer.parseInt(String.valueOf(args[i]));

        }
        for (int i = 0; i < args.length - 1; i++) {
            tsum = Integer.parseInt(String.valueOf(args[i])) + Integer.parseInt(String.valueOf(args[i + 1]));
            System.out.println("tsum = " + tsum);
        }
        for (int j = 0; j < args.length; j++) {
            prarg *= Integer.parseInt(String.valueOf(args[j]));

        }
        for (int j = 0; j < args.length - 1; j++) {
            System.out.println("tprod = " + Integer.parseInt(String.valueOf(args[j])) * Integer.parseInt(String.valueOf(args[j])));
        }
        System.out.println("sumarg = " + sumarg);
        System.out.println("prarg = " + prarg);
    }

    private static void getPasswordCheck() {
        System.out.println("введите пароль и нажмите Enter:");
        String pass = "aaaa";
        Scanner password = new Scanner(System.in);
        String input = password.next();

        if (pass.equals(input)) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль неверный");
        }
    }

    private static void get50RandomInts() {
        String numbers = new Random().ints(0, 100).limit(50).mapToObj(v -> "\n" + (int) v).collect(Collectors.joining());
        System.out.println("numbers = " + numbers);
    }

    private static void getSysArgsBackwards(String[] args) {
        for (int x = args.length - 1; x >= 0; x--) {
            System.out.println("args = " + args[x]);
        }
    }

    private static void getName() {
        System.out.println("А как вас зовут? (Напишите и жмакните Enter)");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Приветули, " + name);
    }
}
