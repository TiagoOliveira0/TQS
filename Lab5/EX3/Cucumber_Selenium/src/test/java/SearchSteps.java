import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        System.setProperty("webdriver.gecko.driver", "/opt/webdriver/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @And("I buy a flight to {string}")
    public void iBuy(String searchQuery) {
        driver.manage().window().setSize(new Dimension(550, 704));
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'San Diego']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(5)")).click();
        driver.findElement(By.name("toPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = " + "'" + searchQuery + "']")).click();
        }
    }

    @And("I choose a flight {string}")
    public void iChoose(String flight) {
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(" + flight + ")")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(" + flight + ") .btn")).click();
    }

    @And("I fill the form with my personal info name: {string}, address: {string}, city: {string}, state: {string}, zip: {string}, cn: {string}, cnMonth: {string}, cnYear: {string}, cnName: {string}")
    public void iFill(String name, String address, String city, String state, String zip, String cn, String cnMonth, String cnYear, String cnName) {
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys(name);
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys(address);
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys(zip);
        driver.findElement(By.id("cardType")).click();
        driver.findElement(By.cssSelector("option:nth-child(3)")).click();
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys(cn);
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys(cnMonth);
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys(cnYear);
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys(cnName);
    }

    @Then("I should be shown results including {string}")
    public void iShouldBeShownResultsIncluding(String result) {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertThat(driver.getTitle(), is(result));
        driver.quit();
    }


}

