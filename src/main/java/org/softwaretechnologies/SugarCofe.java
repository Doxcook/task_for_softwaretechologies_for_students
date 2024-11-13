package org.softwaretechnologies;

public class SugarCofe implements CofeInterface {
    CofeInterface cofeInterface;

    public SugarCofe(CofeInterface cofeInterface) {
        this.cofeInterface = cofeInterface;
    }

    /**
     * Создайте класс MilkCofe, поддерживающий интерфейс CofeIntrface
     * к стоимости базового напитка добавьте 20.
     * к описанию добавьте " + sugar"
     */
    @Override
    public int getCost() {
        return cofeInterface.getCost()+20;
    }

    @Override
    public String description() {
        return cofeInterface.description()+" + sugar";
    }
}
