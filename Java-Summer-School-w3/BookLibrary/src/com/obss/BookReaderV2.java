package com.obss;

import java.util.List;

public class BookReaderV2 {
    private BookLibrary bookLibrary;

    public BookReaderV2(BookLibrary library) {
        this.bookLibrary = library;
    }

    public List<Book> read(String bookName) {
        List<Book> books = bookLibrary.search(bookName);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }

        return books;
    }
}
