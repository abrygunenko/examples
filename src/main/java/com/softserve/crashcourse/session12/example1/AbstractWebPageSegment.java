package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractWebPageSegment implements IWebPageSegment {

    private WebDriver webDriver;
    private long defaultImplicitWaitTimeout = 10;
    private long defaultExplicitWaitTimeout = 5;

    public AbstractWebPageSegment(WebDriver webDriver) {
        setWebDriver(webDriver);
        getWebDriver().manage().timeouts().implicitlyWait(getDefaultImplicitWaitTimeout(), TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriver setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        return getWebDriver();
    }

    public long getDefaultImplicitWaitTimeout() {
        return defaultImplicitWaitTimeout;
    }

    public long setDefaultImplicitWaitTimeout(long defaultImplicitWaitTimeout) {
        this.defaultImplicitWaitTimeout = defaultImplicitWaitTimeout;
        return getDefaultImplicitWaitTimeout();
    }

    public long getDefaultExplicitWaitTimeout() {
        return defaultExplicitWaitTimeout;
    }

    public long setDefaultExplicitWaitTimeout(long defaultExplicitWaitTimeout) {
        this.defaultExplicitWaitTimeout = defaultExplicitWaitTimeout;
        return getDefaultExplicitWaitTimeout();
    }

    public List<WebElement> locateElements(By locator) {
        return getWebDriver().findElements(locator);
    }

    public WebElement locateElement(By locator, long explicitWaitTimeout) {
        WebElement webElement;
        WebDriver webDriver = getWebDriver();

        try {
            // nullify implicitlyWait( )
            webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

            // Create web element
            webElement = new WebDriverWait(webDriver, explicitWaitTimeout)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));

            // reset implicitlyWait( )
            webDriver.manage().timeouts().implicitlyWait(getDefaultImplicitWaitTimeout(), TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            webElement = null;
        }

        if (webElement == null) {
            throw new ElementNotVisibleException("Element isn't visible: " + locator.toString());
        } else {
            return webElement;
        }
    }

    public WebElement locateElement(By locator) {
        return locateElement(locator, getDefaultExplicitWaitTimeout());
    }

    public WebElement locateElement(WebElement webElement, By locator) {
        return webElement.findElement(locator);
    }

    public void clickOnElement(By locator) {
        locateElement(locator).click();
    }

    public void clickOnElement(WebElement webElement, By locator) {
        webElement.findElement(locator).click();
    }

    public void submitForm(By locator) {
        locateElement(locator).submit();
    }

    public void submitForm(WebElement webElement, By locator) {
        webElement.findElement(locator).submit();
    }

    public void enterValue(By locator, String value) {
        locateElement(locator).sendKeys(value);
    }

    public void enterValue(WebElement webElement, By locator, String value) {
        webElement.findElement(locator).sendKeys(value);
    }

    public void selectOptionByText(WebElement webElement, String text) {
        Select select = new Select(webElement);
        select.deselectAll();
        select.selectByVisibleText(text);
    }

    public void selectOptionByText(By locator, String text) {
        selectOptionByText(locateElement(locator), text);
    }

    public void selectOptionByText(WebElement webElement, By locator, String text) {
        selectOptionByText(webElement.findElement(locator), text);
    }

    public void selectOptionByValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.deselectAll();
        select.selectByValue(value);
    }

    public void selectOptionByValue(By locator, String value) {
        selectOptionByValue(locateElement(locator), value);
    }

    public void selectOptionByValue(WebElement webElement, By locator, String value) {
        selectOptionByValue(webElement.findElement(locator), value);
    }

    public void selectOptionByIndex(WebElement webElement, int index) {
        Select select = new Select(webElement);
        select.deselectAll();
        select.selectByIndex(index);
    }

    public void selectOptionByIndex(By locator, int index) {
        selectOptionByIndex(locateElement(locator), index);
    }

    public void selectOptionByIndex(WebElement webElement, By locator, int index) {
        selectOptionByIndex(webElement.findElement(locator), index);
    }
}
