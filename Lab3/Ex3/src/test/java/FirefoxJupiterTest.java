import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SeleniumJupiter.class)
class FirefoxJupiterTest {
    FirefoxDriver driver;

    public void FireFoxJupiterTest(FirefoxDriver driver){
        this.driver=driver;
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