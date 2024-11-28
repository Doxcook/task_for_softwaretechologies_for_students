package org.softwaretechnologies;

import org.softwaretechnologies.animals.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo {
    private final List<Animal> animalList = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    /**
     * Метод должен возвращать список звуков животных.
     * Звуки животных должны быть отсортированы по имени животного.
     *
     * @return Звуки животных, в алфавитном порядке имени животного.
     */
    public List<String> soundAllAnimalsSortByName() {
        return animalList.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .map(Animal::sound)
                .collect(Collectors.toList());
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }
}
