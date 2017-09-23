package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateEventInClassPage;
import com.net.bloomz.pages.CreateMessagePage;
import com.net.bloomz.pages.CreatePTCEventInClassPage;
import com.net.bloomz.pages.CreateVolunteerInClassPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.utils.Config;

public class BV_TestCases extends BaseTest {
	
	/*
	// Installation
	// 1.1 Verify that the Bloomz apk Installation succeeds
	@Test(groups = { "android", "BVT0101" })
	public void BVT_01_testAppInstallation() {
		Assert.assertTrue(((AndroidDriver<?>) browser.getWebDriver()).isAppInstalled("net.bloomz"),
				"App is not Installed");
	}
	
	// Launch
	// 2.1 Verify that the Bloomz app can be Launched
	@Test(groups = { "android", "ios", "BVT0201" })
	public void BVT_02_testAppLauch() {
		LandingPage.getLandingPage(browser).thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}
	
	
	//Sign In
	// 3.1 Verify that the registered user can Sign In 
	@Test(groups = { "android", "ios", "web", "BVT0301" })
	public void BVT_03_testSignInWithValidInputs() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.thenVerifyProfileName("Alpha Teacher").clickOnSettingButton().clickOnSignOutButton();
	}
	
	// Sign Up - Teacher
	// 4.1 Verify that a new user (no Invitation) can sign up as a Teacher
	@Test(groups = { "android", "ios", "web", "BVT0401" })
	public void BVT_04_1_testSignUpAsATeacher() throws Exception {
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("test").enterLastName("bloomz")
		.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test bloomz")
		.clickOnSettingButton().clickOnSignOutButton();
	}
	
	// FRE - Teacher
	// 4.2 Verify the New Teacher FRE - No Invitation
	// cleanup to delete class should be added
	@Test(groups = { "android", "ios", "web", "BVT0402" })
	public void BVT_04_2_testSignUpAsATeacherFRE() throws Exception {
		String sClassName = "test_" + getTimeStamp().replaceAll("-", "_");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName(sClassName)
		.clickOnSaveButtonLocator().thenVerifyClassname(sClassName).clickOnASecondClassName()
		.clickOnMembersTab().clickOnMembersManageButton().clickOnMembersGeneralTab().clickOnDeleteClass().clickOnDeleteClassConfirm();	
	}		
	
	// Sign Up - Room Parent
	// 4.4 Verify that new user can sign up as the Room parent with no invitation code
	@Test(groups = { "android", "ios", "web", "BVT0404" })
	public void BVT_04_4_testSignUpAsARoomParent() throws Exception {
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("test").enterLastName("bloomz")
		.enterEmailId("test_" + getTimeStamp().replaceAll("-", "_") + "@test.com").enterPassword("bloomz999").clickOnRoomParent()
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test bloomz")
		.clickOnSettingButton().clickOnSignOutButton();
	}
	
	// FRE - Room Parent
	// 4.5 Verify the new room parent FRE- No Invitation code
	// Checkpoint has to be added
	// Steps are leading to error
	@Test(groups = { "android", "ios", "web", "BVT0405" })
	public void BVT_04_5_testSignUpAsARoomParentFRE() throws Exception {
		//String sClassName = "test_" + getTimeStamp().replaceAll("-", "_");
		//LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alpharoomparent@test.com")
		//.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass()
		//.enterClassName(sClassName).clickRoomParentButton().clickOnSaveButtonLocator().thenVerifyClassname(sClassName);
	}
		
	// Home screen loading
	// 5.1 Verify an existing Teacher (account with a bunch of posts to the class) is able to load the Home screen
	@Test(groups = { "android", "ios", "web", "BVT0501" })
	public void BVT_05_1_testPostsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.thenVerifyProfileName("Alpha Teacher").thenVerifyMainFeedPostShouldNotBeNull().
		clickOnSettingButton().clickOnSignOutButton();
	}
		
	// Calendar screen loading
	// 5.2 Verify an existing Teacher (account with a bunch of events in the class) is able to load the Calendar screen
	@Test(groups = { "android", "ios", "web", "BVT0502" })
	public void BVT_05_2_testCalendarEventsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyCalendarTab()
		.thenVerifyCalendarEventsShouldNotBeNull();
	}		
	
	// Messages screen loading 
	// Pre-requisite for testcase 5.3 also covers 10.4
	//Feature Message To - Row 69, message to a personal connection/my contacts
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void BVT_05_3_1_testCreateMessageToAConnection() throws Exception {
		String sinputMessage = "Message to a contact_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts ().clickOnToFirstContact ()
		.clickOnMessageDone ().inputOnMessageField(sinputMessage).clickOnSendButton().clickOnBackButton()
		.clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton();
	}
	
	// 5.3 Verify an existing Teacher (account with a bunch of messages) is able to load the Messages screen
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void BVT_05_3_2_testMessagesOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyMessagesShouldNotBeNull()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteMessageButton();
	}	
		
	// Contacts screen loading
	// 5.5 Verify an existing Teacher (account with contacts) is able to load the Contacts screen
	@Test(groups = { "android", "ios", "web", "BVT0505" })
	public void BVT_05_5_testContactsOnMainFeedForExistingAccount() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyContactsTab().thenVerifyContactsShouldNotBeNull();
	}	
	
	// 
	@Test(groups = { "android", "ios", "BVT0601" })
	public void testBackgroundingForegroundingApp() throws Exception {
		// needs to be implemented
		// mobile only
	}
	
	// Launching the Class from left nav
	// 8.1 Verify the Teacher ( existing account which has class created and data in the class) is able to launch his class from the left nav
	@Test(groups = { "android", "ios", "web", "BVT0801" })
	public void BVT_08_1_testLaunchingClassFromLeftNav() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().thenVerifyClassname("Alpha's Class");
	}	
	
		
	// Switching between tabs inside the Class
	// 8.2 Verify the Teacher ( existing account which has class created and data in the class) is able to switch between the tabs in the Class screen
	@Test(groups = { "android", "ios", "web", "BVT0802" })
	public void BVT_08_2_testSwitchTabsInClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().thenVerifyClassname("Alpha's Class")
		.clickOnCalendarTab().thenVerifyElementExists();
		ClassPage.getClassPage(browser).clickOnMediaTab().thenVerifyElementExists();
		ClassPage.getClassPage(browser).clickOnMembersTab().thenVerifyElementExists();
	}
	

	// Create Post in a Class - with pictures
	// 9.1 Verify the Teacher (existing account which has class created) is able to create a post with pictures in the class
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void BVT_09_1_testCreatePostInClassWithPictures() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle("random title").enterGeneralUpdate("random text")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton().clickOnUpdatesTab();
	}		
	
	// Create Announcement in a class
	// 9.2 Verify the Teacher (existing account which has class created) is able to create an announcement in the class
	@Test(groups = { "android", "ios", "web", "BVT0902" })
	public void BVT_09_2_testCreateAnnouncementInClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewAnnouncement()
		.enterTitle("test announcement").enterGeneralUpdate("random text for verifying announcement feature")
		.clickOnPostButton().thenVerifyAnnouncements("(1)").clickOnAnnouncementCloseButton().clickOnAnnouncementDeleteButton();
	}		
	
	// Create Alert in a class
	// 9.3 Verify the Teacher (existing account which has class created) is able to create an alert in the class	
	// Checkpoint has to be added
	@Test(groups = { "android", "ios", "web", "BVT0903" })
	public void BVT_09_3_testCreateAlertInClass() throws Exception {
		String sTitle = "test_alert_" + getTimeStamp().replaceAll("-", "_");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewAlert()
		.clickOnContinueCreateAlertButton().clickOnToFieldLocator().clickOnToClassFieldLocator().clickOnDoneLocator()
		.enterTitle(sTitle).enterGeneralUpdate("Create alert in class").clickOnPostButton()
		.clickOnAlertEventButton().readAlertEventTitle(sTitle).thenVerifyAlertMessgae().clickOnOptionsLocator().clickOnDeletePostLocator();		
	}	
	
	// Create Event with invitees in a class
	// 10.1 Verify the Teacher (existing account which has class created) is able to create an event in the class and invite all the class parents
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void BVT_10_1_createEventWithInviteesInAClass() throws Exception {
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnCalendarTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("some notes")
		.clickInviteButton().clickInviteAllButton().clickDoneButton().clickSaveButton().clickOnOKButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!").clickOnUpdatesTab().clickOnUpcomingEventSection()
		.clickOnEventOptions().clickOnEventOptionsDeleteReminder().clickOnConfirmEventDelete()
		.thenVerifyThatEventWasSuccessful("Event Deleted Successfully!");	;		
	}	
	
	// Create VR Recurring Event in a class
	// 10.2 Verify the Teacher (existing account which has class created) is able to create a Recurring VR event in the class and notifies all the parents
	@Test(groups = { "android", "ios", "web", "BVT01002" })
	public void BVT_10_2_createVRRecurringEventInAClass() throws Exception {
		String sTitle = "test_VRRecurringevent" + getTimeStamp().replaceAll("-", "_");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName()
		.clickCreateButton().createVolunteerAsk().clickNeedItemsButton().typeItems().clickNeedPeopleButton()
		.enterTask().clickNextButton().enterTitleText(sTitle).enterLocationText("some location").enterNotesText("random notes")
		.clickRepeatButton().clickRepeatWeeklyButton().clickExitRepeatScreenButton().clickEndRepeatButton()
		.typeNumberOfTimesButtonLocator().clickExitAfterNumberOfTimesButtonLocator().clickNextButton().clickNext2Button()
		.enterMessage("Optional message for Volunteer ask").clickSendButton()
		.clickOnUpcomingEvents().readUpcomingEventTitle(sTitle)
		.clickOnUpcomingEventsOptions().clickOnUpcomingEventDelete().clickOnConfirmUpcomingEventDelete();
	}	
	
	// Create PTC Event in the class 
	// 10.3 Verify the Teacher (existing account which has class created) is able to create a PTC event in the class and Invites all the parents
	@Test(groups = { "android", "ios", "web", "BVT01003" })
	public void BVT_10_3_createPTCEventInAClass() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPTCEvent()
		.enterTitle("test title").enterLocation("random location").enterDate().enterNotes("some notes").clickNextButton().clickNext2Button()
		.selectFirstClassButton().clickDoneButton().clickSendButton().thenVerifyThatPTCEventWasSuccessful("Successfully added to Calendar!");
	}
	
	// Send a Message to the class
	// 10.4 Verify the Teacher (existing account which has class created) is able to message to the class 	
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void BVT_10_4_testCreateMessageToAClass() throws Exception {
		String sinputMessage = "Message to a class_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyClasses().clickOnToFirstClass().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnSendToEveryoneButton()
		.clickOnBackButton().clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	*/
	
	// Scroll up and down the Home feed
	// 7.1 Verify the Teacher (account with multiple posts) is able to scroll up and down the Home screen
	@Test(groups = { "android", "ios", "web", "BVT0701" })
	public void BVT_07_1_testScrollUpDownHomeFeed() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().ScrollDownHomeFeed().thenVerifyScrollDown("support site")
		.ScrollUpHomeFeed().thenVerifyScrollUp("Welcome to Bloomz");
	}	
	
	// Scroll up and down the Calendar feed
	// 7.1 Verify the Teacher (account with multiple posts) is able to scroll up and down the Calendar screen
	@Test(groups = { "android", "ios", "web", "BVT0702" })
	public void BVT_07_2_testScrollUpDownCalendarFeed() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyCalendarTab().ScrollDownHomeFeed().thenVerifyScrollDown("support site")
		.ScrollUpHomeFeed().thenVerifyScrollUp("Welcome to Bloomz");
	}	
	
}