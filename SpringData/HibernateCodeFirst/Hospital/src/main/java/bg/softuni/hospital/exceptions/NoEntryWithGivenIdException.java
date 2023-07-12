package bg.softuni.hospital.exceptions;

public class NoEntryWithGivenIdException extends IllegalArgumentException {

    public NoEntryWithGivenIdException() {
        super("No entry with given id was found in DB!");
    }
}
