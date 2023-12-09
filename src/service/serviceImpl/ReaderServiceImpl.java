package service.serviceImpl;
import madel.Database;
import madel.Reader;
import service.ReaderService;

import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Database database, Reader reader) {
        database.readers.add(reader);
        System.out.println(database.getReaders());
    }

    @Override
    public List<Reader> getAllReaders(Database database) {
        return database.getReaders();
    }

    @Override
    public ArrayList<Reader> getReaderById(Database database, Long id) {
        ArrayList<Reader> readers = new ArrayList<>();
        for (int i = 0; i < database.readers.size(); i++) {
            if (database.getReaders().get(i).getId() == id){
                readers.add(database.readers.get(i));
            } else {
                System.out.println("Читетель под: "+id+" не найдено!");
            }
        }
        return readers;
    }

    @Override
    public ArrayList<Reader> updateReader(Database database, Long id, Reader reader, String fulName, String gmail, String phone_number) {
        ArrayList<Reader> readers = new ArrayList<>();
        for (int i = 0; i < database.readers.size(); i++) {
            if (database.getReaders().get(i).getId() == id){
                readers.add(database.readers.get(i));
                for (int j = 0; j < readers.size(); j++) {
                    readers.get(i).setFui_name(fulName);
                    readers.get(i).setGmail(gmail);
                    readers.get(i).setPhone_number(phone_number);
                }
            } else {
                System.out.println("Читетель под: "+id+" не найдено!");
            }
        }
        return readers;
    }

    @Override
    public void assignReaderToLibrary(Database database, Long readerId, Long libraryId) {

    }
}
