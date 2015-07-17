package com.bloomz.pages.settings;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.SignInPage;

public class AccountSettings extends UserProfileFlyOutMenu {

  By pageTitleLocator = By.id("net.bloomz:id/txtHeading");
  By changePasswordLocator = By.id("net.bloomz:id/txtChangePassword");
  By changeEmailLocator = By.id("net.bloomz:id/txtChangePassword");
  By firstSignOutButtonLocator = By.id("net.bloomz:id/txtSignOut");
  By secoundSigOutButtonLocator = By.id("net.bloomz:id/SignOutBtn");
  By cancelButtonLocator = By.id("net.bloomz:id/CancelSignOutBtn");
  By backButtonLocator = By.id("net.bloomz:id/llback");

  public AccountSettings(AppiumDriver appiumDriver) {
    super(appiumDriver);
    waitForElement(pageTitleLocator);
    Assert.assertTrue(getText(pageTitleLocator).equals("Account Settings"),
        "Current page is not Account Settings page");
  }

  public SignInPage logoutAccount() {
    click(firstSignOutButtonLocator);
    click(secoundSigOutButtonLocator);
    return new SignInPage(appiumDriver);

  }
}
