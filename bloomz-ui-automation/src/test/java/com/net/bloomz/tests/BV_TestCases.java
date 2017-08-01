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

	/*
	@Test(groups = { "android", "ios", "web", "BVT0301" })
	public void testSignInWithValidInputs() throws Exception {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.clickOnSettingButton().clickOnSignOutButton();

	}
	*/
	
	/*
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0401" })
	public void testSignUpAsATeacher() throws Exception {

		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();

	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0402" })
	public void testSignUpAsATeacherFRE() throws Exception {

		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();
	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0403" })
	public void testSignUpAsTeacherWithInvitationCode() throws Exception {

		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();
	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0404" })
	public void testSignUpAsARoomParent() throws Exception {

		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();
	}
	
	// NEEDS TO BE UPDATED
	@Test(groups = { "android", "ios", "web", "BVT0405" })
	public void testSignUpAsARoomParentFRE() throws Exception {

		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnRoomParentIcon()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
				.clickOnSignOutButton();
	}
	*/
	
	/*
	@Test(groups = { "android", "ios", "web", "BVT0501" })
	public void testPostsOnMainFeedForExistingAccount() throws Exception {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.thenVerifyMainFeedPostShouldNotBeNull().clickOnSettingButton().clickOnSignOutButton();
	}
	*/

	/*
	@Test(groups = { "android", "ios", "web", "BVT0502" })
	public void testCalendarEventsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyCalendarTab()
				.thenVerifyCalendarEventsShouldNotBeNull();
	}
	*/

	/*
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testMessagesOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyMessagesShouldNotBeNull();

	}
	*/
	
	/*
	// NEEDS TO BE IMPLEMENTED FULLY <- INSTRUCTIONS UNCLEAR
	@Test(groups = { "android", "ios", "web", "BVT0504" })
	public void testVolunteerAsksOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton();
	}
	*/
	
	/*
	@Test(groups = { "android", "ios", "web", "BVT0505" })
	public void testContactsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyContactsTab().thenVerifyContactsShouldNotBeNull();
	}
	/*
	

	/*
	@Test(groups = { "android", "ios", "BVT0601" })
	public void testBackgroundingForegroundingApp() throws Exception {
		// needs to be implemented
		// mobile only
	}
	*/
	
	/*
	@Test(groups = { "android", "ios", "web", "BVT0801" })
	public void testLaunchingClassFromLeftNav() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName();
	}
	*/
	
	// NOT FINISHED - APP DOES NOT FUNCTION PROPERLY
	/*
	@Test(groups = { "android", "ios", "web", "BVT0802" })
	public void testSwitchingTabsInsideClassPage() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnMediaTab();
	} */

	/*
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostInClassWithPictures() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName();
	}
	*/
	
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createEventWithInviteesInAClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnCalendarTab().clickOnEventButton()
		.clickOnEventTab().enterTitleText().enterLocationText().enterNotesText().clickStartDateBox().clickStartDate()
		.clickEndDateBox().clickEndDate().clickInviteButton().clickInviteAllButton().clickDoneButton().clickRSVPButton()
		.clickSaveButton();
	}
	
	@Test(groups = { "android", "ios", "web", "BVT01101" })
	public void createVRRecurringEventInAClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnCalendarTab().clickOnEventButton()
		.clickOnEventTab().enterTitleText().enterLocationText().enterNotesText().clickStartDateBox().clickStartDate()
		.clickEndDateBox().clickEndDate();
	}
	
	
}