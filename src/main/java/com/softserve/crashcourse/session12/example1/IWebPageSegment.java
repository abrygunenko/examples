package com.softserve.crashcourse.session12.example1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IWebPageSegment {

    WebDriver getWebDriver();

    WebDriver setWebDriver(WebDriver webDriver);

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
}
