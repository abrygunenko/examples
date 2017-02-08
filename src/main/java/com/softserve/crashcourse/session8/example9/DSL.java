package com.softserve.crashcourse.session8.example9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void click(String text) {
        click(By.linkText(text));
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public boolean hasElement(By by) {
        return !driver.findElements(by).isEmpty();
    }

}