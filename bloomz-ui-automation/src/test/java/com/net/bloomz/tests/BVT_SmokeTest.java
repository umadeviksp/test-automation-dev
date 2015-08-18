package com.net.bloomz.tests;

import org.testng.annotations.Test;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.SignInPage;

public class BVT_SmokeTest extends BaseTest {



  @Test(groups = {"android", "ios", "web", "somke", "BVT03"})
  public void BVT03_SignInWithValidInputs() throws Exception {

    
    LandingPage landingPage = new LandingPage(browser);
    landingPage.clickOnSignInButton();
    SignInPage signInPage = new SignInPage(browser);
    signInPage.enterEmailIdOnTextBox("alphateacher@test.com").enterPasswordOnTextBox("bloomz999")
        .clickOnSignInButton();
    HomePage homePage = new HomePage(browser);
    homePage.clickOnSettingButton();
    SettingPage settingPage = new SettingPage(browser);
    settingPage.clickOnSignOutButton().clickOnPopUpSignOutButton();
    
    
    // browser.loadTopLevelPage(LandingPage.class).clickOnSignInButton();
    // browser.loadTopLevelPage(SignInPage.class).enterEmailIdOnTextBox("alphateacher@test.com")
    // .enterPasswordOnTextBox("bloomz999").clickOnSignInButton();
    // browser.loadTopLevelPage(HomePage.class).clickOnSettingButton();
    // browser.loadTopLevelPage(SettingPage.class).clickOnSignOutButton().clickOnPopUpSignOutButton();



    // browser.loadTopLevelPage(SignInPage.class).enterEmailIdOnTextBox("alphateacher@test.com");
    // browser.loadTopLevelPage(SignInPage.class).enterPasswordOnTextBox("bloomz999");
    // browser.loadTopLevelPage(SignInPage.class).clickOnSignInButton();
    // browser.loadTopLevelPage(HomePage.class).clickOnSettingButton();
    // browser.loadTopLevelPage(SettingPage.class).clickOnSignOutButton();
    // browser.loadTopLevelPage(SettingPage.class).clickOnPopUpSignOutButton();

  }


  @Test(groups = {"android", "ios", "web", "somke", "BVT04"})
  public void BVT04_SignInWithValidInputs() throws Exception {
    
    LandingPage landingPage = new LandingPage(browser);
    landingPage.clickOnSignInButton();
    SignInPage signInPage = new SignInPage(browser);
    signInPage.enterEmailIdOnTextBox("alphateacher@test.com").enterPasswordOnTextBox("bloomz999")
        .clickOnSignInButton();
    HomePage homePage = new HomePage(browser);
    homePage.clickOnSettingButton();
    SettingPage settingPage = new SettingPage(browser);
    settingPage.clickOnSignOutButton().clickOnPopUpSignOutButton();

//    browser.loadTopLevelPage(LandingPage.class).clickOnSignInButton();
//    browser.loadTopLevelPage(SignInPage.class).enterEmailIdOnTextBox("alphateacher@test.com")
//        .enterPasswordOnTextBox("bloomz999").clickOnSignInButton();
//    browser.loadTopLevelPage(HomePage.class).clickOnSettingButton();
//    browser.loadTopLevelPage(SettingPage.class).clickOnSignOutButton().clickOnPopUpSignOutButton();

    // browser.loadTopLevelPage(LandingPage.class).clickOnSignInButton();
    // browser.loadTopLevelPage(SignInPage.class).enterEmailIdOnTextBox("alphateacher@test.com");
    // browser.loadTopLevelPage(SignInPage.class).enterPasswordOnTextBox("bloomz999");
    // browser.loadTopLevelPage(SignInPage.class).clickOnSignInButton();
    // browser.loadTopLevelPage(HomePage.class).clickOnSettingButton();
    // browser.loadTopLevelPage(SettingPage.class).clickOnSignOutButton();
    // browser.loadTopLevelPage(SettingPage.class).clickOnPopUpSignOutButton();

  }
}
