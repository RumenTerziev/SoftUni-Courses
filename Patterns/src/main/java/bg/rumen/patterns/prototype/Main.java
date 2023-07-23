package bg.rumen.patterns.prototype;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Mercedes");

        Car carCopy = (Car) car.clone();

        System.out.println(car.getCarMake());
        System.out.println(carCopy.getCarMake());
        System.out.println();


    }
}
