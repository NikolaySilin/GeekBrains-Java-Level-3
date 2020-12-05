package ru.geekbrains.nikolaysilin.lesson_1_3.exercisewithfruits;


import java.util.ArrayList;

public class Box <T extends Fruit> {

    protected ArrayList<T> box = new ArrayList<>();

    public float getWeight() {
        float weight = 0.0f;
        for (T x : box) {
            weight += x.getWeight();
        }
        return weight;

    }

    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }

    public boolean compare(Box anotherBox) {
        if (getWeight() == anotherBox.getWeight()) return true;
        return false;

    }

    public void pourFruit(Box<T> anotherBox) {
        anotherBox.box.addAll(box);
        box.clear();
    }
}