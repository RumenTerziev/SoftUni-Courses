package softuni.exam.models.dto;

public class LibraryMemberImportDto {

    private String firstName;

    private String lastName;

    private String address;

    private String phoneNumber;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValid() {

        if (firstName == null) {
            return false;
        }

        if (lastName == null) {
            return false;
        }

        if (address == null) {
            return false;
        }


        if (firstName.length() < 2 || firstName.length() > 30) {
            return false;
        }

        if (lastName.length() < 2 || lastName.length() > 30) {
            return false;
        }

        if (address.length() < 2 || address.length() > 40) {
            return false;
        }

        return phoneNumber.length() >= 2 && phoneNumber.length() <= 20;
    }
}
