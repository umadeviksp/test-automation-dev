package com.bloomz.pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ClassPage extends BasePage {

  By classTitleLocator = By.id("net.bloomz:id/txtHeading");
  By feedTabLocator = By.name("In Group - Feed");
  By calendarTabLocator = By.name("In Group - Calendar");
  By photosTabLocator = By.name("In Group - Photos");
  By volunteerTabLocator = By.name("In Group - Volunteer");
  By infoTabLocator = By.name("In Group - Info");
  By membersTabLocator = By.name("In Group - Members");
  By subTitleLocator = By.id("net.bloomz:id/txtEventCalender");
  By textEventLocator = By.id("net.bloomz:id/txtEventCalender");
  String tabLocator = "net.bloomz:id/tabs";

  public ClassPage(AppiumDriver appiumDriver) {
    super(appiumDriver);
    waitForElement(classTitleLocator);
    Assert.assertTrue(
        getText(textEventLocator).contains("Announcements")
            || getText(textEventLocator).trim().equals("Updates")
            || getText(textEventLocator).trim().equals("Upcoming Events"),
        "Current page is not home tab");
  }

  public ClassPage naviagteToFeedTab() {
    swipeRight(tabLocator, 1, 1000);
    click(feedTabLocator);
    return this;

  }

  public ClassPage naviagteToCalnedarTab() {
    waitForElement(calendarTabLocator);
    click(calendarTabLocator);
    Assert.assertTrue(getText(textEventLocator).trim().equals("Calendar"),
        "Current tab is not calendar tab");
    return this;
  }

  public ClassPage naviagteToPhotosTab() {
    waitForElement(photosTabLocator);
    click(photosTabLocator);
    Assert.assertTrue(waitForElement(By.id("net.bloomz:id/PhotoListView")).isDisplayed(),
        "Current tab is not Photos tab");
    return this;
  }

  public ClassPage naviagteToVolunteerTab() {
    waitForElement(volunteerTabLocator);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    click(volunteerTabLocator);
    Assert.assertTrue(getText(textEventLocator).trim().equals("Volunteer Asks"),
        "Current tab is not  volunteer asks tab");
    return this;
  }

  public ClassPage naviagteToInfoTab() {
    waitForElement(infoTabLocator);
    click(infoTabLocator);
    Assert.assertTrue(waitForElement(By.id("net.bloomz:id/InfoListView")).isDisplayed(),
        "Current tab is not Info tab");
    return this;
  }

  public ClassPage naviagteToMembersTab() {
    waitForElement(membersTabLocator);
    click(membersTabLocator);
    Assert.assertTrue(getText(subTitleLocator).trim().equals("Members"),
        "Current tab is not Members tab");
    return this;

  }
}
