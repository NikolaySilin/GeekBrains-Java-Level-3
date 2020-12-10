package ru.geekbrains.nikolaysilin.lesson_1_update;

import ru.geekbrains.nikolaysilin.lesson_1_update.exercisewithfruits.*;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

2. Написать метод, который преобразует массив в ArrayList;

3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f,
не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */

public class Main {

    public static void main(String[] args) {

    App app = new App();

        System.out.println("Exercise 1: ");
        app.start();
        System.out.println("=============================================================");
        System.out.println("Exercise 2: ");
        app.fromArrayToArrayList();
        System.out.println("\n" + "=============================================================");

        System.out.println("Exercise 3: ");

        //создаю обьекты(т.е. ящики, корзины, коробки).
        Box<Orange> orangeBox_1 = new Box<>();
        Box<Orange> orangeBox_2 = new Box<>();

        Box<Apple> appleBox_1 = new Box<>();
        Box<Apple> appleBox_2 = new Box<>();

        //Наполняю ящики.
        orangeBox_1.addFruit(new Orange(),new Orange()); //Через запятую добавляем по одному фрукту)
        orangeBox_2.addFruit(new Orange());

        appleBox_1.addFruit(new Apple());
        appleBox_2.addFruit(new Apple());

        //Вывожу данные после наполнения ящиков фруктами.
        System.out.println("Apple box 1: " + appleBox_1.getWeight());
        System.out.println("Apple box 2: " + appleBox_2.getWeight() + "\n");

        System.out.println("Orange box 1: " + orangeBox_1.getWeight());
        System.out.println("Orange box 2: " + orangeBox_2.getWeight() + "\n");

        //Провожу сравнение между ящиками с фруктами, сравниваю ящик яблок с ящиком яблок, аналогично с апельсинами.
        System.out.println("Apple box 1 equals apple box 2: "+appleBox_1.compare(appleBox_2));
        System.out.println("Orange box 1 equals orange box 2: "+orangeBox_1.compare(orangeBox_2));

        //Пересыпаю из 1-го. ящика яблок во 2-й.
        appleBox_1.pourFruit(appleBox_2);
        //Аналогично с апельсинами.
        orangeBox_1.pourFruit(orangeBox_2);

        //Вывожу по новой данные о ящиках после пересыпания фруктов.
        System.out.println("\n" + "Apple box 1: " + appleBox_1.getWeight());
        System.out.println("Apple box 2: " + appleBox_2.getWeight() + "\n");

        System.out.println("Orange box 1: " + orangeBox_1.getWeight());
        System.out.println("Orange box 2: " + orangeBox_2.getWeight() + "\n");

        //Насыплю по новой в пустые ящики немного.
        appleBox_1.addFruit(new Apple());   //Насыпал яблок в опустевший ящик для яблок.
        orangeBox_1.addFruit(new Orange()); //Насыпал апельсинов в опустевший ящик для апельсинов.

        //Снова вывожу данные о ящиках.
        //Яблоки.
        System.out.println("Apple box 1: " + appleBox_1.getWeight());
        System.out.println("Apple box 2: " + appleBox_2.getWeight() + "\n");
        //Апельсины.
        System.out.println("Orange box 1: " + orangeBox_1.getWeight());
        System.out.println("Orange box 2: " + orangeBox_2.getWeight() + "\n");

    }

}
