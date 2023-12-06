package madel;

import java.util.ArrayList;

public class Library {//id, name, address, List<Book>books, List<Reader>readers
    public static long ID = 0;
    private long id;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library( String address, ArrayList<Book> books, ArrayList<Reader> readers) {
        this.id = ++ID;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }

    public static long getID() {
        return ID;
    }

    public static void setID(long ID) {
        Library.ID = ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Library " +
                "id = " + id +
                ", address = " + address +
                ", books = " + books +
                ", readers = " + readers + "\n";
    }
}
