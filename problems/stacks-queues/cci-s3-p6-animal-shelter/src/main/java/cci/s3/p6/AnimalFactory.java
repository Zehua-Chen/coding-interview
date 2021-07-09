package cci.s3.p6;

public class AnimalFactory {
    private int nextID = 0;

    public Animal getCat() {
        return new Animal(nextID++, Animal.Kind.CAT);
    }

    public Animal getDog() {
        return new Animal(nextID++, Animal.Kind.DOG);
    }
}
