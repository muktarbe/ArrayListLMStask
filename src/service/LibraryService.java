package service;
import madel.Book;
import madel.Database;
import madel.Library;
import madel.Reader;

import java.util.ArrayList;
import java.util.List;
public interface LibraryService {
    List<Library>saveLibrary(Database database, Library library);

    List<Library> getAllLibraries(Database database);

    ArrayList<Library> getLibraryById(Database database, Long id);

    Library updateLibrary(Database database,Long id, Library library,String address);

    String deleteLibrary(Database database,Long id);
}
