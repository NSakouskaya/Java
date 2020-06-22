//Fundamentals: 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

package com.company;
import java.util.Random;

class RandomNumbers {

    private Random random;
    private int[] arr;

    public RandomNumbers() {
        random =new Random();
        arr = new int[5];
    }

    public void setMyArray(){
        for (int i = 0; i<arr.length; i++){
            arr[i] = random.nextInt();
        }

    }
    public void showMyArray(){
        System.out.print("Random array with 'print' method: ");
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public void showNewlineMyArray(){
        System.out.println("Random array with 'println' method: ");
        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}

