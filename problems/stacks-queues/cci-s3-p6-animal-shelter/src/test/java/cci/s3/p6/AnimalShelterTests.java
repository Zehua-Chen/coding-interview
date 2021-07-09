package cci.s3.p6;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class AnimalShelterTests {
    public static Stream<Arguments> implementations() {
        return Stream.of(arguments(new FinalShelter()));
    }

    @ParameterizedTest
    @MethodSource("implementations")
    public void oneKind(AnimalShelter shelter) {
        var factory = new AnimalFactory();

        shelter.enqueue(factory.getCat());
        shelter.enqueue(factory.getCat());
        shelter.enqueue(factory.getCat());

        Animal head = shelter.dequeueCat();

        assertEquals(Animal.Kind.CAT, head.kind());
        assertEquals(0, head.id());

        head = shelter.dequeueAny();

        assertEquals(Animal.Kind.CAT, head.kind());
        assertEquals(1, head.id());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    public void dequeueAny(AnimalShelter shelter) {
        var factory = new AnimalFactory();

        shelter.enqueue(factory.getCat());
        shelter.enqueue(factory.getDog());
        shelter.enqueue(factory.getCat());

        Animal head = shelter.dequeueAny();

        assertEquals(Animal.Kind.CAT, head.kind());
        assertEquals(0, head.id());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    public void dequeueDog(AnimalShelter shelter) {
        var factory = new AnimalFactory();

        shelter.enqueue(factory.getCat());
        shelter.enqueue(factory.getDog());
        shelter.enqueue(factory.getCat());
        shelter.enqueue(factory.getDog());

        Animal head = shelter.dequeueDog();

        assertEquals(Animal.Kind.DOG, head.kind());
        assertEquals(1, head.id());
    }
}
