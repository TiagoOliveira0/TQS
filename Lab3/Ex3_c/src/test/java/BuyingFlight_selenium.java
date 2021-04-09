// Generated by Selenium IDE


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
@ExtendWith(SeleniumJupiter.class)
public class BuyingFlight_selenium {

    @Test
    public void buyingFlight(ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
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
            dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
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
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
    }

    @Test
    void testWithFirefox(FirefoxDriver driver) {
        // Use Firefox in this test
        driver.get("https://www.ua.pt");
        assertThat(driver.getTitle(), containsString("Universidade de Aveiro"));
    }

    @Test
    void testWithChromeAndFirefox(FirefoxDriver driver1, ChromeDriver driver2) {
        // Use Chrome and Firefox in this test
        driver1.get("http://www.seleniumhq.org/");
        driver2.get("http://www.junit.org/junit5/");
        assertThat(driver1.getTitle(), startsWith("Selenium"));
        assertThat(driver2.getTitle(), equalTo("JUnit 5"));
    }

    @Test
    void testWithHeadlessBrowser(HtmlUnitDriver driver){
        driver.get("https://www.ua.pt");
        assertThat(driver.getTitle(), containsString("Universidade de Aveiro"));
    }
}

