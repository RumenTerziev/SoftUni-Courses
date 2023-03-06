package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {


    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.price = 0;
    }

    protected void setNumberOfPeople(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
    }

    protected void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }

        this.capacity = capacity;
    }


    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {

        this.isReserved = true;
        setNumberOfPeople(numberOfPeople);
        this.price = pricePerPerson * numberOfPeople;

    }

    @Override
    public void orderDelicacy(Delicacy delicacy) {
        delicacyOrders.add(delicacy);
    }

    @Override
    public void orderCocktail(Cocktail cocktail) {
        cocktailOrders.add(cocktail);
    }


    @Override
    public double getBill() {

        double totalSum = 0;
        for (Cocktail cocktail : cocktailOrders) {
            totalSum += cocktail.getPrice();
        }

        for (Delicacy delicacy : delicacyOrders) {
            totalSum += delicacy.getPrice();
        }

        return totalSum + getPrice();
    }

    @Override
    public void clear() {

        this.isReserved = false;
        this.numberOfPeople = 0;
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.price = 0;

    }
}
