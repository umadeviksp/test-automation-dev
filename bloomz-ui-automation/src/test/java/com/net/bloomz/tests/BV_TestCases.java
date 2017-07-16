package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;

public class BV_TestCases extends BaseTest {

	@Test(groups = { "android", "BVT0101" })
	public void testAppInstallation() {
		Assert.assertTrue(((AndroidDriver<?>) browser.getWebDriver()).isAppInstalled("net.bloomz"),
				"App is not Installed");
	}

	@Test(groups = { "android", "ios", "BVT0201" })
	public void testAppLauch() {
		LandingPage.getLandingPage(browser).thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}

/*	@Test(groups = { "android", "ios", "web", "BVT0301" })
	public void testSignInWithValidInputs() throws Exception {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.clickOnSettingButton().clickOnSignOutButton();

	}*/
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0401" })
	public void testSignUpAsATeacher() throws Exception {

		/*LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();*/

	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0402" })
	public void testSignUpAsATeacherFRE() throws Exception {

		/*LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();*/
	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0403" })
	public void testSignUpAsTeacherWithInvitationCode() throws Exception {

		/*LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();*/
	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0404" })
	public void testSignUpAsARoomParent() throws Exception {

		/*LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();*/
	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0405" })
	public void testSignUpAsARoomParentFRE() throws Exception {

		/*LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();*/
	}

	@Test(groups = { "android", "ios", "web", "BVT0501" })
	public void testPostsOnMainFeedForExistingAccount() throws Exception {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.thenVerifyMainFeedPostShouldNotBeNull().clickOnSettingButton().clickOnSignOutButton();
	}

	@Test(groups = { "android", "ios", "web", "BVT0502" })
	public void testCalendarEventsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyCalendarTab()
				.thenVerifyCalendarEventsShouldNotBeNull();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton();
	}
	
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testMessagesOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton();

	}

}