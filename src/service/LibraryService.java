package service;
import madel.Database;
import madel.Library;
import java.util.List;
public interface LibraryService {
    List<Library>saveLibrary(Database database, List<Library>libraries);

    List<Library> getAllLibraries(Database database);

    Library getLibraryById(Database database,Long id);

    Library updateLibrary(Database database,Long id, Library library);

    String deleteLibrary(Database database,Long id);
}
