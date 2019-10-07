package org.fasttrackit.bookreview;


import org.fasttrackit.bookreview.domain.Book;
import org.fasttrackit.bookreview.exception.ResourceNotFoundException;
import org.fasttrackit.bookreview.service.BookService;
import org.fasttrackit.bookreview.steps.BookSteps;
import org.fasttrackit.bookreview.transfer.book.book.SaveBookRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceIntegrationTests {

   @Autowired
    private BookService bookService;
   @Autowired
    private BookSteps bookSteps;

   @Test
    public void TestCreateBook_whenValidRequest_thenReturnCreatedBook(){
       bookSteps.createBook();
   }

    @Test
    public void TestGetBook_whenExistingEntity_thenReturnBook(){
        Book createdBook = bookSteps.createBook();
        Book retirevedBook = bookService.getBook(createdBook.getId());

        assertThat(retirevedBook, notNullValue());
        assertThat(retirevedBook.getId(), is(createdBook.getId()));
        assertThat(retirevedBook.getTitle(),is(createdBook.getTitle()));
        assertThat(retirevedBook.getType(), is(createdBook.getType()));
        assertThat(retirevedBook.getAuthor(), is(createdBook.getAuthor()));
        assertThat(retirevedBook.getYearOfRelease(), is(createdBook.getYearOfRelease()));
        assertThat(retirevedBook.getLanguage(), is(createdBook.getLanguage()));
        assertThat(retirevedBook.getPages(), is(createdBook.getPages()));
        assertThat(retirevedBook.getDescription(), is(createdBook.getDescription()));
        assertThat(retirevedBook.getImagePath(), is(createdBook.getImagePath()));
    }
    @Test(expected = ResourceNotFoundException.class)
    public void TestGetBookById_whenNonExistingEntity_thenThrowNotFoundException(){
       bookService.getBook(99999999L);
    }

    @Test
    public void TestUpdateBook_whenValidRequest_thenReturnUpdatedProduct(){
        Book createdBook = bookSteps.createBook();

        SaveBookRequest request = new SaveBookRequest();
        request.setYearOfRelease(createdBook.getYearOfRelease() + 2000);
        request.setLanguage(createdBook.getLanguage() + "update");
        request.setPages(createdBook.getPages() + 2000);
        request.setTitle(createdBook.getTitle() + "updated");
        request.setAuthor(createdBook.getAuthor() + "updated");
        request.setDescription(createdBook.getDescription() + "updated");
        request.setImagePath(createdBook.getImagePath() + "updated");
        request.setType(createdBook.getType() + "updated");

        Book updatedBook = bookService.updateBook(createdBook.getId(), request);
        assertThat(updatedBook, notNullValue());
        assertThat(updatedBook.getId(), notNullValue());
        assertThat(" unexpected Book Title ", updatedBook.getTitle(), is(request.getTitle()));
        assertThat(" unexpected Year ", updatedBook.getYearOfRelease(), is(request.getYearOfRelease()));
        assertThat(" unexpected Language ", updatedBook.getLanguage(), is(request.getLanguage()));
        assertThat(" unexpected Page number ", updatedBook.getPages(), is(request.getPages()));
        assertThat(" unexpected Author ", updatedBook.getAuthor(), is(request.getAuthor()));
        assertThat(" unexpected Description ", updatedBook.getDescription(), is(request.getDescription()));
        assertThat(" unexpected Type ", updatedBook.getType(), is(request.getType()));
        assertThat(" unexpected ImagePath", updatedBook.getImagePath(), is(request.getImagePath()));
    }

    @Test (expected = ResourceNotFoundException.class)
    public void TestDeleteBook_whenValidRequest_thenThrowResourceNotFound(){
            Book createdBook = bookSteps.createBook();
            Book createdBook1 = bookSteps.createBook();
            bookService.deleteBook(createdBook.getId());
            bookService.getBook(createdBook.getId());
    }


}
