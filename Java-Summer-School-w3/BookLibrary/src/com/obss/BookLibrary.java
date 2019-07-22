package com.obss;

import java.util.List;

public interface BookLibrary {
    List<Book> search(String java);

    void addBook(String bookName);
}
