package ru.geekbrains.nikolaysilin.lesson_1_update.exercisewithfruits;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {

    protected List<T> container;

    public Box() {
        this.container = new ArrayList<>();
    }

    //protected ArrayList<T> box = new ArrayList<>(); мой метод.

    public float getWeight() {
        float weight = 0.0f;
        for (T x : container) {
            weight += x.getWeight();
        }
        return weight;

    }


   //Метод преподавателя добавляет по одному фрукту.
//    public void addFruit(T fruit) {
//            container.add(fruit);
//        }

    //Метод с множественным добавление фрутов)
    public void addFruit(T... fruit) {
        this.container.addAll(Arrays.asList(fruit));
    }

    //Правильный метод сравнения!
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.001;
    }

    /*
    мой неверный метод!
    public boolean compare(Box anotherBox) {
        if (getWeight() == anotherBox.getWeight()) return true;
        return false;

    }
    */

    /*
    public void pourFruit(Box<T> anotherBox) {
        anotherBox.container.addAll(container);
        container.clear();
    }
     */

    //Метод добавления фруктов от преподавателя.
    public void pourFruit(Box<? super T> anotherBox) {
        if (anotherBox == this) {
            return;
        }
        anotherBox.container.addAll(this.container);
        this.container.clear();

    }


}