package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;

public class BV_TestCases extends BaseTest {

	@Test(groups = { "android", "BVT01" })
	public void BVT01_testAppInstallation() {
		Assert.assertTrue(((AndroidDriver<?>) browser.getWebDriver()).isAppInstalled("net.bloomz"),
				"App is not Installed");
	}

	@Test(groups = { "android", "ios", "BVT02" })
	public void BVT02_testAppLauch() {
		LandingPage.getLandingPage(browser).thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}

	@Test(groups = { "android", "ios", "web", "BVT03" })
	public void BVT03_testSignInWithValidInputs() throws Exception {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.clickOnSettingButton().clickOnSignOutButton().clickOnPopUpSignOutButton();

	}

	@Test(groups = { "android", "ios", "web", "BVT04" })
	public void BVT04_testSignUpAsATeacher() throws Exception {

		LandingPage.getLandingPage(browser).clickOnCreateAccountOrIAmNewButton().clickOnTeacherIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton().clickOnPopUpSignOutButton();

	}

	@Test(groups = { "android", "ios", "web", "BVT05" })
	public void BVT05_testSignUpAsARoomParent() {

		LandingPage.getLandingPage(browser).clickOnCreateAccountOrIAmNewButton().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton().clickOnPopUpSignOutButton();
	}

	@Test(groups = { "android", "ios", "web", "BVT06" })
	public void BVT06_testPostsOnMainFeedForExistingAccount() {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.thenVerifyMainFeedPostShouldNotBeNull().clickOnSettingButton().clickOnSignOutButton()
				.clickOnPopUpSignOutButton();
	}

	@Test(groups = { "android", "ios", "web", "BVT07" })
	public void BVT07_testCalenderEventsOnMainFeedForExistingAccount() {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyCalendarTab()
				.thenVerifyCalenderEventsShouldNotBeNull();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton().clickOnPopUpSignOutButton();
	}

	public void BVT08_testMessagesOnMainFeedForExistingAccount() {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton();

	}

	@Test(groups = { "android", "ios", "web", "BVT09" })
	public void BVT09_testVolunteersOnMainFeedForExistingAccount() {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnVolunteersTab()
				.thenVerifyAddVolunteerButtonShouldBeDisplayed();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton().clickOnPopUpSignOutButton();

	}

}
