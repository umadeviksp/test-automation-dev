package com.bloomz.pages.tabs;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.BasePage;

public class VolunteerAsksTab extends BasePage {
  By textEventLocator = By.id("net.bloomz:id/txtEventCalender");

  public VolunteerAsksTab(AppiumDriver appiumDriver) {
    super(appiumDriver);
    Assert.assertTrue(getText(textEventLocator).trim().equals("Volunteer Asks"),
        "Current tab is not  volunteer asks tab");
  }

}
