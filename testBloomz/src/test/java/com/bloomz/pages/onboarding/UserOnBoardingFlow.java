package com.bloomz.pages.onboarding;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.HomePage;

public class UserOnBoardingFlow extends UserOnBoardingPage {

  By pageTitleLocator = By.id("net.bloomz:id/textView2");
  By videoLocator = By.id("net.bloomz:id/welcomeVideoPhoto");
  By createClassButtonLocator = By.id("net.bloomz:id/createClassBtn");
  By titleBarLocator = By.id("android:id/action_bar_title");
  By classNameEditTextLocator = By.id("net.bloomz:id/txtTitleNameValue");
  By schoolLocator = By.id("net.bloomz:id/relativeLayout1");
  By schoolTitleLocator = By.id("net.bloomz:id/Title");
  By createButtonLocator = By.name("Create");
  By addPhotoTitleLocator = By.id("net.bloomz:id/txtTitle"); // Add a Photo
  By skipAddImageLocator = By.id("net.bloomz:id/txtSkip");
  By feedLocator = By.name("Feed");
  By classTitleLocator = By.id("net.bloomz:id/txtHeading");
  By childNameEditTextLocator = By.id("net.bloomz:id/childName");

  public UserOnBoardingFlow(AppiumDriver appiumDriver) {
    super(appiumDriver);
    waitForElement(pageTitleLocator);

  }

  /**
   * User on board flow.
   *
   * @param className the class name
   * @return the home page
   */
  public HomePage userOnBoardFlow(String className) {
    Assert.assertTrue(getText(pageTitleLocator).equals("Watch How Bloomz Works"),
        "Current page is not Watch How Bloomz Works");
    Assert.assertTrue(getText(createClassButtonLocator).equals("Create Your Own Class"),
        "Current page is not Watch How Bloomz Works");
    waitForElement(videoLocator);
    Assert.assertTrue(waitForElement(videoLocator).isDisplayed() == true, "Video is not avaliable");

    click(createClassButtonLocator);
    Assert
        .assertTrue(getText(titleBarLocator).equals("New Class"), "Current page is not New Class");
    sendText(classNameEditTextLocator, className);
    if (appiumDriver.findElements(schoolLocator).size() < 1) {
      clickBack();
    }

    click(schoolLocator);
    click(schoolTitleLocator);
    if (className.equals("Room Parent")) {
      if (appiumDriver.findElements(childNameEditTextLocator).size() < 1) {
        swipeUp("android:id/content", 3, 3, 1000);
      }
      sendText(childNameEditTextLocator, className.substring(0, 4));
    }
    click(createButtonLocator);
    Assert.assertTrue(getText(addPhotoTitleLocator).equals("Add a Photo"),
        "Current page is not Add a Photo");
    waitForElement(skipAddImageLocator);
    click(skipAddImageLocator);
    Assert.assertTrue(getText(feedLocator).equals("Feed"), "Current page is not contain Feed");
    clickBack();
    return new HomePage(appiumDriver);

  }

}
