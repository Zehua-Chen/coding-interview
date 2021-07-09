package cci.s3.p6;

public interface AnimalShelter {
    void enqueue(Animal animal);

    Animal dequeueAny();

    Animal dequeueDog();

    Animal dequeueCat();
}
