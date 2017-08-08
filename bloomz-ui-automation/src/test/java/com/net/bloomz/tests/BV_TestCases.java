package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.utils.Config;

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

	@Test(groups = { "android", "ios", "web", "BVT0301" })
	public void testSignInWithValidInputs() throws Exception {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
				.clickOnSettingButton().clickOnSignOutButton();

	}
	
	@Test(groups = { "android", "ios", "web", "BVT0401" })
	public void testSignUpAsATeacher() throws Exception {
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton().clickOnSignOutButton();
	}

	@Test(groups = { "android", "ios", "web", "BVT0402" })
	public void testSignUpAsATeacherFRE() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton()
				.clickOnCreateClass().clickOnchooseSchoolButtonLocator().enterSchoolSearch("123").clickOnSchoolLocator()
				.enterClassName("test").clickOnSaveButtonLocator();
	}
	
	/* 
	 * NEED TO DO TEST CASE BVT 4.3
	 * */


	@Test(groups = { "android", "ios", "web", "BVT0404" })
	public void testSignUpAsARoomParent() throws Exception {
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
				.enterFirstName("test").enterLastName("bloomz")
				.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999").clickOnRoomParent()
				.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton().clickOnSignOutButton();
	}

	@Test(groups = { "android", "ios", "web", "BVT0405" })
	public void testSignUpAsARoomParentFRE() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alpharoomparent@test.com")
				.enterPasswordOnTextBox("bloomz999").clickOnSignInButton()
				.clickOnCreateClass().clickOnchooseSchoolButtonLocator().enterSchoolSearch("123").clickOnSchoolLocator()
				.enterClassName("test").clickRoomParentButton().clickOnSaveButtonLocator();
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
	}

	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testMessagesOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyMessagesShouldNotBeNull();

	}

	// NEEDS TO BE IMPLEMENTED FULLY <- INSTRUCTIONS UNCLEAR
	/*
	@Test(groups = { "android", "ios", "web", "BVT0504" })
	public void testVolunteerAsksOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton();
	}
	*/

	@Test(groups = { "android", "ios", "web", "BVT0505" })
	public void testContactsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyContactsTab().thenVerifyContactsShouldNotBeNull();
	}

	@Test(groups = { "android", "ios", "BVT0601" })
	public void testBackgroundingForegroundingApp() throws Exception {
		// needs to be implemented
		// mobile only
	}
	
	@Test(groups = { "android", "ios", "web", "BVT0801" })
	public void testLaunchingClassFromLeftNav() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName();
	}
	
	// NOT FINISHED - APP DOES NOT FUNCTION PROPERLY
	/*
	@Test(groups = { "android", "ios", "web", "BVT0802" })
	public void testSwitchingTabsInsideClassPage() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnMediaTab();
	}
	*/

	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostInClassWithPictures() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		// .clickOnPostToField().clickOnToFirstClass().clickOnToDoneButton()
		.enterTitle("random title").enterGeneralUpdate("random text")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton().clickOnUpdatesTab();
	}

	@Test(groups = { "android", "ios", "web", "BVT0902" })
	public void testCreateAnnouncementInClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewAnnouncement()
		.enterTitle("test title").enterGeneralUpdate("random text").clickOnPostButton();
	}
	
	@Test(groups = { "android", "ios", "web", "BVT0903" })
	public void testCreateAlertInClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewAlert()
		.clickOnContinueCreateAlertButton().enterTitle("test title").enterGeneralUpdate("random text")
		.clickOnPostButton();
	}

	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createEventWithInviteesInAClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnCalendarTab()
		.createNewEvent().enterTitle("test title").enterLocation("random location").enterNotes("some notes")
		.clickInviteButton().clickInviteAllButton().clickDoneButton().clickSaveButton();
	}
	
	@Test(groups = { "android", "ios", "web", "BVT01002" })
	public void createVRRecurringEventInAClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName()
		.clickCreateButton().createVolunteerAsk().clickNeedItemsButton().typeItems().clickNeedPeopleButton()
		.enterTask().enterTitleText("test title").enterLocationText("some location").enterNotesText("random notes")
		.clickRepeatButton().clickRepeatWeeklyButton().clickExitRepeatScreenButton().clickEndRepeatButton()
		.typeNumberOfTimesButtonLocator().clickExitAfterNumberOfTimesButtonLocator()
		.clickRSVPButton().clickSaveButton();
	}
	
	@Test(groups = { "android", "ios", "web", "BVT01003" })
	public void createPTCEventInAClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName()
		.createNewPTCEvent().enterTitle("test title").enterLocation("random location").enterDate().enterNotes("some notes")
		.clickNextButton().clickNext2Button().selectFirstClassButton().clickDoneButton().clickSendButton();
	}
}