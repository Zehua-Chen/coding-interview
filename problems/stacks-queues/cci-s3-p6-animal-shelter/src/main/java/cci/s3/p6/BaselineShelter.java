package cci.s3.p6;

import java.util.*;

public class BaselineShelter implements AnimalShelter {
    private static record AnimalEntry(Animal animal, int arrivalTime) {
    }

    private final LinkedList<AnimalEntry> dogs = new LinkedList<>();
    private final LinkedList<AnimalEntry> cats = new LinkedList<>();
    private int nextTime = 0;

    @Override
    public void enqueue(Animal animal) {
        switch (animal.kind()) {
            case CAT -> cats.addLast(new AnimalEntry(animal, nextTime++));
            case DOG -> dogs.addLast(new AnimalEntry(animal, nextTime++));
        }
    }

    @Override
    public Animal dequeueAny() {
        AnimalEntry dog = dogs.peekFirst();
        AnimalEntry cat = cats.peekFirst();

        if (dog == null && cat == null) {
            return null;
        }

        if (dog == null) {
            cats.removeFirst();
            return cat.animal();
        }

        if (cat == null) {
            dogs.removeFirst();
            return dog.animal();
        }

        if (dog.arrivalTime() < cat.arrivalTime()) {
            dogs.removeFirst();
            return dog.animal();
        }

        cats.removeFirst();

        return cat.animal();
    }

    @Override
    public Animal dequeueDog() {
        return dogs.removeFirst().animal();
    }

    @Override
    public Animal dequeueCat() {
        return cats.removeFirst().animal();
    }
}
