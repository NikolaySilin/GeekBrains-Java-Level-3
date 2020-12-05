package ru.geekbrains.nikolaysilin.lesson_1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    Integer[] arr = new Integer[10];

    protected void start() {
        isRandomArr(arr);
        swap(arr, 0, 5);
    }

    int random() {
        Integer random = (int) (Math.random() * 11); // генерация случайных чисел для элементов в массиве от 0 до 10
        return random;
    }

    void isRandomArr(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random();
        }
    }

    protected static void swap(Object[] arr, int n1, int n2) {
        System.out.println("Array before moving elements: " + Arrays.toString(arr));
        Object swap = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = swap;
        System.out.println("                 " + "Move result: " + Arrays.toString(arr));
    }

    protected void fromArrayToArrayList() {
        List list = new ArrayList<>(Arrays.asList(arr));
        for (int i = 0; i < arr.length; i++)
            System.out.print(list.get(i) + " ");
        }


}
