package org.softwaretechnologies;

import org.junit.jupiter.api.Test;
import org.softwaretechnologies.animals.AnimalType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZooTest {

    @Test
    void soundAllAnimalsSortByName() {
        Zoo zoo = new Zoo();

        zoo.addAnimal(AnimalFactory.createAnimal("zuzu", AnimalType.CAT));
        zoo.addAnimal(AnimalFactory.createAnimal("abu", AnimalType.COW));
        zoo.addAnimal(AnimalFactory.createAnimal("bob", AnimalType.DOG));
        zoo.addAnimal(AnimalFactory.createAnimal("yoyo", AnimalType.CAT));
        assertEquals(zoo.getAnimalList().size(),4);
        List<String> sounds = zoo.soundAllAnimalsSortByName();
        List<String> expected = Arrays.asList("moo", "woof", "meow", "meow");
        int i = 0;
        for (String sound : sounds) {
            assertEquals(expected.get(i), sound);
            i++;
        }
    }
}