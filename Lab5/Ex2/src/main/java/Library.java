import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> store = new ArrayList<>();

    public void addBook(final Book book) {
        store.add(book);
    }

    public List<Book> findBooks(final LocalDateTime from, final LocalDateTime to) {
        Calendar end = Calendar.getInstance();
        Date f_to = Date.from(to.atZone(ZoneId.systemDefault()).toInstant());
        Date f_from = Date.from(from.atZone(ZoneId.systemDefault()).toInstant());
        end.setTime(f_to);
        end.roll(Calendar.YEAR, 1);

        return store.stream().filter(book -> {
            return f_from.before(Date.from(book.getPublished().atZone(ZoneId.systemDefault()).toInstant())) && end.getTime().after(Date.from(book.getPublished().atZone(ZoneId.systemDefault()).toInstant()));
        }).sorted(Comparator.comparing(Book::getPublished).reversed()).collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> res = new ArrayList<>();

        for(Book b:store){
            if(b.getAuthor().contains(author)){
                res.add(b);
            }
        }

        return res.stream().sorted(Comparator.comparing(Book::getPublished)).collect(Collectors.toList());
    }
}
