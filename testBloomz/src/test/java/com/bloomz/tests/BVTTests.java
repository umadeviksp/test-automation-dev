package com.bloomz.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bloomz.pages.HomePage;
import com.bloomz.pages.LandingPage;
import com.bloomz.pages.SignInPage;
import com.bloomz.pages.settings.AccountSettings;
import com.bloomz.pages.settings.UserProfileFlyOutMenu;
import com.bloomz.pages.tabs.CalendarTab;
import com.bloomz.utils.Log;

public class BVTTests extends BaseTest {

  /**
   * Test app installation whether APK installed or not.
   */
  @Test
  public void testAppInstallation() {
    Log.startTestCase("testAppInstallation");
    Assert.assertTrue(appiumDriver.isAppInstalled(appPackage), "App is not Installed");
    Log.endTestCase("testAppInstallation");

  }

  /**
   * Launch the app and verify the user onboarding screen
   */
  @Test
  public void testAppLauch() {
    Log.startTestCase("testAppLauch");
    LandingPage landingPage = new LandingPage(appiumDriver);
    Assert.assertTrue(landingPage.getText(By.id("net.bloomz:id/SignIn")).equals("Sign In")
        && landingPage.getText(By.id("net.bloomz:id/IAmNew")).equals("I'm New"),
        "Sign In and I'm New buttons are not present");
    Log.endTestCase("testAppLauch");

  }

  /**
   * Sign in with valid emailId and password and verify user able to see the home tab.
   */
  @Test
  public void testSignInWithValidInputs() {
    Log.startTestCase("testSignInWithValidInputs");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    UserProfileFlyOutMenu userProfileFlyOutMenu = homePage.goToFlyOutMenu();
    AccountSettings accountSettings = userProfileFlyOutMenu.goToAccountSettings();
    accountSettings.logoutAccount();
    Log.endTestCase("testSignInWithValidInputs");
  }

  /**
   * Sign up as a teacher and create own class room then verify feed on home screen
   *
   * @throws Exception the exception
   */
  @Test
  public void testSignUpForTeacher() throws Exception {
    Log.startTestCase("testSignUpForTeacher");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage
        .setEnviroment(stagingUrl)
        .goBackToOnBoardingPage()
        .goToImNewPage()
        .goToTeacherOnBoarding()
        .onBoardUser(userType1, generateRandomString(10), generateRandomString(10),
            "automation_" + getCurrentTimeStamp() + "@test.com", passwordForUserOnBoard, zipCode)
        .userOnBoardFlow(userType1).goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testSignUpForTeacher");

  }

  /**
   * Sign up as a room parent and create own class room then verify feed on home screen
   *
   * @throws Exception the exception
   */
  @Test
  public void testSignUpForRoomParent() throws Exception {
    Log.startTestCase("testSignUpForRoomParent");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage
        .setEnviroment(stagingUrl)
        .goBackToOnBoardingPage()
        .goToImNewPage()
        .goToRoomParentOnBoarding()
        .onBoardUser(userType2, generateRandomString(10), generateRandomString(10),
            "automation_" + getCurrentTimeStamp() + "@test.com", passwordForUserOnBoard, zipCode)
        .userOnBoardFlow(userType2).goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testSignUpForRoomParent");


  }

  /**
   * Verify the posts of existing teacher account
   */
  @Test
  public void testExistingAccountWithHomeTab() {
    Log.startTestCase("testExistingAccountWithHomeTab");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    String postComments = homePage.getUserPost();
    UserProfileFlyOutMenu userProfileFlyOutMenu = homePage.goToFlyOutMenu();
    String userProfileName = userProfileFlyOutMenu.getUserProfileName();
    Assert.assertTrue(postComments.contains(userProfileName), "Home page doesn't have single post");
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountWithHomeTab");


  }

  /**
   * Verify the calendar events of existing teacher account
   * 
   */
  @Test
  public void testExistingAccountWithCalendarEventsTab() {
    Log.startTestCase("testExistingAccountWithCalendarEventsTab");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    homePage.navigateToCalendarTab();
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountWithCalendarEventsTab");


  }

  /**
   * Verify the messages of existing teacher account
   * 
   */
  @Test
  public void testExistingAccountWithMessageTab() {
    Log.startTestCase("testExistingAccountWithMessageTab");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    homePage.navigateToMesaageTab();
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountWithMessageTab");


  }

  /**
   * Verify the volunteer of existing teacher account
   * 
   */
  @Test
  public void testExistingAccountWithVolunteerTab() {
    Log.startTestCase("testExistingAccountWithVolunteerTab");

    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    homePage.navigateToVolunteerTab();
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountWithVolunteerTab");


  }

  /**
   * Verify the contacts of existing teacher account
   * 
   */
  @Test
  public void testExistingAccountWithContactsTab() {
    Log.startTestCase("testExistingAccountWithContactsTab");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    homePage.navigateToContactsTab();
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountWithContactsTab");


  }

  /**
   * Test the App backgrounded and foregrounded.
   */
  @Test
  public void testAppBackgroundedAndForegrounded() {
    Log.startTestCase("testAppBackgroundedAndForegrounded");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    homePage.putAppInBackgroundAndRelaunchIt();
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testAppBackgroundedAndForegrounded");


  }

  /**
   * Test existing account posts by scrolling.
   */
  @Test
  public void testExistingAccountPostsByScrolling() {
    Log.startTestCase("testExistingAccountPostsByScrolling");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    String postBeforeScroll = homePage.getUserPostComment();
    String postAfterScroll = homePage.swipeUpAndGetUserPostComment();
    Assert.assertFalse(postBeforeScroll.equals(postAfterScroll),
        "Not able to scroll the posts on home page");
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountPostsByScrolling");


  }

  /**
   * Test existing account calender events by scrolling.
   */
  @Test
  public void testExistingAccountCalenderEventsByScrolling() {
    Log.startTestCase("testExistingAccountCalenderEventsByScrolling");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    CalendarTab calendarTab = homePage.navigateToCalendarTab();
    String eventDateBeforeScroll = calendarTab.getEventDate();
    System.out.println(eventDateBeforeScroll);
    String eventDateAfterScroll = calendarTab.swipeUpAndGetEventDate();
    System.out.println(eventDateAfterScroll);
    Assert.assertFalse(eventDateBeforeScroll.equals(eventDateAfterScroll),
        "Not able to scroll the posts on home page");
    homePage.goToFlyOutMenu().goToAccountSettings().logoutAccount();
    Log.endTestCase("testExistingAccountCalenderEventsByScrolling");


  }

  /**
   * Test launch class from fly out menu.
   */
  @Test
  public void testLaunchClassFromFlyOutMenu() {
    Log.startTestCase("testLaunchClassFromFlyOutMenu");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    UserProfileFlyOutMenu flyOutMenu = homePage.goToFlyOutMenu();
    flyOutMenu.navigateToClassRoom();
    flyOutMenu.clickBack();
    flyOutMenu.goToAccountSettings().logoutAccount();
    Log.endTestCase("testLaunchClassFromFlyOutMenu");


  }

  /**
   * Test switch tab in class screen.
   */
  @Test
  public void testSwitchTabInClassScreen() {
    Log.startTestCase("testSwitchTabInClassScreen");
    LandingPage landingPage = new LandingPage(appiumDriver);
    SignInPage signInPage = landingPage.goToSignInPage();
    signInPage.setEnviroment(stagingUrl);
    HomePage homePage = signInPage.loginWtihValidCredential(emailId, password);
    UserProfileFlyOutMenu flyOutMenu = homePage.goToFlyOutMenu();
    flyOutMenu.navigateToClassRoom().naviagteToCalnedarTab().naviagteToPhotosTab()
        .naviagteToVolunteerTab().naviagteToInfoTab().naviagteToMembersTab().naviagteToFeedTab();
    String getUserPostComment = homePage.swipeUpAndGetUserPostComment();
    System.out.println(getUserPostComment);
    Assert.assertTrue(getUserPostComment != null && !getUserPostComment.isEmpty(),
        "No post is available");
    flyOutMenu.clickBack();
    flyOutMenu.goToAccountSettings().logoutAccount();
    Log.endTestCase("testSwitchTabInClassScreen");


  }

}
