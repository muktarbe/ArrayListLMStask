import enam.Gender;
import madel.Book;
import madel.Database;
import madel.Library;
import madel.Reader;
import serviceImpl.BookServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Database database = new Database();

        BookServiceImpl bookService = new BookServiceImpl();

        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();
        Book book6 = new Book();

        ArrayList<Book> bookArrayList0 = new ArrayList<>();
        bookArrayList0.add(book1);
        bookArrayList0.add(book2);
        bookArrayList0.add(book3);
        bookArrayList0.add(book4);
        bookArrayList0.add(book5);
        bookArrayList0.add(book6);

        ArrayList<Book> bookArrayList1 = new ArrayList<>();
        bookArrayList1.add(book1);
        bookArrayList1.add(book2);
        bookArrayList1.add(book3);

        ArrayList<Book> bookArrayList2 = new ArrayList<>();
        bookArrayList2.add(book4);
        bookArrayList2.add(book5);
        bookArrayList2.add(book6);

        Reader reader1 = new Reader("Муктар","muktar@gmail.com","12345678",Gender.МУЖСКОЙ);
        Reader reader2 = new Reader("Залкар","zalkar@gmail.com","234567890",Gender.МУЖСКОЙ);
        Reader reader3 = new Reader("Рамазан","ramazan@gmail.com","345678901",Gender.МУЖСКОЙ);
        Reader reader4 = new Reader("Даниэль","daniel@gmail.com","456789012",Gender.МУЖСКОЙ);
        Reader reader5 = new Reader("Азамат","azamat@gmail.com","567890123",Gender.МУЖСКОЙ);
        Reader reader6 = new Reader("Зафар","zafar@gmail.com","678901234",Gender.МУЖСКОЙ);

        ArrayList<Reader> arrayList0 = new ArrayList<>();
        arrayList0.add(reader1);
        arrayList0.add(reader2);
        arrayList0.add(reader3);
        arrayList0.add(reader4);
        arrayList0.add(reader5);
        arrayList0.add(reader6);

        ArrayList<Reader> arrayList1 = new ArrayList<>();
        arrayList1.add(reader1);
        arrayList1.add(reader2);
        arrayList1.add(reader3);

        ArrayList<Reader> arrayList2 = new ArrayList<>();
        arrayList2.add(reader4);
        arrayList2.add(reader5);
        arrayList2.add(reader6);

        Library library1 = new Library("Бишкек",bookArrayList1,arrayList1);
        Library library2 = new Library("Кара Балта",bookArrayList2,arrayList2);

        ArrayList<Library> libraryArrayList = new ArrayList<>();
        libraryArrayList.add(library1);
        libraryArrayList.add(library2);

        Database database = new Database(libraryArrayList,bookArrayList0,arrayList0);

        System.out.println("Добра пожаловать!");
        System.out.println("Выберите действие!");
        System.out.print("""
                1 Действие с книшкой.
                2 Действие с бибилиотекой.
                3 Действие с читателя.
                """);
        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.println("Выберите действие!");
                System.out.print("""
                        1 сохранить Книгу
                        2 Получить все книги
                        3 получить Книгу по id
                        4 Удалить книгу
                        5 очистить Книги по id библиотеки
                        """);
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.print("ведите id бибилиотеки: ");
                        long ss = scanner.nextLong();
                        Book book = new Book();
                        System.out.print("Название книги");
                        String dd = scanner.next();
                        System.out.print("Афтор книги: ");
                        String yy = scanner.next();
                        System.out.println("Если афтор женщина 1."+"Если мушина 2");
                        int y = scanner.nextInt();
                        if (y == 1){
                            book.setGender(Gender.ЖЕНСКИЙ);
                        }else {
                            book.setGender(Gender.МУЖСКОЙ);
                        }
                        bookService.saveBook(database,ss,book);
                    }
                    case 2 -> {
                        System.out.print("ведите id бибилиотеки: ");
                        long ss = scanner.nextLong();
                        bookService.getAllBooks(database,ss);
                    }
                    case 3 -> {
                        System.out.print("ведите id бибилиотеки: ");
                        long ss = scanner.nextLong();
                        System.out.print("ведите id книги: ");
                        long ee = scanner.nextLong();
                        bookService.getBookById(database,ss,ee);
                    }
                    case 4 -> {
                        System.out.print("ведите id бибилиотеки: ");
                        long ss = scanner.nextLong();
                        System.out.print("ведите id книги: ");
                        long ee = scanner.nextLong();
                        bookService.deleteBook(database,ss,ee);
                    }
                    case 5 -> {
                        System.out.print("ведите id бибилиотеки: ");
                        long ss = scanner.nextLong();
                        bookService.clearBooksByLibraryId(database,ss);
                    }
                }
            }
            case 2 -> {
                System.out.println("Выберите действие!");

            }
        }

    }
}
