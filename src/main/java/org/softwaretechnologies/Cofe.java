package org.softwaretechnologies;

public class Cofe implements CofeInterface {

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String description() {
        return "only cofe";
    }
/**
     * Создайте класс Cofe, поддерживающий интерфейс CofeIntrface
     * стоимость базового напитка равна 50.
     * описание "only cofe"
     */

}

