//    Fundamentals:    Задание. Ввести n чисел с консоли.
//    1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину. (minMax)
//    2.     Вывести числа в порядке возрастания (убывания) значений их длины. (sortArray)
//    4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них. (minDiffNum)

import java.util.Arrays;

import java.util.HashSet;
import java.util.Scanner;

public class FundamentalsOptionalTask {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int[] arr = new int[scan.nextInt()];

        if ( arr.length == 0) {
            System.out.println("Size of array can not be 0");
            return;
        }

        System.out.println("Insert array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Inserted array elements: " + Arrays.toString(arr));
        minDiffNum(arr);
        System.out.println();
        minMaxNumbersAndLength(arr);
        System.out.println();
        sortArray(arr);

    }

    private static void minDiffNum(int[] arr) {
        int min = diffNum(arr[0]);
        int minElem = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (diffNum(arr[i]) < min) {
                min = diffNum(arr[i]);
                minElem = arr[i];
            }
        }
        System.out.printf("Number in which the count of different digits is minimal: %d", minElem);
    }

    private static int diffNum(int x) {
        HashSet<Integer> numbers = new HashSet<>();
        while (x > 0) {
            numbers.add(x % 10);
            x /= 10;
        }
        return numbers.size();
    }
    private static void minMaxNumbersAndLength(int[] arr) {
        int maxNum, minNum;
        maxNum = minNum = arr[0];
        int maxNumCount, minNumCount;
        maxNumCount = minNumCount = calculateCount(arr[0]);


        for (int a : arr) {
            int count = calculateCount(a);
            if (maxNumCount < count) {
                maxNum = a;
                maxNumCount = count;
            }

            if (minNumCount > count) {
                minNum = a;
                minNumCount = count;
            }
        }

        System.out.format("Min length number %d, count is %d, max length number %d, count is %d", minNum, minNumCount, maxNum, maxNumCount);

    }

    private static int calculateCount(int a) {
        int length = String.valueOf(a).length();
        return length;
    }

    private static void sortArray(int[] arr) {

        int a, b, t;
        for (a=1; a < arr.length; a++)
            for(b=arr.length-1; b >= a; b--) {
                if(arr[b-1] > arr[b]) {

                    t = arr[b-1];
                    arr[b-1] = arr[b];
                    arr[b] = t;
                }
            }
        System.out.println("Sorted the Array: " );
        for(int i = 0; i< arr.length; i++)
            System.out.print(" " + arr[i]);

    }


}
