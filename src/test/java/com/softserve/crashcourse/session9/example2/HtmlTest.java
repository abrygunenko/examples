package com.softserve.crashcourse.session9.example2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HtmlTest {
//    private WebDriver driver = new FirefoxDriver();
    private WebDriver driver = new ChromeDriver();
    private String pathToHtmlFile =
            "file:\\\\\\D:\\Repos\\new\\src\\test\\resources\\com\\softserve\\crashcourse\\session9\\example2\\testdata\\forTest.html";

    @BeforeClass
    public void oneTimeSetUp() {
        // one-time initialization code
        driver.get(pathToHtmlFile);
        System.out.println("@BeforeClass - oneTimeSetUp " + driver.getCurrentUrl());
        Reporter.log("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass(alwaysRun = true)
    public void oneTimeTearDown() {
        // one-time cleanup code
        driver.quit();
        System.out.println("@AfterClass - oneTimeTearDown");
        Reporter.log("@AfterClass - oneTimeTearDown");
    }

    @Test(groups = "group1")
    public void testingMethod11() {
        Reporter.log("Running Testing method11");
        WebElement element = driver.findElement(By.name("msnlink"));
        Assert.assertEquals("MSN", element.getText());
        System.out.println("Method - testingMethod11( ): " + element.getText());
    }

    @Test(groups = "group1")
    public void testingMethod12() {
        Reporter.log("Running Testing method12");
        WebElement element = driver.findElement(By.id("1"));
        Assert.assertEquals("http://www.msn.com/",
                element.getAttribute("href"));
        System.out.println("Method - testingMethod12( ): "
                + element.getAttribute("href"));
    }

    @Test(groups = "group2")
    public void testingMethod21() {
        Reporter.log("Running Testing method21");
        WebElement element = driver.findElement(By.name("checkthebox"));
        element.click();
        Assert.assertTrue(element.isSelected());
        System.out.println("Method - testingMethod21( ): "
                + element.getTagName() + " " + element.isSelected());
    }

    @Test(groups = "group3")
    public void testingMethod31() {
        Reporter.log("Running Testing method31");
        WebElement element = driver.findElement(By.xpath("/html/body/img"));
        Assert.assertTrue(element.isDisplayed());
        System.out.println("Method - testingMethod31( ): " + element.isDisplayed());
    }
}
