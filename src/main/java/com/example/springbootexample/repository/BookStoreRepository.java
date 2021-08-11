package com.example.springbootexample.repository;

import com.example.springbootexample.entity.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sharmila
 */
@Repository
public interface BookStoreRepository extends JpaRepository <BookDetails,Integer>{
}
