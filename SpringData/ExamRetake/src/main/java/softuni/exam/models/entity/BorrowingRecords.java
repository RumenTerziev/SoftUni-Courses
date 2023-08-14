package softuni.exam.models.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "borrowing_records")
public class BorrowingRecords extends BaseEntity {

    @Column(name = "borrow_date", nullable = false)
    private Date borrowDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(targetEntity = Book.class)
    private Book book;

    @ManyToOne(targetEntity = LibraryMember.class)
    private LibraryMember member;


    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryMember getMember() {
        return member;
    }

    public void setMember(LibraryMember member) {
        this.member = member;
    }
}
