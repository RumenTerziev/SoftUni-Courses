package bg.rumen.patterns.builder;

import bg.rumen.patterns.builder.house.House;
import bg.rumen.patterns.builder.house.HouseBuilder;

public class Main {
    public static void main(String[] args) {
        House house = new HouseBuilder()
                .setFirstFloor("First")
                .setSecondFloor("Second")
                .setAddress("Address")
                .setRedecorated(false)
                .setHasBasement(true)
                .build();


        System.out.println(house);
        System.out.println(house.getFirstFloor());
        System.out.println(house.getSecondFloor());
        System.out.println(house.getAddress());
        System.out.println(house.isRedecorated());
        System.out.println(house.hasBasement());
    }
}
