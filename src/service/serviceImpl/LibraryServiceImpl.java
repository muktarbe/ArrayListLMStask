package service.serviceImpl;

import madel.Database;
import madel.Library;
import service.LibraryService;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Library> saveLibrary(Database database, Library library) {
        database.libraries.add(library);
        return database.getLibraries();
    }


    @Override
    public List<Library> getAllLibraries(Database database) {
        return database.getLibraries();
    }

    @Override
    public ArrayList<Library> getLibraryById(Database database, Long id) {
        ArrayList<Library> libraries = new ArrayList<>();
        for (Library l : database.libraries) {
            if (l.getId() == id) {
                libraries.add(l);
            }
        }
        return libraries;
    }

    @Override
    public Library updateLibrary(Database database, Long id, Library library, String address) {
        ArrayList<Library> libraries = new ArrayList<>();
        libraries.add(library);
        for (int i = 0; i < database.libraries.size(); i++) {
            if (database.getLibraries().get(i).getId() == id) {
                libraries.add(database.getLibraries().get(i));
                for (int j = 0; j < libraries.size(); j++) {
                    libraries.get(j).setAddress(address);
                }
            }
        }
        return library;
    }

    @Override
    public String deleteLibrary(Database database, Long id) {
        Library libraryToRemove = null;

        for (Library library : database.libraries) {
            if (library.getId() == id) {
                libraryToRemove = library;
                break;
            }
        }
        if (libraryToRemove != null) {
            database.libraries.remove(libraryToRemove);
            return "Библиотека с id: " + id + " успешно удалена.";
        } else {
            return "Библиотека с id: " + id + " не найдена.";
        }
    }
}
