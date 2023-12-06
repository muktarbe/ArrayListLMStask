package service;

import madel.Book;
import madel.Database;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    Book saveBook(Database database, Long libraryId, Book book);

    List<Book> getAllBooks(Database database,Long libraryId);

    ArrayList<Book> getBookById(Database database,Long libraryId, Long bookId);

    String deleteBook(Database database,Long libraryId,Long bookId);

    void clearBooksByLibraryId(Database database,Long libraryId);
}
