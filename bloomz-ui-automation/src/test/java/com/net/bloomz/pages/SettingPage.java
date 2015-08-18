package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.SettingPageActions;


public class SettingPage extends BasePage implements SettingPageActions<SettingPage> {


  By signOutButtonLocator = null;
  By popUpSignOutButtonLocator = null;


  public SettingPage(Browser<?> browser) {
    super(browser);
    if (getPlatformName().equals("Android")) {
      signOutButtonLocator = By.id("net.bloomz:id/txtSignOut");
      popUpSignOutButtonLocator = By.id("net.bloomz:id/SignOutBtn");
    } else if (getPlatformName().equals("iOS")) {

    } else {
      signOutButtonLocator = By.xpath("//*[@ng-click=\"logout()\"]");
      popUpSignOutButtonLocator = By.xpath("//*[contains(text(), \"Sign Out\")]");
    }
  }

  @Override
  public SettingPage clickOnSignOutButton() {
    click(signOutButtonLocator);
    return this;
  }

  @Override
  public SettingPage clickOnPopUpSignOutButton() {
    click(popUpSignOutButtonLocator);
    return this;
  }
}
