package com.softserve.crashcourse.session12.example1.webpages;

import com.softserve.crashcourse.session12.example1.AbstractWebPageSegment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractWebPage extends AbstractWebPageSegment implements IWebPage {

    private String baseUrl;
    private String baseUrlSuffix;
    private String pageTitle;

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

    public String getPageTitle() {
        return pageTitle;
    }

    public String setPageTitle(String webPageTitle) {
        this.pageTitle = webPageTitle;
        return getPageTitle();
    }

    public AbstractWebPage(String pageTitle, String baseUrl, String baseUrlSuffix) {
        super();
        setBaseUrl(baseUrl);
        setBaseUrlSuffix(baseUrlSuffix);
        setPageTitle(pageTitle);
    }

    @Override
    public IWebPage initializePage() {
        verifyWebPageTitle(getPageTitle());
        return this;
    }

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
        Boolean titleIsEqual;
        WebDriver webDriver = getWebDriver();

        try {
            // nullify implicitlyWait( )
            webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

            // Create web element
            titleIsEqual = new WebDriverWait(webDriver, getDefaultExplicitWaitTimeout())
                    .until(ExpectedConditions.titleIs(expectedWebPageTitle));

            // reset implicitlyWait( )
            webDriver.manage().timeouts().implicitlyWait(getDefaultImplicitWaitTimeout(), TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        if (!titleIsEqual) {
            throw new RuntimeException("Page title does't match.\nExpected: " + expectedWebPageTitle
                    + "\nFound: " + getWebPageTitle());
        } else {
            return true;
        }
    }
}
