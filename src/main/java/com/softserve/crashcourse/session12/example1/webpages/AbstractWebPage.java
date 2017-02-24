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
    public abstract IWebPage initializePage();

    @Override
    public IWebPage openPage() {
        getWebDriver().get(getBaseUrl() + getBaseUrlSuffix());
        initializePage();
        return this;
    }

    @Override
    public IWebPage refreshPage() {
        getWebDriver().navigate().refresh();
        initializePage();
        return this;
    }

    @Override
    public String getWebPageTitle() {
        return getWebDriver().getTitle();
    }

    @Override
    public String getWebPageUrl() {
        return getWebDriver().getCurrentUrl();
    }

    @Override
    public Boolean verifyWebPageTitle(String expectedWebPageTitle) {
        String actualWebPageTitle = getWebPageTitle();
        if (!actualWebPageTitle.equals(expectedWebPageTitle)) {
            throw new RuntimeException("Page title does't match.\nExpected: " + expectedWebPageTitle
                    + "\nFound: " + actualWebPageTitle);
        } else {
            return true;
        }
    }
}
