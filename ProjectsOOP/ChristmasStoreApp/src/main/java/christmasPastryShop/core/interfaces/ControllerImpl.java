package christmasPastryShop.core.interfaces;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;

import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;


    private double sumBills;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.boothRepository = boothRepository;
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.sumBills = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {

        Delicacy delicacy = delicacyRepository.getByName(name);
        if (delicacy == null) {
            DelicacyType foodType = DelicacyType.valueOf(type);

            switch (foodType) {
                case Gingerbread:
                    delicacy = new Gingerbread(name, price);
                    break;
                case Stolen:
                    delicacy = new Stolen(name, price);
                    break;

            }
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,
                    delicacy.getClass().getSimpleName(), name));
        }


        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {

        Cocktail cocktail = cocktailRepository.getByName(name);
        if (cocktail == null) {
            CocktailType cocktailType = CocktailType.valueOf(type);

            switch (cocktailType) {
                case MulledWine:
                    cocktail = new MulledWine(name, size, brand);
                    break;
                case Hibernation:
                    cocktail = new Hibernation(name, size, brand);
                    break;
            }
        } else {
            String message = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST,
                    cocktail.getClass().getSimpleName(), cocktail.getName());

            throw new IllegalArgumentException(message);
        }
        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {

        Booth booth = boothRepository.getByNumber(boothNumber);
        if (booth == null) {
            BoothType boothType = BoothType.valueOf(type);

            switch (boothType) {
                case OpenBooth:
                    booth = new OpenBooth(boothNumber, capacity);
                    break;
                case PrivateBooth:
                    booth = new PrivateBooth(boothNumber, capacity);
                    break;
            }

        } else {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {


        Booth booth = boothRepository.getAll().stream()
                .filter(booth1 -> !booth1.isReserved())
                .filter(booth1 -> booth1.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);

        String output;
        if (booth == null) {
            output = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {

            booth.reserve(numberOfPeople);
            output = String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
        }


        return output;
    }

    @Override
    public String orderDelicacy(int tableNumber, String foodName) {

        Booth booth = boothRepository.getByNumber(tableNumber);
        Delicacy delicacy = delicacyRepository.getByName(foodName);

        if (booth == null || !booth.isReserved()) {
            return String.format("Wrong booth number %d", tableNumber);
        }

        if (delicacy == null) {
            return String.format("None existent delicacy %s", foodName);
        }

        booth.orderDelicacy(delicacy);
        return String.format("Booth order successful %d %s", tableNumber, foodName);
    }

    @Override
    public String orderCocktail(int tableNumber, String drinkName, String drinkBrand) {


        Booth boothFromRepo = boothRepository.getByNumber(tableNumber);

        Cocktail cocktail = cocktailRepository.getByName(drinkName);
        if (boothFromRepo == null || !boothFromRepo.isReserved()) {
            return String.format("Wrong booth number %d", tableNumber);
        }
        if (cocktail == null) {
            return String.format("Non existent cocktail %s %s", drinkName, drinkBrand);
        }
        boothFromRepo.orderCocktail(cocktail);
        return String.format("Cocktail order successful %d %s %s", tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveBooth(int boothNumber) {


        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        sumBills += bill;
        booth.clear();
        return String.format(BILL, booth.getBoothNumber(), bill);

    }

    @Override
    public String getIncome() {

        return String.format(TOTAL_INCOME, sumBills);
    }
}
