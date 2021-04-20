import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

    @Given("another book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewAnother(final String title, final String author, final LocalDateTime published){
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @Given("a book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewA(final String title, final String author, final LocalDateTime published){
        Book book = new Book(title, author, published);
        library.addBook(book);
    }


    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void the_customer_searches_for_books_published_between_and(final LocalDateTime s1, final LocalDateTime s2){
        result = library.findBooks(s1, s2);
    }

    @Then("{int} books should have been found")
    public void book_should_have_been_found(Integer int1) {
        assertEquals(int1, result.size());
    }

    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title(Integer int1, String string) {
        assertEquals(result.get(int1-1).getTitle(), string);
    }

    @When("the customer searches for books by {string}")
    public void theCustomerSearchesForBooksByFred(String author) {
        result = library.findBooksByAuthor(author);
    }

}
