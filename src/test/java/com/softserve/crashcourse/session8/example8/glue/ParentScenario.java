package com.softserve.crashcourse.session8.example8.glue;

import com.softserve.crashcourse.session8.example8.DownloadPage;
import com.softserve.crashcourse.session8.example8.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ParentScenario {

    private WebDriver driver;

    protected DownloadPage downloadPage;
    protected MainPage mainPage;

    protected void startBrowser() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        downloadPage = new DownloadPage(driver);
        mainPage = new MainPage(driver);
    }

    protected void navigateTo() {
        driver.navigate().to("http://docs.seleniumhq.org/");
    }

    protected void closeBrowser() {
        driver.quit();
    }

}
