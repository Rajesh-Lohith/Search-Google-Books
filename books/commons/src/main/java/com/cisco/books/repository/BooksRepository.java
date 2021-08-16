package com.cisco.books.repository;

import com.cisco.books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, String> {

//    @Query(value = "select book0_.id as id1_1_, book0_.kind as kind2_1_, book0_.self_link as self_lin3_1_, book0_.volume_info_id as volume_i4_1_ from book book0_ left outer join book_info bookinfo1_ on book0_.volume_info_id=bookinfo1_.id left outer join authors authors2_ on bookinfo1_.id=authors2_.id where (authors2_.authors like %:author%) and (bookinfo1_.title like %:title%)", nativeQuery = true)
//    List<Book> getBooksByAuthorOrTitle(String author, String title);

    List<Book> findByVolumeInfoAuthorsContainingAndVolumeInfoTitleContaining(String author, String title);

}
