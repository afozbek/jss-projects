package com.obss;

import java.util.List;

public class BookReader {
    private BookLibrary bookLibrary;

    public BookReader() {
        this.bookLibrary = new JavaBookLibrary();
    }

    public List<Book> read() {
        List<Book> books = bookLibrary.search("java");

        for (Book book : books) {
            System.out.println(book.getTitle());
        }

        return books;
    }
}
