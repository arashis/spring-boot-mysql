package com.example.springbootmysql.repository;

import com.example.springbootmysql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //    以下と同じ
    //    @Query(nativeQuery = true, value = "select * from book")
    //    Book findAllBooks(int id);

    @Override
    List<Book> findAll();

    //    以下と同じ
    //    @Query(nativeQuery = true, value = "select * from book b where b.book_id = ?1")
    //    Book findBook(int id);
    Book findByBookId(Integer id);

    @Override
    @Transactional
    Book save(Book book);
}
