package madel;
import java.util.List;

public class Database {
    public List<Library> libraries;
    public List<Book> books;
    public List<Reader> readers;

    public Database() {
    }

    public Database(List<Library> libraries, List<Book> books, List<Reader> readers) {
        this.libraries = libraries;
        this.books = books;
        this.readers = readers;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Database{" +
                "libraries=" + libraries +
                ", books=" + books +
                ", readers=" + readers +
                '}';
    }
}