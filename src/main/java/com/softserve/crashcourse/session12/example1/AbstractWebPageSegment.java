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

    private long defaultImplicitWaitTimeout = 10;
    private long defaultExplicitWaitTimeout = 10;

    public AbstractWebPageSegment() {
        getWebDriver().manage().timeouts().implicitlyWait(getDefaultImplicitWaitTimeout(), TimeUnit.SECONDS);
    }

    @Override
    public WebDriver getWebDriver() {
        return WebDriverBuilder.INSTANCE.getWebDriver();
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

    public Browser getBrowser() {
        return WebDriverBuilder.INSTANCE.getBrowser();
    }

    @Override
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
            throw e;
        }

        if (webElement == null) {
            throw new ElementNotVisibleException("Element isn't visible: " + locator.toString());
        } else {
            return webElement;
        }
    }

    @Override
    public WebElement locateElement(By locator) {
        return locateElement(locator, getDefaultExplicitWaitTimeout());
    }

    @Override
    public WebElement locateElement(WebElement webElement, By locator) {
        return webElement.findElement(locator);
    }

    @Override
    public void clickOnElement(By locator) {
        locateElement(locator).click();
    }

    @Override
    public void clickOnElement(WebElement webElement, By locator) {
        webElement.findElement(locator).click();
    }

    @Override
    public void submitForm(By locator) {
        locateElement(locator).submit();
    }

    @Override
    public void submitForm(WebElement webElement, By locator) {
        webElement.findElement(locator).submit();
    }

    @Override
    public void enterValue(By locator, String value) {
        WebElement inputField = locateElement(locator);
        inputField.clear();
        inputField.sendKeys(value);
    }

    @Override
    public void enterValue(WebElement webElement, By locator, String value) {
        WebElement inputField = webElement.findElement(locator);
        inputField.clear();
        inputField.sendKeys(value);
    }


    public Select createSelectWebElement(WebElement webElement) {
        Select select = new Select(webElement);
        select.deselectAll();
        return select;
    }

    public void selectOptionByText(WebElement webElement, String text) {
        createSelectWebElement(webElement).selectByVisibleText(text);
    }

    @Override
    public void selectOptionByText(By locator, String text) {
        selectOptionByText(locateElement(locator), text);
    }

    @Override
    public void selectOptionByText(WebElement webElement, By locator, String text) {
        selectOptionByText(webElement.findElement(locator), text);
    }

    public void selectOptionByValue(WebElement webElement, String value) {
        createSelectWebElement(webElement).selectByValue(value);
    }

    @Override
    public void selectOptionByValue(By locator, String value) {
        selectOptionByValue(locateElement(locator), value);
    }

    @Override
    public void selectOptionByValue(WebElement webElement, By locator, String value) {
        selectOptionByValue(webElement.findElement(locator), value);
    }

    public void selectOptionByIndex(WebElement webElement, int index) {
        createSelectWebElement(webElement).selectByIndex(index);
    }

    @Override
    public void selectOptionByIndex(By locator, int index) {
        selectOptionByIndex(locateElement(locator), index);
    }

    @Override
    public void selectOptionByIndex(WebElement webElement, By locator, int index) {
        selectOptionByIndex(webElement.findElement(locator), index);
    }

    @Override
    public String getElementText(By locator) {
        return locateElement(locator).getText();
    }

    @Override
    public String getElementText(WebElement webElement, By locator) {
        return webElement.findElement(locator).getText();
    }

    @Override
    public Boolean verifyElementText(By locator, String expectedText) {
        String actualText = getElementText(locator);
        return verifyText(actualText, expectedText);
    }

    @Override
    public Boolean verifyElementText(WebElement webElement, By locator, String expectedText) {
        String actualText = getElementText(webElement, locator);
        return verifyText(actualText, expectedText);
    }

    public Boolean verifyText(String actualText, String expectedText) {
        if (!actualText.equals(expectedText)) {
            throw new RuntimeException("Web element text does't match.\nExpected: " + expectedText
                    + "\nFound: " + actualText);
        } else {
            return true;
        }
    }

    @Override
    public String getElementAttributeValue(By locator, String attributeName) {
        return locateElement(locator).getAttribute(attributeName);
    }

    @Override
    public String getElementAttributeValue(WebElement webElement, By locator, String attributeName) {
        return webElement.findElement(locator).getAttribute(attributeName);
    }

    @Override
    public Boolean verifyElementAttributeValue(By locator, String attributeName, String expectedAttributeValue) {
        String actualAttributeValue = getElementAttributeValue(locator, attributeName);
        return verifyAttributeValue(actualAttributeValue, expectedAttributeValue, attributeName);
    }

    @Override
    public Boolean verifyElementAttributeValue(WebElement webElement, By locator, String attributeName, String expectedAttributeValue) {
        String actualAttributeValue = getElementAttributeValue(webElement, locator, attributeName);
        return verifyAttributeValue(actualAttributeValue, expectedAttributeValue, attributeName);
    }

    public Boolean verifyAttributeValue(String actualValue, String expectedValue, String attributeName) {
        if (!actualValue.equals(expectedValue)) {
            throw new RuntimeException("Web element '" + attributeName + "' attribute value does't match.\nExpected: "
                    + expectedValue + "\nFound: " + actualValue);
        } else {
            return true;
        }
    }

    public void verifyElementTitle(By locator, String expectedElementTitle) {
        verifyElementAttributeValue(locator, "title", expectedElementTitle);
    }

    public void verifyElementTitle(WebElement webElement, By locator, String expectedElementTitle) {
        verifyElementAttributeValue(webElement, locator, "title", expectedElementTitle);
    }
}
