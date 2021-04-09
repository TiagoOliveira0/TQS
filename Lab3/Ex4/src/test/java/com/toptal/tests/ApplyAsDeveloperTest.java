package com.toptal.tests;

import com.toptal.webpages.DeveloperApplyPage;
import com.toptal.webpages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplyAsDeveloperTest {
    WebDriver driver;

    @Before
    public void setup() {
        //use FF Driver
        System.setProperty("webdriver.gecko.driver", "/opt/webdriver/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void applyAsDeveloper() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnDeveloperApplyButton();


        //Create object of DeveloperApplyPage
        DeveloperApplyPage applyPage = new DeveloperApplyPage(driver);

        //Check if page is opened
        Assert.assertTrue(applyPage.isPageOpened());

        //Fill up data
        applyPage.setDeveloper_email("tiago.srv.oliveira@ua.pt");
        applyPage.setDeveloper_full_name("Tiago Oliveira Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");

        //Click on join
        //applyPage.clickOnJoin();
    }

    @After
    public void close() {
        driver.close();
    }
}