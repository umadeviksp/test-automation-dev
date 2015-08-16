package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.net.bloomz.pages.interfaces.HomePageActions;
import com.net.bloomz.tests.BaseTest;


public class HomePage extends BasePage implements HomePageActions<HomePage> {

  WebDriver driver;

  By bloomzIconLocator = null;
  By settingButtonLocator = null;

  // By homeListViewLocator = By.id("net.bloomz:id/HomeListView");
  // By textEventLocator = By.id("net.bloomz:id/txtEventCalender");
  // By menuButtonLocator = By.id("net.bloomz:id/menuBtn");
  // By postTextLocator = By.id("net.bloomz:id/txtAlbumPhotoComment");
  // By homeLauncherIconLocator = By.name("Apps");
  // By bloomzAppLocator = By.name("Bloomz");
  // By homeTab = By.name("home");
  // By calendarTab = By.name("calender");
  // By messageTab = By.name("message");
  // By volunteerTab = By.name("volunteer");
  // By contactsTab = By.name("contacts");
  // By postCommentLocator = By.id("net.bloomz:id/txtAlbumPhotoPostBy");
  // By postMessageLocator = By.id("net.bloomz:id/txtPostMessage");
  // By eventNameLocator = By.id("net.bloomz:id/txtCalName");
  // By profileNameLocator = By.id("net.bloomz:id/txtProfileName");
  // By postTitleLocator = By.id("net.bloomz:id/txtPostTitle");

  public HomePage() {
    if (BaseTest.getPlatform().equals("Android")) {
      bloomzIconLocator = By.id("net.bloomz:id/menuBtn");
      settingButtonLocator = By.id("net.bloomz:id/txtSetting");
    } else if (BaseTest.getPlatform().equals("iOS")) {
      bloomzIconLocator = By.id("");
      settingButtonLocator = By.id("");
    } else {
      settingButtonLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftAccount\"]");
    }
  }


  @Override
  public HomePage clickOnBloomzIconForMobileApp() {

    if (BaseTest.getPlatform().equals("Android") || BaseTest.getPlatform().equals("iOS")) {
      waitForElement(bloomzIconLocator);
      click(bloomzIconLocator);
      return PageFactory.initElements(driver, HomePage.class);
    }
    return null;
  }


  @Override
  public HomePage clickOnSettingButton() {
    clickOnBloomzIconForMobileApp();
    waitForElement(settingButtonLocator);
    click(settingButtonLocator);
    return PageFactory.initElements(driver, HomePage.class);
  }



}
