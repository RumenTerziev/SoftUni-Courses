package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

public interface Booth {
    int getBoothNumber();

    int getCapacity();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderDelicacy(Delicacy delicacy);

    void orderCocktail(Cocktail cocktail);

    double getBill();

    void clear();
}
