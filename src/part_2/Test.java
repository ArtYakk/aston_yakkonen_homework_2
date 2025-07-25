package part_2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

record Book(String author, String title, int yearOfPublication, int pages) {
}

record Student(String name, List<Book> books) {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        List<Book> allBooks = List.of(
                new Book("George Orwell", "1984", 1949, 328),
                new Book("Aldous Huxley", "Brave New World", 1932, 288),
                new Book("J.R.R. Tolkien", "The Hobbit", 1937, 310),
                new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 1997, 320),
                new Book("Leo Tolstoy", "War and Peace", 1869, 1225),
                new Book("Fyodor Dostoevsky", "Crime and Punishment", 1866, 671),
                new Book("Jane Austen", "Pride and Prejudice", 1813, 432),
                new Book("Mark Twain", "The Adventures of Tom Sawyer", 1876, 274),
                new Book("Harper Lee", "To Kill a Mockingbird", 1960, 336),
                new Book("Ernest Hemingway", "The Old Man and the Sea", 1952, 127),
                new Book("Ray Bradbury", "Fahrenheit 451", 1953, 194),
                new Book("Gabriel Garcia Marquez", "One Hundred Years of Solitude", 1967, 417),
                new Book("Mary Shelley", "Frankenstein", 1818, 280),
                new Book("Franz Kafka", "The Trial", 1925, 255),
                new Book("George R.R. Martin", "A Game of Thrones", 1996, 694),
                new Book("Khaled Hosseini", "The Kite Runner", 2003, 371),
                new Book("Stieg Larsson", "The Girl with the Dragon Tattoo", 2005, 465),
                new Book("Suzanne Collins", "The Hunger Games", 2008, 374),
                new Book("Andy Weir", "The Martian", 2011, 384),
                new Book("Delia Owens", "Where the Crawdads Sing", 2018, 384)
        );

        List<Student> students = List.of(
                new Student("Alice", List.of(
                        allBooks.get(0),
                        allBooks.get(2),
                        allBooks.get(15),
                        allBooks.get(16),
                        allBooks.get(5)
                )),
                new Student("Bob", List.of(
                        allBooks.get(1),
                        allBooks.get(3),
                        allBooks.get(17),
                        allBooks.get(7),
                        allBooks.get(10)
                )),
                new Student("Charlie", List.of(
                        allBooks.get(4),
                        allBooks.get(8),
                        allBooks.get(18),
                        allBooks.get(6),
                        allBooks.get(12)
                )),
                new Student("Diana", List.of(
                        allBooks.get(9),
                        allBooks.get(11),
                        allBooks.get(13),
                        allBooks.get(19),
                        allBooks.get(17)
                )),
                new Student("Ethan", List.of(
                        allBooks.get(14),
                        allBooks.get(15),
                        allBooks.get(16),
                        allBooks.get(18),
                        allBooks.get(1)
                ))
        );



        students.stream()
                .peek(System.out::println)
                .map(Student::books)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(Book::pages))
                .distinct()
                .filter(book -> book.yearOfPublication() > 2000)
                .limit(3)
                .peek(book -> System.out.println(book.title() + " опубликована в " + book.yearOfPublication() + " году"))
                .findFirst()
                        .ifPresentOrElse(System.out::println, () -> System.out.println("Нет такой книги"));

    }
}
