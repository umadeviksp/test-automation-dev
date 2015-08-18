package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.appium.pagefactory.framework.browser.LocalBrowserBuilder;
import com.net.bloomz.appium.pagefactory.framework.browser.MobileBrowserBuilder;
import com.net.bloomz.appium.pagefactory.framework.browser.mobile.MobilePlatformName;
import com.net.bloomz.appium.pagefactory.framework.browser.web.WebBrowser;
import com.net.bloomz.appium.pagefactory.framework.browser.web.WebBrowserType;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutType;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutsConfig;
import com.net.bloomz.appium.pagefactory.framework.exception.IWebDriverException;

public class BaseTest {

  public static Browser<?> browser;
  public static String browserString = "";

  private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);


  @SuppressWarnings("static-access")
  @Parameters({"platformName", "browserType"})
  @BeforeClass(alwaysRun = true)
  public void setUp(String platformName, String browserType) throws IWebDriverException,
      MalformedURLException {
    
    
    Browser<?> browser = null;
    TimeoutsConfig timeouts =
        TimeoutsConfig.builder().pageLoadTimoutSeconds(60).implicitWaitTimeoutMillis(60000).build();

    if (platformName.equals("Android")) {
      browser =
          MobileBrowserBuilder.getAndroidBuilder("http://127.0.0.1:4723/wd/hub")
              .withTimeoutsConfig(timeouts).withVersion("1.0").withPlatform("ANDROID")
              .withPlatformName(MobilePlatformName.ANDROID).withPlatformVersion("5.0")
              .withDeviceName("Moto G")
              .withApp("/Users/manikandan/Desktop/BloomzApk/bloomz_16.apk")
              .withAppPackage("net.bloomz")
              .withAppActivity("md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity").build();

    } else if (platformName.equals("iOS")) {
      browser =
          MobileBrowserBuilder.getIOSBuilder("http://0.0.0.0:4725/wd/hub")
              .withTimeoutsConfig(timeouts).withVersion("1.0").withPlatform("MAC")
              .withPlatformName(MobilePlatformName.IOS).withPlatformVersion("5.0")
              .withDeviceName("Moto G").withApp("/Users/Moolya21/Documents/Bloomz/base.apk")
              .withAppPackage("net.bloomz")
              .withAppActivity("md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity").build();

    } else if (platformName.equals("Web")) {
      System.setProperty("webdriver.chrome.driver", "/Users/manikandan/Downloads/chromedriver");
      // browser =
      // LocalBrowserBuilder
      // .getBuilder(WebBrowserType.CHROME, "http://app-test01.bloomz.net:8000/#/app")
      // .withBrowserBinaryPath("/Users/manikandan/Downloads/chromedriver").build();
      // ((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());
      // browser =
      // RemoteBrowserBuilder.getBuilder(WebBrowserType.valueOf(browserType),
      // "http://app-test01.bloomz.net:8000/#/app", "http://169.254.148.189:4444/wd/hub")
      // .build();
      // ((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());



       if (browserType.equals(WebBrowserType.CHROME.toString())) {
       browser =
       LocalBrowserBuilder
       .getBuilder(WebBrowserType.CHROME, "http://app-test01.bloomz.net:8000/#/app")
       .withBrowserBinaryPath("/Users/manikandan/Downloads/chromedriver").build();
       ((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());
      
      
       } else if (browserType.equals(WebBrowserType.SAFARI.toString())) {
         SafariOptions options = new SafariOptions(); 
         options.setUseCleanSession(true);
       browser =
       LocalBrowserBuilder.getBuilder(WebBrowserType.SAFARI,
       "http://app-test01.bloomz.net:8000/#/app").build();
       ((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());
      
       }

    }
    this.browser = browser;
    browserString = platformName;
    
    


  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {

    // if (androidSessionId.equals(((RemoteWebDriver) browser.getWebDriver()).getSessionId()
    // .toString())) {
    // ((AndroidDriver) browser.getWebDriver()).quit();
    //
    // } else if (iOSSessionId.equals(((RemoteWebDriver) browser.getWebDriver()).getSessionId()
    // .toString())) {
    // ((IOSDriver) browser.getWebDriver()).quit();
    // } else if (webSessionId.equals(((RemoteWebDriver) browser.getWebDriver()).getSessionId()
    // .toString())) {
    // ((WebBrowser) browser).quit();
    // }
    // if (browser != null) {
    // String browserName = browser.toString();
    // if (browserName.contains("web")) {
    // System.out.println("Web Browser");
    // ((WebBrowser) browser).quit();
    // } else if (browserName.contains("Android")) {
    // System.out.println("Mobile Browser");
    // ((MobileBrowser) browser).quit();
    // }
    // }
    
    
    logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

    logger.info("X");

    logger.info("X");

    logger.info("X");

    logger.info("X");
    
 
    if (browser != null) {
      browser.quit();
    }


  }



  @BeforeMethod(alwaysRun = true)
  public void startMethod(Method method) {
    logger.info("****************************************************************************************");

    logger.info("****************************************************************************************");

    logger.info("$$$$$$$$$$$$$$$$$$$$$          " +method.getName()+ "          $$$$$$$$$$$$$$$$$$$$$$$$$");

    logger.info("****************************************************************************************");

    logger.info("****************************************************************************************");

  }


  @AfterMethod(alwaysRun = true)
  public void stopMethod() {
    if (browserString.equals("Android")) {
      ((AndroidDriver) browser.getWebDriver()).resetApp();
    }
    
    

    
    
  }

  public static String getPlatform() {
    if (browserString.equals("Android")) {
      System.out.println("Driver Instance : "
          + browser.getDesiredCapabilities().getCapability("platformName").toString());
      return browser.getDesiredCapabilities().getCapability("platformName").toString();
    }
    return "";

  }


  public static boolean waitForAnElement(By locator) {
    WebElement waitOnExpectedCondition =
        browser.getActions().waitOnExpectedCondition(
            ExpectedConditions.visibilityOfElementLocated(locator), "Element is not visible",
            TimeoutType.FORTY_SECONDS);
    return waitOnExpectedCondition.isDisplayed();
  }
}
