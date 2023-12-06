package service;

import madel.Database;
import madel.Reader;

import java.util.List;

public interface ReaderService {
    void saveReader(Database database,Reader reader);

    List<Reader> getAllReaders(Database database);

    Reader getReaderById(Database database,Long id);

    Reader updateReader(Database database,Long id, Reader reader);

    void assignReaderToLibrary(Database database,Long readerId,Long libraryId);
}
