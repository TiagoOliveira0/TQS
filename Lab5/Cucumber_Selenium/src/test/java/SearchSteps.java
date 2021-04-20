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

    @And("I choose a flight")
    public void iChoose() {
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
    }

    @And("I fill the form with my personal info")
    public void iFill() {
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Tiago Oliveira");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Rua da morgadinha 292");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Porto");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("Grijó");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("4415-489");
        driver.findElement(By.id("cardType")).click();
        driver.findElement(By.cssSelector("option:nth-child(3)")).click();
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("1111111111111111");
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys("10");
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2021");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Tiago Oliveira");
    }

    @Then("I should be shown results including {string}")
    public void iShouldBeShownResultsIncluding(String result) {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertThat(driver.getTitle(), is(result));
        driver.quit();
    }

}

