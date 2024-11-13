package org.softwaretechnologies;

public class MilkCofe implements CofeInterface  {
    CofeInterface cofeInterface;

    public MilkCofe(CofeInterface cofeInterface) {
        this.cofeInterface = cofeInterface;
    }

    @Override
    public int getCost() {
        return cofeInterface.getCost()+10;
    }

    @Override
    public String description() {
        return cofeInterface.getCost()+" + milk";
    }

    /**
     * Создайте класс MilkCofe, поддерживающий интерфейс CofeIntrface
     * к стоимости базового напитка добавьте 10.
     * к описанию добавьте " + milk"
     */

}
