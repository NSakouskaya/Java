//Fundamentals:  1. Приветствовать любого пользователя при вводе его имени через командную строку.

import java.util.Scanner;

public class HelloUser {

    public static void main(String[] args) {

        System.out.println( "Input your name: " );
        Scanner scan = new Scanner(System.in);
        String phrase = scan.next();
        System.out.println( "Hello" + " " + phrase);
    }
}
