package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;
import org.openqa.selenium.WebDriver;

public abstract class AbstractWebPage extends AbstractWebPageSegment implements IWebPage {

    private String baseUrl;
    private String baseUrlSuffix;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrlSuffix() {
        return baseUrlSuffix;
    }

    public void setBaseUrlSuffix(String baseUrlSuffix) {
        this.baseUrlSuffix = baseUrlSuffix;
    }

    public AbstractWebPage(WebDriver webDriver, String baseUrl, String baseUrlSuffix) {
        super(webDriver);
        setBaseUrl(baseUrl);
        setBaseUrlSuffix(baseUrlSuffix);
    }

    @Override
    public abstract void initializePage();

    public IWebPage openPage(){
        getWebDriver().get(getBaseUrl() + getBaseUrlSuffix());
        return this;
    }
}
