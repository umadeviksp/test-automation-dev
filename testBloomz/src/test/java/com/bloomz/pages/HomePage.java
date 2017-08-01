package com.bloomz.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.settings.UserProfileFlyOutMenu;
import com.bloomz.pages.tabs.CalendarTab;
import com.bloomz.pages.tabs.ContactsTab;
import com.bloomz.pages.tabs.MessageTab;
import com.bloomz.pages.tabs.VolunteerAsksTab;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePage.
 */
public class HomePage extends BasePage {

  By homeListViewLocator = By.id("net.bloomz:id/HomeListView");
  By textEventLocator = By.id("net.bloomz:id/txtEventCalender");
  By menuButtonLocator = By.id("net.bloomz:id/menuBtn");
  By postTextLocator = By.id("net.bloomz:id/txtAlbumPhotoComment");
  By homeLauncherIconLocator = By.name("Apps");
  By bloomzAppLocator = By.name("Bloomz");
  By homeTab = By.name("home");
  By calendarTab = By.name("calender");
  By messageTab = By.name("message");
  By volunteerTab = By.name("volunteer");
  By contactsTab = By.name("contacts");
  By postCommentLocator = By.id("net.bloomz:id/txtAlbumPhotoPostBy");

  /**
   * Instantiates a new home page.
   *
   * @param appiumDriver the appium driver
   */
  public HomePage(AppiumDriver appiumDriver) {
    super(appiumDriver);
    waitForElement(homeListViewLocator);
    Assert.assertTrue(
        getText(textEventLocator).contains("Announcements")
            || getText(textEventLocator).trim().equals("Updates")
            || getText(textEventLocator).trim().equals("Upcoming Events"),
        "Current page is not home tab");
  }

  /**
   * Navigate to home tab.
   *
   * @return the home page
   */
  public HomePage navigateToHomeTab() {
    click(homeTab);
    return this;
  }

  /**
   * Navigate to calendar tab.
   *
   * @return the home page
   */
  public CalendarTab navigateToCalendarTab() {
    click(calendarTab);
    return new CalendarTab(appiumDriver);
  }

  /**
   * Navigate to mesaage tab.
   *
   * @return the home page
   */
  public MessageTab navigateToMesaageTab() {
    click(messageTab);
    return new MessageTab(appiumDriver);
  }

  /**
   * Navigate to volunteer tab.
   *
   * @return the home page
   */
  public VolunteerAsksTab navigateToVolunteerTab() {
    click(volunteerTab);
    return new VolunteerAsksTab(appiumDriver);
  }

  /**
   * Navigate to contacts tab.
   *
   * @return the home page
   */
  public ContactsTab navigateToContactsTab() {
    click(contactsTab);
    return new ContactsTab(appiumDriver);
  }

  /**
   * Swipe down and get user post comment.
   *
   * @return the string
   */
  public String swipeUpAndGetUserPostComment() {
    swipeUp("net.bloomz:id/HomeListView", 5, 5, 2000);
    return getUserPostComment();

  }

  /**
   * Go to fly out menu.
   *
   * @return the user profile fly out menu
   */
  public UserProfileFlyOutMenu goToFlyOutMenu() {
    waitForElement(menuButtonLocator);
    click(menuButtonLocator);
    return new UserProfileFlyOutMenu(appiumDriver);

  }

  /**
   * Gets the user post.
   *
   * @return the user post
   */
  public String getUserPost() {
    waitForElement(postTextLocator);
    // System.out.println(getText(postTextLocator));
    return getText(postTextLocator);
  }

  /**
   * Gets the post comment.
   *
   * @return the post comment
   */
  public String getUserPostComment() {
    waitForElement(postCommentLocator);
    return getText(postCommentLocator);
  }

  /**
   * Put app in background and relaunch it.
   */
  public void putAppInBackgroundAndRelaunchIt() {
    ((AndroidDriver) appiumDriver).sendKeyEvent(AndroidKeyCode.HOME);
    click(By.name("Apps"));
    waitForElement(By.name("Calculator"));
    click(By.name("Calculator"));
    ((AndroidDriver) appiumDriver).sendKeyEvent(AndroidKeyCode.HOME);
    click(By.name("Apps"));
    waitForElement(By.name("Bloomz"));
    click(By.name("Bloomz"));
  }

}
