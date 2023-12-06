package serviceImpl;

import com.sun.tools.javac.Main;
import madel.Book;
import madel.Database;
import madel.Library;
import service.BookService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookServiceImpl implements BookService {
    Database database = new Database();

    @Override
    public Book saveBook(Database database,Long libraryId, Book book) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.getLibraries().get(i).getId() == libraryId) {
                bookList.add(book);
            }
        }
        return (Book) bookList;
    }
    @Override
    public List<Book> getAllBooks(Database database,Long libraryId) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < database.books.size(); i++) {
            if (database.getLibraries().get(i).getId() == libraryId) {
                for (int j = 0; j < i; j++) {
                    books.add(database.getBooks().get(i));
                }
            }
        }
        return books;
    }

    @Override
    public ArrayList<Book> getBookById(Database database,Long libraryId, Long bookId) {
        ArrayList<Book> libraryArrayList = new ArrayList<>();
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.getLibraries().get(i).getId() == libraryId) {
                for (int j = 0; j < i; j++) {
                    if (database.getBooks().get(j).getId() == bookId) {
                        libraryArrayList.add(database.getBooks().get(j));
                    } else {
                        System.out.println("Книга под id :" + bookId + " не найденно!");
                    }
                }
            } else {
                System.out.println("бибилиотека под id :" + libraryId + " не найденно!");
            }
        }
        return libraryArrayList;
    }

    @Override
    public String deleteBook(Database database,Long libraryId, Long bookId) {
        ArrayList<Book> libraryArrayList = new ArrayList<>();
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.getLibraries().get(i).getId() == libraryId) {
                for (int j = 0; j < i; j++) {
                    if (database.getBooks().get(j).getId() == bookId) {
                        libraryArrayList.remove(database.getBooks().get(j));
                    } else {
                        System.out.println("Книга под id :" + bookId + " не найденно!");
                    }
                }
            } else {
                System.out.println("бибилиотека под id :" + libraryId + " не найденно!");
            }
        }
        return "Книга под id :"+bookId+" успешно удалено!";
    }

    @Override
    public void clearBooksByLibraryId(Database database,Long libraryId) {
        ArrayList<Library> libraryArrayList = new ArrayList<>();
        for (int i = 0; i < database.getLibraries().size(); i++) {
            if (database.getLibraries().get(i).getId() == libraryId){
                libraryArrayList.clear();
                System.out.println("Бибилиотека успешно очишено.");
            }
        }
    }
}
