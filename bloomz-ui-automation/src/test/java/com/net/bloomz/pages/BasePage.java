package com.net.bloomz.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.net.bloomz.appium.pagefactory.framework.actions.SeleniumActions;
import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutType;
import com.net.bloomz.appium.pagefactory.framework.pages.BaseTopLevelPage;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePage.
 */
@SuppressWarnings("unchecked")
public abstract class BasePage extends BaseTopLevelPage<SeleniumActions> {

  WebDriverWait driverWait;

  Browser<?> browser;

  public BasePage(Browser<?> browser) {
    this.browser = browser;
  }

  /**
   * Send text.
   *
   * @param locator the locator
   * @param text the text
   * @return the base page
   */
  public BasePage sendText(By locator, String text) {
    waitForElement(locator);
    if (getPlatformName().equals("Android")) {
      click(locator);
    }
    browser.getActions().getElement(locator).clear();
    browser.getActions().inputText(locator, text);
    if (getPlatformName().equals("Android")) {
      System.out.println("Base Page : " + getPlatformName().equals("Android"));
      ((AndroidDriver<?>) browser.getWebDriver()).hideKeyboard();
    }
    return this;

  }

  /**
   * Click.
   *
   * @param locator the locator
   * @return the base page
   */
  public BasePage click(By locator) {
    waitForElement(locator);
    if (getPlatformName().equals("")) {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    browser.getActions().click(locator, TimeoutType.FORTY_SECONDS);
    return this;
  }


  /**
   * Click back.
   *
   * @return the base page
   */
  public BasePage clickBack() {
    browser.getWebDriver().navigate().back();
    return this;

  }

  /**
   * Gets the text.
   *
   * @param locator the locator
   * @return the text
   */
  public String getText(By locator) {
    waitForElement(locator);
    return browser.getActions().getElement(locator).getText();
  }

  /**
   * Wait for element.
   *
   * @param locator the locator
   * @return the web element
   */
  public WebElement waitForElement(By locator) {
    driverWait = new WebDriverWait(browser.getWebDriver(), 40);
    return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  /**
   * Swipe right.
   *
   * @param id the id
   * @param offset the offset
   * @param duration the duration
   * @return the base page
   */
  public BasePage swipeRight(String id, int offset, int duration) {
    MobileElement element1 =
        (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
    int offset1 = 1;
    Point p1 = element1.getCenter();
    Point location1 = element1.getLocation();
    Dimension size1 = element1.getSize();
    ((AndroidDriver<?>) browser.getWebDriver()).swipe(location1.getX() + offset1 + offset,
        p1.getY(), location1.getX() + size1.getWidth() - offset1, p1.getY(), duration);
    return this;
  }

  /**
   * Swipe left.
   *
   * @param id the id
   * @param duration the duration
   * @return the base page
   */
  public BasePage swipeLeft(String id, int duration) {
    MobileElement element =
        (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
    int offset = 1;
    Point p = element.getCenter();
    Point location = element.getLocation();
    Dimension size = element.getSize();
    ((AndroidDriver<?>) browser.getWebDriver()).swipe(location.getX() + size.getWidth() - offset,
        p.getY(), location.getX() + offset, p.getY(), 1000);
    return this;
  }

  /**
   * Swipe up.
   *
   * @param id the id
   * @param offsetFromStartBorder the offset from start border
   * @param offsetFromEndBorder the offset from end border
   * @param duration the duration
   * @return the base page
   */
  public BasePage swipeUp(String id, int offsetFromStartBorder, int offsetFromEndBorder,
      int duration) {
    MobileElement element =
        (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
    element.swipe(SwipeElementDirection.UP, offsetFromStartBorder, offsetFromEndBorder, duration);
    return this;
  }

  /**
   * Swipe down.
   *
   * @param id the id
   * @param offsetFromStartBorder the offset from start border
   * @param offsetFromEndBorder the offset from end border
   * @param duration the duration
   * @return the base page
   */
  public BasePage swipeDown(String id, int offsetFromStartBorder, int offsetFromEndBorder,
      int duration) {
    waitForElement(By.id(id));
    MobileElement element =
        (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElementById(id);
    element.swipe(SwipeElementDirection.DOWN, offsetFromStartBorder, offsetFromEndBorder, duration);
    return this;
  }

  /**
   * Gets the list contents.
   *
   * @param locator the locator
   * @return the list contents
   */
  public ArrayList<String> getListContents(By locator) {
    java.util.List<WebElement> findElements =
        ((AndroidDriver<WebElement>) browser.getWebDriver()).findElements(locator);
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.clear();
    Iterator<WebElement> iterator = findElements.iterator();
    while (iterator.hasNext()) {
      WebElement next = iterator.next();
      arrayList.add(next.getText().toString());

    }
    return arrayList;

  }

  /**
   * Scroll to.
   *
   * @param locator the locator
   * @param text the text
   * @param direction the direction
   * @return the base page
   * @throws InterruptedException the interrupted exception
   */
  public BasePage scrollTo(By locator, String text, String direction) throws InterruptedException {

    MobileElement element =
        (MobileElement) ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator);
    JavascriptExecutor js = (JavascriptExecutor) ((AndroidDriver<?>) browser.getWebDriver());
    java.util.HashMap<String, String> scrollObject = new java.util.HashMap<String, String>();
    scrollObject.put("direction", direction);
    scrollObject.put("text", text);
    scrollObject.put("element", ((RemoteWebElement) element).getId());
    js.executeScript("mobile: scrollTo", scrollObject);
    return this;
  }

  public WebElement getWebElement(By locator) {
    return ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator);

  }

  public boolean isWebElementDisplayed(By locator) {
    return ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator).isDisplayed();

  }

  public void setTimeToTimePicker(String firstField, String secondField, String thirdField) {

    List<WebElement> date =
        ((AndroidDriver<WebElement>) browser.getWebDriver()).findElements(By
            .className("android.widget.NumberPicker"));
    date.get(0).click();
    if (!date.get(0).isDisplayed()) {
      ((AndroidDriver<?>) browser.getWebDriver()).findElement(By.id("net.bloomz:id/txtfromtime"))
          .click();
    }
    date.get(0).sendKeys(firstField);
    date.get(1).sendKeys(secondField);
    date.get(2).sendKeys(thirdField);
  }


  public void setDateToDatePicker(String firstField, String secondField, String thirdField) {

    List<WebElement> date =
        ((AndroidDriver<WebElement>) browser.getWebDriver()).findElements(By
            .className("android.widget.NumberPicker"));
    date.get(0).click();
    if (!date.get(0).isDisplayed()) {
      ((AndroidDriver<?>) browser.getWebDriver()).findElement(By.id("net.bloomz:id/txtfromdate"))
          .click();
    }
    date.get(0).sendKeys(firstField);
    date.get(1).sendKeys(secondField);
    date.get(2).sendKeys(thirdField);
  }

  public String getElementSize(By locator) {
    int elementSize = ((AndroidDriver<?>) browser.getWebDriver()).findElements(locator).size();
    if (elementSize != 0) {
      return String.valueOf(elementSize);
    }
    return "Element is not present";
  }

  public BasePage clearTextBox(By locator) {
    ((AndroidDriver<?>) browser.getWebDriver()).findElement(locator).clear();
    return this;
  }

  public String getPlatformName() {
    String string = browser.toString();
    System.out.println(string);
    if (string.contains("Android")) {
      System.out.println("Driver Instance : "
          + browser.getDesiredCapabilities().getCapability("platformName").toString());
      return browser.getDesiredCapabilities().getCapability("platformName").toString();

    }
    return "";
  }
}
