package bg.rumen.patterns.builder.house;

public class House {

    private String firstFloor;

    private String secondFloor;

    private String thirdFloor;

    private Integer squareMeters;

    private String address;

    private String city;

    private String postBox;

    private boolean hasBasement;

    private boolean isRedecorated;

    protected House() {}

    public House(HouseBuilder builder) {
        this.firstFloor = builder.getFirstFloor();
        this.secondFloor = builder.getSecondFloor();
        this.thirdFloor = builder.getThirdFloor();
        this.city = builder.getCity();
        this.address = builder.getAddress();
        this.squareMeters = builder.getSquareMeters();
        this.postBox = builder.getPostBox();
        this.hasBasement = builder.hasBasement();
        this.isRedecorated = builder.isRedecorated();
    }

    public String getFirstFloor() {
        return firstFloor;
    }

    public String getSecondFloor() {
        return secondFloor;
    }

    public String getThirdFloor() {
        return thirdFloor;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostBox() {
        return postBox;
    }

    public boolean hasBasement() {
        return hasBasement;
    }

    public boolean isRedecorated() {
        return isRedecorated;
    }


    @Override
    public String toString() {
        return "I am a House!";
    }
}
