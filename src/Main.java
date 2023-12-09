import enam.Gender;
import madel.Book;
import madel.Database;
import madel.Library;
import madel.Reader;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book("aa", "ddw", Gender.МУЖСКОЙ);
        Book book2 = new Book("yy", "dde", Gender.МУЖСКОЙ);
        Book book3 = new Book("dd", "ddr", Gender.МУЖСКОЙ);
        Book book4 = new Book("uu", "ddt", Gender.МУЖСКОЙ);
        Book book5 = new Book("oo", "ddy", Gender.МУЖСКОЙ);
        Book book6 = new Book("qq", "ddu", Gender.МУЖСКОЙ);

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

        Reader reader1 = new Reader("Муктар", "muktar@gmail.com", "12345678", Gender.МУЖСКОЙ);
        Reader reader2 = new Reader("Залкар", "zalkar@gmail.com", "234567890", Gender.МУЖСКОЙ);
        Reader reader3 = new Reader("Рамазан", "ramazan@gmail.com", "345678901", Gender.МУЖСКОЙ);
        Reader reader4 = new Reader("Даниэль", "daniel@gmail.com", "456789012", Gender.МУЖСКОЙ);
        Reader reader5 = new Reader("Азамат", "azamat@gmail.com", "567890123", Gender.МУЖСКОЙ);
        Reader reader6 = new Reader("Зафар", "zafar@gmail.com", "678901234", Gender.МУЖСКОЙ);

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

        Library library1 = new Library("Бишкек", bookArrayList1, arrayList1);
        Library library2 = new Library("Кара Балта", bookArrayList2, arrayList2);

        ArrayList<Library> libraryArrayList = new ArrayList<>();
        libraryArrayList.add(library1);
        libraryArrayList.add(library2);

        Database database = new Database(libraryArrayList, bookArrayList0, arrayList0);

        BookServiceImpl bookService = new BookServiceImpl();

        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        ReaderServiceImpl readerService = new ReaderServiceImpl();

        while (true) {
            System.out.println("Добро пожаловать!");
            System.out.println("Выберите действие!");
            System.out.print("""
                    1 Действие с книгой.
                    2 Действие с библиотекой.
                    3 Действие с читателем.
                    """);

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1 -> {
                    while (true) {
                        System.out.println("Выберите действие!");
                        System.out.print("""
                                1 Сохранить книгу.
                                2 Получить все книги.
                                3 Получить книгу по id.
                                4 Удалить книгу.
                                5 Очистить книги по id библиотеки.
                                6 Выход.
                                """);

                        int bookChoice = scanner.nextInt();

                        switch (bookChoice) {
                            case 1 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                Book book = new Book();
                                System.out.print("Название книги: ");
                                String bookName = scanner.next();
                                System.out.print("Автор книги: ");
                                String author = scanner.next();
                                System.out.println("Если автор женщина, введите 1. Если мужчина, введите 2");
                                int genderChoice = scanner.nextInt();
                                Gender gender = (genderChoice == 1) ? Gender.ЖЕНСКИЙ : Gender.МУЖСКОЙ;
                                book.setGender(gender);
                                book.setAuthor(author);
                                book.setName(bookName);
                                System.out.println(bookService.saveBook(database, libraryId, book));
                            }
                            case 2 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                System.out.println(bookService.getAllBooks(database, libraryId));
                            }
                            case 3 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                System.out.print("Введите id книги: ");
                                long bookId = scanner.nextLong();
                                System.out.println(bookService.getBookById(database, libraryId, bookId));
                            }
                            case 4 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                System.out.print("Введите id книги: ");
                                long bookId = scanner.nextLong();
                                System.out.println(bookService.deleteBook(database, libraryId, bookId));
                            }
                            case 5 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                bookService.clearBooksByLibraryId(database, libraryId);
                            }
                            case 6 -> {
                                return;
                            }
                            default -> System.out.println("Извините, но функции под этим номером не существует!");
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.println("Выберите действие!");
                        System.out.print("""
                                1 Сохранить библиотеку.
                                2 Получить все библиотеки.
                                3 Получить библиотеку по id.
                                4 Обновить библиотеку.
                                5 Удалить библиотеку.
                                6 Выход.
                                """);

                        int libraryChoice = scanner.nextInt();

                        switch (libraryChoice) {
                            case 1 -> {
                                Library li = new Library();
                                System.out.println(libraryService.saveLibrary(database, li));
                            }
                            case 2 -> System.out.println(libraryService.getAllLibraries(database));
                            case 3 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                System.out.println(libraryService.getLibraryById(database, libraryId));
                            }
                            case 4 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                Library library = new Library();
                                System.out.print("Введите новый адрес библиотеки: ");
                                String address = scanner.next();
                                System.out.println(libraryService.updateLibrary(database, libraryId, library, address));
                            }
                            case 5 -> {
                                System.out.print("Введите id библиотеки: ");
                                long libraryId = scanner.nextLong();
                                System.out.println(libraryService.deleteLibrary(database, libraryId));
                            }
                            case 6 -> {
                                return;
                            }
                            default -> System.out.println("Извините, но функции под этим номером не существует!");
                        }
                    }
                }
                case 3 -> {
                    while (true) {
                        System.out.println("Выберите действие!");
                        System.out.print("""
                                1 Добавить читателя.
                                2 Получить всех читетелей.
                                3 Получить читетеля по id.
                                4 Обновить читателя.
                                5 Назначить читателя библиотеке.
                                6 Выйти.
                                """);

                        int readerChoice = scanner.nextInt();

                        switch (readerChoice) {
                            case 1 -> {
                                Reader reader = new Reader();
                                readerService.saveReader(database, reader);
                            }
                            case 2 -> System.out.println(readerService.getAllReaders(database));
                            case 3 -> {
                                System.out.print("Введите id читатель: ");
                                long readerId = scanner.nextLong();
                                System.out.println(readerService.getReaderById(database, readerId));
                            }
                            case 4 -> {
                                System.out.print("Введите id читатель: ");
                                long readerId = scanner.nextLong();
                                Reader reader = new Reader();
                                System.out.print("Новое имя для читатель: ");
                                String fulName = scanner.next();
                                System.out.print("Новое gmail для читатель: ");
                                String gmail = scanner.next();
                                System.out.print("Новое номер для читатель: ");
                                String phoneNumber = scanner.next();
                                System.out.println(readerService.updateReader(database, readerId, reader, fulName, gmail, phoneNumber));
                            }
                            //case 5 ->  Назначить читателя библиотеке.Я ЭТО НЕ ПАНЯЛ КАК ЗДЕЛАТЬ
                        }
                    }
                }
                default -> System.out.println("Извините, но функции под этим номером не существует!");
            }
        }
    }
}
