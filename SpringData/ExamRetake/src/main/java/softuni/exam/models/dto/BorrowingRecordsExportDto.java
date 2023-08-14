package softuni.exam.models.dto;

public class BorrowingRecordsExportDto {

    private String bookTitle;

    private String bookAuthor;

    private String borrowDate;

    private String memberFirstName;

    private String memberLastName;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getMemberFirstName() {
        return memberFirstName;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public String toString() {
        return String.format("Book title: %s%n" +
                        "*Book author: %s%n" +
                        "**Date borrowed: %s%n" +
                        "***Borrowed by: %s %s%n",
                bookTitle,
                bookAuthor,
                borrowDate,
                memberFirstName,
                memberLastName);
    }
}
