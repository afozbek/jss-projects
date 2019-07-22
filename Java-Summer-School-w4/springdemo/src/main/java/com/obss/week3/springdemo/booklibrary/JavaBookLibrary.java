package com.obss.week3.springdemo.booklibrary;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JavaBookLibrary implements IBookLibrary {
    private List<Book> books;

    public JavaBookLibrary() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(String bookName) {
        Book newBook = new Book();
        newBook.setBookName(bookName);

        books.add(newBook);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> search(String title) {
        List<Book> findedBooks = new ArrayList<Book>();

        for (Book book : books) {
            if (book.getBookName().equals(title)) {
                findedBooks.add(book);
            }
        }
        return findedBooks;
    }
}
