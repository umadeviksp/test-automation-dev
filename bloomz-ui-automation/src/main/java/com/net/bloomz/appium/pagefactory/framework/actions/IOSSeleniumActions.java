package com.net.bloomz.appium.pagefactory.framework.actions;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.net.bloomz.appium.pagefactory.framework.browser.mobile.IOSMobileBrowser;

/**
 * Selenium Actions for iOS Applications
 * <p>
 * Currently, only scrollTo option is implemented differently for iOS
 */
public class IOSSeleniumActions extends BaseSeleniumActions<IOSMobileBrowser> {

    public IOSSeleniumActions(IOSMobileBrowser browser) {
        super(browser);
    }

    @Override
    public void scrollIntoView(WebElement el) {
        boolean elementInView = el.isDisplayed();
        while (!elementInView) {
            getBrowser().dragUp();
            elementInView = el.isDisplayed();
        }
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        String widId = ((RemoteWebElement) el).getId();
        scrollObject.put("element", widId);
        getBrowser().getWebDriver().executeScript("mobile: scrollTo", scrollObject);
    }
}
