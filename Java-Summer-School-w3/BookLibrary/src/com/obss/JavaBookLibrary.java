package com.obss;

import java.util.ArrayList;
import java.util.List;

public class JavaBookLibrary implements BookLibrary {
    private List<Book> books;

    public JavaBookLibrary() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(String bookName) {
        books.add(new Book(bookName));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> search(String title) {
        List<Book> findedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                findedBooks.add(book);
            }
        }
        return findedBooks;
    }
}
