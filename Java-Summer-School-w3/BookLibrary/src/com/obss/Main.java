package com.obss;

public class Main {
    public static BookLibrary createLibrary() {
        BookLibrary library = new JavaBookLibrary();
        library.addBook("Yüzüklerin Efendisi");
        library.addBook("Yüzüklerin Efendisi");
        library.addBook("JAVA");
        library.addBook("JAVA");

        return library;
    }

    public static void main(String[] args) {
        BookReaderV2 readerV2 = new BookReaderV2(Main.createLibrary());
    }
}
