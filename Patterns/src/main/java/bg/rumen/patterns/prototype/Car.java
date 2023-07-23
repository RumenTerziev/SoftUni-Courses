package bg.rumen.patterns.prototype;


public class Car implements Prototype {


    private String carMake;


    public Car(String carMake) {
        this.carMake = carMake;
    }

    public String getCarMake() {
        return carMake;
    }

    @Override
    public Prototype clone() {
        return new Car(this.carMake);
    }

}
