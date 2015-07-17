package com.bloomz.pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

public class SignInPage extends BasePage {

  By backArrowButtonLocator = By.id("net.bloomz:id/llback");
  By settingButtonLocator = By.id("net.bloomz:id/settingsBtn");
  By emailEditTextLocator = By.id("net.bloomz:id/editEmail");
  By passwordEditTextLocator = By.id("net.bloomz:id/editPassword");
  By signInButtonLocator = By.id("net.bloomz:id/btnSignIn");
  By forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
  By needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
  By resetButtonLocator = By.id("net.bloomz:id/btnReset");
  By forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
  By editNewUrlEditTextLocator = By.id("net.bloomz:id/editNewURL");
  By saveButtonLocator = By.id("net.bloomz:id/SaveBtn");
  By pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");

  public SignInPage(AppiumDriver appiumDriver) {
    super(appiumDriver);
    waitForElement(pageTitleLocator);
    Assert.assertTrue(getText(pageTitleLocator).equals("Sign In"),
        "Current page is not sign in page");

  }

  public LandingPage goBackToOnBoardingPage() {
    click(backArrowButtonLocator);
    return new LandingPage(appiumDriver);

  }

  /**
   * Login wtih valid credential.
   *
   * @param emailId the email id
   * @param password the password
   */
  public HomePage loginWtihValidCredential(String emailId, String password) {

    sendText(emailEditTextLocator, emailId);
    sendText(passwordEditTextLocator, password);
    click(signInButtonLocator);
    return new HomePage(appiumDriver);
  }

  public SignInPage setEnviroment(String endPoints) {

    if (appiumDriver.findElements(settingButtonLocator).size() > 1) {

      click(settingButtonLocator);
      sendText(editNewUrlEditTextLocator, endPoints);
      click(saveButtonLocator);
    }
    return this;
  }
}
