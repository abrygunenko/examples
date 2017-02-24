package com.softserve.crashcourse.session11.example4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestSample {
    private WebDriver driver;
    private long implicitlyWaitTimeout = 10;

    private long getImplicitlyWaitTimeout() {
        return implicitlyWaitTimeout;
    }

    private WebDriver getWebDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(getImplicitlyWaitTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement waitForElementVisible(final By by, long timeOutInSeconds) {
        WebElement webElement;

        try {
            // nullify implicitlyWait( )
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

            // Create web element
            webElement = new WebDriverWait(driver, timeOutInSeconds)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

            // reset implicitlyWait( )
            driver.manage().timeouts().implicitlyWait(getImplicitlyWaitTimeout(), TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return webElement;
    }

    @BeforeClass
    public void setUp() {
        // Start new WebDriver session, e.g. using Firefox
        driver = getWebDriver();
    }

    @Test
    public void newTest() {
        // Navigation
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement searchInputField = driver.findElement(By.id("lst-ib"));

        // Enter something to search for
        searchInputField.sendKeys("SeleniumHQ");

        // Submit the form.
        // WebDriver will find the form for us from the element
        searchInputField.submit();

        // Wait for page with search results to load
        driver.findElement(By.id("navcnt"));

        // Get Title
        System.out.println("Page title is: " + driver.getTitle());

        // Find element by link
        waitForElementVisible(By.cssSelector("a[href='http://www.seleniumhq.org/']"), 5).click();

        // Wait for page and elements on page to load
        waitForElementVisible(By.cssSelector(
                "a[href='https://www.testbirds.com/services/quality-assurance/testing-environment"
                        + "/?utm_source=seleniumhq&utm_campaign=int-cloud-logo-sponsoring-seleniumhq&utm_medium=logo-sponsoring']"
                        + " > img[src='/sponsors/testbirds.jpg']"), 10);

        // Find Download tab by CSS selector, check text and title
        WebElement downloadTab = waitForElementVisible(By.cssSelector("#menu_download > a"), 5);
        assertEquals(downloadTab.getText(), "Download");
        assertEquals(downloadTab.getAttribute("title"), "Get Selenium");
        downloadTab.click();

        // Wait for page and elements on page to load
        waitForElementVisible(By.id("nav"), 5);

        // Find selenium-java version by CSS selector and verify its value
        WebElement seleniumJavaVersion = waitForElementVisible(By.cssSelector(
                "p +table > tbody > tr:first-child > td:nth-child(2)"), 5);
        assertEquals(seleniumJavaVersion.getText(), "3.1.0");
    }

    @AfterClass
    public void tearDown() {
        // take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // now save the screenshot to a file some place
        try {
            FileUtils.copyFile(scrFile, new File("target\\screenshots\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
