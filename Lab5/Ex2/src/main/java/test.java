import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class test {
    public static void main(String[] args){
        Book b1 = new Book("One good book","Fred Kruger", LocalDateTime.of(2013,3,14,0,0));
        Book b2 = new Book("Some other book","Tim Tomson", LocalDateTime.of(2014,8,23,0,0));
        Book b3 = new Book("How to cook a dino","Fred Flintstone", LocalDateTime.of(2012,1,1,0,0));

        Library l = new Library();

        l.addBook(b1);
        l.addBook(b2);
        l.addBook(b3);

        List<Book> books = l.findBooks(LocalDateTime.of(2013,1,1,0,0),LocalDateTime.of(2014,12,31,0,0));

        for(Book b:books){
            System.out.println(b.getTitle());
        }

        List<Book> books1 = l.findBooksByAuthor("Fred");

        for(Book b:books1){
            System.out.println(b.getTitle());
        }

    }
}
