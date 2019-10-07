package org.fasttrackit.bookreview.persistance;

import org.fasttrackit.bookreview.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long > {


    Page<Book> findByTitleAndAuthor(String partialTitle, String partialAuthor, Pageable pageable);


    @Query(value = "SELECT product FROM Product product where name Like '%?%'",
            nativeQuery= true)
    Page<Book> findByTitleOrAuthor(String partialTitle, Pageable pageable);


}
