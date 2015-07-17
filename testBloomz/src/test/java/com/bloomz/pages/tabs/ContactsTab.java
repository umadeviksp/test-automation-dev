package com.bloomz.pages.tabs;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.BasePage;

public class ContactsTab extends BasePage {
  By contactListViewLocator = By.id("net.bloomz:id/MyContactsListView");

  public ContactsTab(AppiumDriver appiumDriver) {
    super(appiumDriver);
    Assert.assertTrue(waitForElement(contactListViewLocator).isDisplayed() == true,
        "Current tab is not messages tab");
  }

}
