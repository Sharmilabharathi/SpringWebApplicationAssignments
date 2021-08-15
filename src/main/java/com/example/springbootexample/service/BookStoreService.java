package com.example.springbootexample.service;

import com.example.springbootexample.entity.BookDetails;
import com.example.springbootexample.exception.BookNotFoundException;
import com.example.springbootexample.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sharmila
 */
@Service
@Transactional
public class BookStoreService {

    @Autowired
    BookStoreRepository bookStoreRepository;

    public BookDetails addBookDetails(BookDetails bookDetails){
        return bookStoreRepository.save(bookDetails);
    }

    public List<BookDetails> getBookDetails(){
        return bookStoreRepository.findAll();
    }

    public BookDetails getBookDetail(Integer bookId){

        return bookStoreRepository.findById(bookId)
                .orElseThrow(()->new BookNotFoundException("Book not found for this id :: " + bookId));
    }

    public void updateBookDetails(BookDetails bookDetails){
        BookDetails bookDetails1 = new BookDetails();
        bookDetails1.setBookId(bookDetails.getBookId());
        bookDetails1.setBookName(bookDetails.getBookName());
        bookDetails1.setBookCategory(bookDetails.getBookCategory());
        bookDetails1.setPublisher(bookDetails.getPublisher());
        bookDetails1.setAuthor(bookDetails.getAuthor());
        bookDetails1.setBookPublishedDate(bookDetails.getBookPublishedDate());
        this.addBookDetails(bookDetails1);
    }

    public void deleteBookDetails(Integer bookId) {
        BookDetails bookDetails = bookStoreRepository.findById(bookId)
                .orElseThrow(()->new BookNotFoundException("Book not found for this id :: " + bookId));
        if(bookDetails!=null) {
            bookStoreRepository.deleteById(bookId);
        }
    }

}
