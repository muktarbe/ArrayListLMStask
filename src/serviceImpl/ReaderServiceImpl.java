package serviceImpl;
import madel.Database;
import madel.Reader;
import service.ReaderService;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Database database, Reader reader) {

    }

    @Override
    public List<Reader> getAllReaders(Database database) {
        return null;
    }

    @Override
    public Reader getReaderById(Database database, Long id) {
        return null;
    }

    @Override
    public Reader updateReader(Database database, Long id, Reader reader) {
        return null;
    }

    @Override
    public void assignReaderToLibrary(Database database, Long readerId, Long libraryId) {

    }
}
