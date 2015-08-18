package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.SignPageActions;


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

  public SignInPage(Browser<?> browser) {
    super(browser);
    if (getPlatformName().equals("Android")) {
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


    } else if (getPlatformName().equals("ios")) {

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



  @Override
  public SignInPage enterEmailIdOnTextBox(String emailId) {
    if (getPlatformName().equals("Android")) {
      setEnviroment();
    }
    sendText(emailEditTextLocator, emailId);
    return this;
  }



  @Override
  public SignInPage enterPasswordOnTextBox(String password) {
    sendText(passwordEditTextLocator, password);
    return this;
  }

  @Override
  public HomePage clickOnSignInButton() {
    click(signInButtonLocator);
    return new HomePage(browser);
  }



  @Override
  public SignInPage setEnviroment() {
    if (browser.getActions().getElements(settingButtonLocator).size() != 0) {
      click(settingButtonLocator);
      sendText(editNewUrlEditTextLocator, "http://app-test01.bloomz.net:8000");
      click(saveButtonLocator);
    }
    return this;
  }



}
