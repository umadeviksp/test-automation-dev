package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.net.bloomz.pages.interfaces.LandingPageActions;
import com.net.bloomz.tests.BaseTest;



public class LandingPage extends BasePage implements LandingPageActions<LandingPage> {
  private WebDriver driver;

  By signInButtonLocator = null;
  By createAccountButtonLocator = null;

  public LandingPage() {
    if (BaseTest.getPlatform().equals("Android")) {
      signInButtonLocator = By.id("net.bloomz:id/SignIn");
      createAccountButtonLocator = By.id("net.bloomz:id/IAmNew");
    } else if (BaseTest.getPlatform().equals("ios")) {
      signInButtonLocator = By.id("");
      createAccountButtonLocator = By.id("");
    } else {
      signInButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('login');\"]");
      createAccountButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('roleChooser')\"]");
    }
  }


  @Override
  public LandingPage clickOnSignInButton() {
    System.out.println(signInButtonLocator.toString());
    click(signInButtonLocator);
    return PageFactory.initElements(driver, LandingPage.class);
  }

  @Override
  public LandingPage clickOnCreateAccountORIAmNew() {
    click(createAccountButtonLocator);
    return PageFactory.initElements(driver, LandingPage.class);
  }



}
