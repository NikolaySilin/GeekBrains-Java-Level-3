package ru.geekbrains.nikolaysilin.lesson_7;

public class Main {

    public static void main(String[] args) {
        Class cs = Test_1.class;
        try {
            StartTest.start(cs);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
