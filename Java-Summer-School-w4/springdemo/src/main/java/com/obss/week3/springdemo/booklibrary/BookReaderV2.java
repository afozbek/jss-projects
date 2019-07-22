package com.obss.week3.springdemo.booklibrary;

import java.util.List;

public class BookReaderV2 {
    private IBookLibrary bookLibrary;

    public BookReaderV2(IBookLibrary library) {
        this.bookLibrary = library;
    }

    public void read(String bookName) {
        List<Book> books = bookLibrary.search(bookName);

        if (books != null) {
            System.out.println("I am reading " + books.get(0).getBookName());
        } else {
            System.out.println("No books exist");
        }
    }
}
