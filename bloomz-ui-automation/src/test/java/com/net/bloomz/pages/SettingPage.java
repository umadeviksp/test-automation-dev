package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.net.bloomz.pages.interfaces.SettingPageActions;
import com.net.bloomz.tests.BaseTest;


public class SettingPage extends BasePage implements SettingPageActions<SettingPage> {

  WebDriver driver;
  By signOutButtonLocator = null;
  By popUpSignOutButtonLocator = null;


  public SettingPage() {
    if (BaseTest.getPlatform().equals("Android")) {
      signOutButtonLocator = By.id("net.bloomz:id/txtSignOut");
      popUpSignOutButtonLocator = By.id("net.bloomz:id/SignOutBtn");
    } else if (BaseTest.getPlatform().equals("iOS")) {

    } else {
      signOutButtonLocator = By.xpath("//*[@ng-click=\"logout()\"]");
      popUpSignOutButtonLocator = By.xpath("//*[contains(text(), \"Sign Out\")]");
    }
  }

  @Override
  public SettingPage clickOnSignOutButton() {
    click(signOutButtonLocator);
    return PageFactory.initElements(driver, SettingPage.class);
  }

  @Override
  public SettingPage clickOnPopUpSignOutButton() {
    click(popUpSignOutButtonLocator);
    return PageFactory.initElements(driver, SettingPage.class);
  }
}
