package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.LandingPageActions;



public class LandingPage extends BasePage implements LandingPageActions<LandingPage> {


  By signInButtonLocator = null;
  By createAccountButtonLocator = null;

  public LandingPage(Browser<?> browser) {
    super(browser);
    if (getPlatformName().equals("Android")) {
      signInButtonLocator = By.id("net.bloomz:id/SignIn");
      createAccountButtonLocator = By.id("net.bloomz:id/IAmNew");
    } else if (getPlatformName().equals("ios")) {
      signInButtonLocator = By.id("");
      createAccountButtonLocator = By.id("");
    } else {
      signInButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('login');\"]");
      createAccountButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('roleChooser')\"]");
    }
  }


  @Override
  public SignInPage clickOnSignInButton() {
    System.out.println(signInButtonLocator.toString());
    click(signInButtonLocator);
    return new SignInPage(browser);
  }

  @Override
  public LandingPage clickOnCreateAccountORIAmNew() {
    click(createAccountButtonLocator);
    return new LandingPage(browser);
  }



}
