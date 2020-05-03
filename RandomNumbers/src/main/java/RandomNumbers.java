package com.company;

//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

import java.util.Arrays;
import java.util.Random;


class RandomNumbers {

    Random random = new Random();
    int[] arr = new int[5];


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

