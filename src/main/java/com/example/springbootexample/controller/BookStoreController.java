package com.example.springbootexample.controller;

import com.example.springbootexample.entity.BookDetails;
import com.example.springbootexample.exception.BookNotFoundException;
import com.example.springbootexample.service.BookStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author Sharmila
 */
@RestController
public class BookStoreController {

    private static final Logger logger = LoggerFactory.getLogger(BookStoreController.class);

    @Autowired
    BookStoreService bookStoreService;

    @PostMapping(value="/addBookDetails",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addBookDetails(@RequestBody BookDetails bookDetails){

        bookStoreService.addBookDetails(bookDetails);

       /* URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBookDetails.getBookId()).toUri();

        return ResponseEntity.created(location).build();*/

        return ResponseEntity.ok("Successfully Inserted Book Details");
    }

    @GetMapping(value="/getBookDetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDetails> getBookDetails(){
        return bookStoreService.getBookDetails();
    }

    @GetMapping(value = "/getBookDetails/{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDetails getBookDetail(@PathVariable Integer bookId){
        BookDetails bookDetail = bookStoreService.getBookDetail(bookId);

        return bookDetail;
    }


    @PutMapping(value = "/updateBookDetails/{bookId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateBookDetail(@RequestBody BookDetails bookDetails,@PathVariable Integer bookId){
        BookDetails bookDetail = bookStoreService.getBookDetail(bookId);

        if(bookDetail!=null) {
            bookStoreService.updateBookDetails(bookDetails);
            return ResponseEntity.ok("Successfully Updated Book details");
        }else{
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping("/deleteBookDetails/{bookId}")
    public void deleteBookDetails(@PathVariable Integer bookId) {
        bookStoreService.deleteBookDetails(bookId);
    }

   /* @PatchMapping("/patch/{bookId}")
    public ResponseEntity<BookDetails> updateBookDetailsPartially(@PathVariable Integer bookId, @RequestBody String bookName) {
        try {
            BookDetails bookDetails = bookStoreService.getBookDetail(bookId);
            bookDetails.setBookName(bookName);
            return new ResponseEntity<>(bookStoreService.addBookDetails(bookDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PatchMapping(value = "/patchBookDetails/{bookId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateBookDetailsPartially(@PathVariable Integer bookId, @RequestBody Map<Object,Object> fields) {
      BookDetails bookDetails = bookStoreService.getBookDetail(bookId);

        fields.forEach((k, v) -> {
            // use reflection to get field k on manager and set it to value v
            Field field = ReflectionUtils.findField(BookDetails.class, k.toString());
            field.setAccessible(true);
            ReflectionUtils.setField(field, bookDetails, v);
        });

       bookStoreService.addBookDetails(bookDetails);
        return  ResponseEntity.ok("Successfully patched Book details");
    }


    @ExceptionHandler(BookNotFoundException.class)
    public void handleBookNotFoundException(HttpServletRequest request, Exception ex){
        logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+ex.getMessage());

      /*  ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", ex.getMessage());
        modelAndView.addObject("url", request.getRequestURL());

        return modelAndView;*/

    }
}
