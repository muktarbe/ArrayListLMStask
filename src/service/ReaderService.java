package service;

import madel.Database;
import madel.Reader;

import java.util.ArrayList;
import java.util.List;

public interface ReaderService {
    void saveReader(Database database,Reader reader);

    List<Reader> getAllReaders(Database database);

    ArrayList<Reader> getReaderById(Database database, Long id);

    ArrayList<Reader> updateReader(Database database,Long id, Reader reader, String fulName,String gmail,String phone_number);

    void assignReaderToLibrary(Database database,Long readerId,Long libraryId);
}
