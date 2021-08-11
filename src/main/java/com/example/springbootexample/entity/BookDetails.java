package com.example.springbootexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @author Sharmila
 */
@Entity
@Table(name="bookdetails")
public class BookDetails {
    @Id
    @Column(name="bookId")
    private Integer bookId;

    @Column(name="bookName")
    private String bookName;

    @Column(name="bookCategory")
    private String bookCategory;

    @Column(name="author")
    private String author;

    @Column(name="publisher")
    private String publisher;

    @Column(name="bookPublishedDate")
    private Date bookPublishedDate;

    public BookDetails() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getBookPublishedDate() {
        return bookPublishedDate;
    }

    public void setBookPublishedDate(Date bookPublishedDate) {
        this.bookPublishedDate = bookPublishedDate;
    }
}
