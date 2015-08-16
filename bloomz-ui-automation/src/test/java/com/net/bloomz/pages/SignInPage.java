package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.net.bloomz.pages.interfaces.SignPageActions;
import com.net.bloomz.tests.BaseTest;


public class SignInPage extends BasePage implements SignPageActions<SignInPage> {

  By backArrowButtonLocator = null;
  By settingButtonLocator = null;
  By emailEditTextLocator = null;
  By passwordEditTextLocator = null;
  By signInButtonLocator = null;
  By forgotPasswordLinkLocator = null;
  By needHelpLinkLocator = null;
  By resetButtonLocator = null;
  By forgotPasswordBackButtonLocator = null;
  By editNewUrlEditTextLocator = null;
  By saveButtonLocator = null;
  By pageTitleLocator = null;

  public SignInPage() {
    if (BaseTest.getPlatform().equals("Android")) {
      backArrowButtonLocator = By.id("net.bloomz:id/llback");
      settingButtonLocator = By.id("net.bloomz:id/settingsBtn");
      emailEditTextLocator = By.id("net.bloomz:id/editEmail");
      passwordEditTextLocator = By.id("net.bloomz:id/editPassword");
      signInButtonLocator = By.id("net.bloomz:id/btnSignIn");
      forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
      needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
      resetButtonLocator = By.id("net.bloomz:id/btnReset");
      forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
      editNewUrlEditTextLocator = By.id("net.bloomz:id/editNewURL");
      saveButtonLocator = By.id("net.bloomz:id/SaveBtn");
      pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");


    } else if (BaseTest.getPlatform().equals("ios")) {

      backArrowButtonLocator = By.id("net.bloomz:id/llback");
      settingButtonLocator = By.id("net.bloomz:id/settingsBtn");
      emailEditTextLocator = By.id("net.bloomz:id/editEmail");
      passwordEditTextLocator = By.id("net.bloomz:id/editPassword");
      signInButtonLocator = By.id("net.bloomz:id/btnSignIn");
      forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
      needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
      resetButtonLocator = By.id("net.bloomz:id/btnReset");
      forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
      editNewUrlEditTextLocator = By.id("net.bloomz:id/editNewURL");
      saveButtonLocator = By.id("net.bloomz:id/SaveBtn");
      pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");
    } else {
      backArrowButtonLocator = By.id("net.bloomz:id/llback");
      settingButtonLocator = By.id("net.bloomz:id/settingsBtn");
      emailEditTextLocator = By.xpath("//*[@id=\"loginForm_username\"]");
      passwordEditTextLocator = By.xpath("//*[@id=\"loginForm_password\"]");
      signInButtonLocator = By.xpath("//*[@id=\"login_signin\"]");
      forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
      needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
      resetButtonLocator = By.id("net.bloomz:id/btnReset");
      forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
      editNewUrlEditTextLocator = By.id("net.bloomz:id/editNewURL");
      saveButtonLocator = By.id("net.bloomz:id/SaveBtn");
      pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");
    }

  }



  private WebDriver driver;



  @Override
  public SignInPage enterEmailIdOnTextBox(String emailId) {
    setEnviroment();
    sendText(emailEditTextLocator, emailId);
    return PageFactory.initElements(driver, SignInPage.class);
  }



  @Override
  public SignInPage enterPasswordOnTextBox(String password) {
    sendText(passwordEditTextLocator, password);
    return PageFactory.initElements(driver, SignInPage.class);
  }

  @Override
  public SignInPage clickOnSignInButton() {
    click(signInButtonLocator);
    return PageFactory.initElements(driver, SignInPage.class);
  }



  @Override
  public SignInPage setEnviroment() {
    if (getActions().getBrowser().getWebDriver().findElements(settingButtonLocator).size() != 0) {
      click(settingButtonLocator);
      sendText(editNewUrlEditTextLocator, "http://app-test01.bloomz.net:8000");
      click(saveButtonLocator);
    }
    return PageFactory.initElements(driver, SignInPage.class);
  }



}
