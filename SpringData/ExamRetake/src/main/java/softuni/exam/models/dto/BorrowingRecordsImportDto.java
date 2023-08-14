package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordsImportDto {

    @XmlElement(name = "borrow_date")
    private String borrowDate;

    @XmlElement(name = "return_date")
    private String returnDate;

    @XmlElement(name = "remarks")
    private String remarks;

    @XmlElement(name = "book")
    private BookBaseInformationImportDto book;

    @XmlElement(name = "member")
    private LibraryMemberBaseInformationDto member;


    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public BookBaseInformationImportDto getBook() {
        return book;
    }

    public LibraryMemberBaseInformationDto getMember() {
        return member;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setBook(BookBaseInformationImportDto book) {
        this.book = book;
    }

    public void setMember(LibraryMemberBaseInformationDto member) {
        this.member = member;
    }

    public boolean isValid() {

        if (borrowDate == null) {
            return false;
        }

        if (returnDate == null) {
            return false;
        }

        return remarks == null || (remarks.length() >= 3 && remarks.length() <= 100);
    }
}
