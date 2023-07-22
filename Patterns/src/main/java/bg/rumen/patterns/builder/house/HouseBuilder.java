package bg.rumen.patterns.builder.house;

public class HouseBuilder {

    private String firstFloor;

    private String secondFloor;

    private String thirdFloor;

    private Integer squareMeters;

    private String address;

    private String city;

    private String postBox;

    private boolean hasBasement;

    private boolean isRedecorated;


    protected String getFirstFloor() {
        return firstFloor;
    }

    protected String getSecondFloor() {
        return secondFloor;
    }

    protected String getThirdFloor() {
        return thirdFloor;
    }

    protected Integer getSquareMeters() {
        return squareMeters;
    }

    protected String getAddress() {
        return address;
    }

    protected String getCity() {
        return city;
    }

    protected String getPostBox() {
        return postBox;
    }

    protected boolean hasBasement() {
        return hasBasement;
    }

    protected boolean isRedecorated() {
        return isRedecorated;
    }

    public HouseBuilder setFirstFloor(String firstFloor) {
        this.firstFloor = firstFloor;
        return this;
    }

    public HouseBuilder setSecondFloor(String secondFloor) {
        this.secondFloor = secondFloor;
        return this;
    }

    public HouseBuilder setThirdFloor(String thirdFloor) {
        this.thirdFloor = thirdFloor;
        return this;
    }

    public HouseBuilder setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
        return this;
    }

    public HouseBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public HouseBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public HouseBuilder setPostBox(String postBox) {
        this.postBox = postBox;
        return this;
    }

    public HouseBuilder setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
        return this;
    }

    public HouseBuilder setRedecorated(boolean redecorated) {
        isRedecorated = redecorated;
        return this;
    }


    public House build() {
        return new House(this);
    }

}
