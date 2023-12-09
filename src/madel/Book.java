package madel;

import enam.Gender;

public class Book {//id, name, author, Genre genre
    public static long ID = 0;
    private long id;
    private String name;
    private String author;
    private Gender gender;

    public Book() {
    }

    public Book( String name, String author, Gender gender) {
        this.id = ++ID;
        this.name = name;
        this.author = author;
        this.gender = gender;
    }

    public static long getID() {
        return ID;
    }

    public static void setID(long ID) {
        Book.ID = ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Book " +
                "id = " + id +
                ", name = " + name +
                ", author = " + author +
                ", gender = " + gender + "\n";
    }
}
