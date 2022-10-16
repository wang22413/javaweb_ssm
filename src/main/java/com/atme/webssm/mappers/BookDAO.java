package com.atme.webssm.mappers;
import com.atme.webssm.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDAO {

    List<Book> getBookList(@Param("minPrice") Integer minPrice ,@Param("maxPrice") Integer maxPrice);

    Book getBook(@Param("id") Integer id);

}
