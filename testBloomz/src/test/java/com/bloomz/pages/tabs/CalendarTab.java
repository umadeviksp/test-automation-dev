package com.bloomz.pages.tabs;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.BasePage;

public class CalendarTab extends BasePage {
  By textEventLocator = By.id("net.bloomz:id/txtEventCalender");
  By calendarListViewLocator = By.id("net.bloomz:id/CalendarListView");
  By dateTextViewLocator = By.id("net.bloomz:id/txtTitle");

  /**
   * Instantiates a new calendar tab.
   *
   * @param appiumDriver the appium driver
   */
  public CalendarTab(AppiumDriver appiumDriver) {
    super(appiumDriver);
    waitForElement(calendarListViewLocator);
    Assert.assertTrue(getText(textEventLocator).trim().equals("Calendar"),
        "Current tab is not calendar tab");
  }

  /**
   * Gets the event date.
   *
   * @return the event date
   */
  public String getEventDate() {
    return getText(dateTextViewLocator);
  }

  /**
   * Swipe up and get event date.
   *
   * @return the string
   */
  public String swipeUpAndGetEventDate() {
    swipeUp("net.bloomz:id/CalendarListView", 5, 5, 1000);
    return getEventDate();

  }

}
