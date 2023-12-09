package service.serviceImpl;

import madel.Book;
import madel.Database;
import madel.Library;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public Book saveBook(Database database,Long libraryId, Book book) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.getLibraries().get(i).getId() == libraryId) {
                bookList.add(book);
            }
        }
        return book;
    }
    @Override
    public List<Book> getAllBooks(Database database,Long libraryId) {
        List<Book> books = new ArrayList<>();
        for (Library l:database.libraries) {
            if(l.getId() == libraryId){
                books.addAll(l.getBooks());
            }
        }
        return books;
    }

    @Override
    public ArrayList<Book> getBookById(Database database,Long libraryId, Long bookId) {
        ArrayList<Book> libraryArrayList = new ArrayList<>();
        ArrayList<Library> libraries = new ArrayList<>();
        for (int i = 0; i < database.getLibraries().size(); i++) {
            if(database.getLibraries().get(i).getId() == libraryId){
                libraries.add(database.getLibraries().get(i));
                for (int j = 0; j < libraries.get(i).getBooks().size(); j++) {
                  if(database.getBooks().get(j).getId() == libraries.get(i).getBooks().get(j).getId()){
                      libraryArrayList.add(database.getBooks().get(j));
                      break;
                }else {
                      System.out.println("Book not found");
                  }
                }
            }
        }
        return libraryArrayList;
    }

    @Override
    public String deleteBook(Database database, Long libraryId, Long bookId) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    if (book.getId() == bookId) {
                        library.getBooks().remove(book);  // Удаляем книгу из списка библиотеки
                        return "Книга под id: " + bookId + " успешно удалена!";
                    }
                }
                return "Книга под id: " + bookId + " не найдена в библиотеке с id: " + libraryId;
            }
        }

        return "Библиотека с id: " + libraryId + " не найдена";
    }


    @Override
    public void clearBooksByLibraryId(Database database, Long libraryId) {
        for (Library library : database.getLibraries()) {
            if (library.getId() == libraryId) {
                library.getBooks().clear();  // Очищаем список книг в библиотеке
                System.out.println("Библиотека успешно очищена.");
                return;
            }
        }

        System.out.println("Библиотека с id: " + libraryId + " не найдена");
    }
}
