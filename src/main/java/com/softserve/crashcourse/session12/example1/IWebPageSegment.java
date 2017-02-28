package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IWebPageSegment {

    WebDriver getWebDriver();

    WebElement locateElement(By locator);

    WebElement locateElement(WebElement webElement, By locator);

    List<WebElement> locateElements(By locator);

    void clickOnElement(By locator);

    void clickOnElement(WebElement webElement, By locator);

    void submitForm(By locator);

    void submitForm(WebElement webElement, By locator);

    void enterValue(By locator, String value);

    void enterValue(WebElement webElement, By locator, String value);

    void selectOptionByText(By locator, String text);

    void selectOptionByText(WebElement webElement, By locator, String text);

    void selectOptionByValue(By locator, String value);

    void selectOptionByValue(WebElement webElement, By locator, String value);

    void selectOptionByIndex(By locator, int index);

    void selectOptionByIndex(WebElement webElement, By locator, int index);

    String getElementText(By locator);

    String getElementText(WebElement webElement, By locator);

    Boolean verifyElementText(By locator, String expectedText);

    Boolean verifyElementText(WebElement webElement, By locator, String expectedText);

    String getElementAttributeValue(By locator, String attributeName);

    String getElementAttributeValue(WebElement webElement, By locator, String attributeName);

    Boolean verifyElementAttributeValue(By locator, String attributeName, String expectedAttributeValue);

    Boolean verifyElementAttributeValue(WebElement webElement, By locator, String attributeName, String expectedAttributeValue);
}
