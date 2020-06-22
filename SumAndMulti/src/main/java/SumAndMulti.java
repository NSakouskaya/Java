// Fundamentals: 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль

import java.util.Scanner;

public class SumAndMulti {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter two any numbers:");
        int number1 = s.nextInt();
        int number2 = s.nextInt();

        int sum, multi;
        sum = number1 + number2;
        multi = number1 * number2;
        System.out.println("Sum:" + sum);
        System.out.println("Multiplication:" + multi);
    }
}
