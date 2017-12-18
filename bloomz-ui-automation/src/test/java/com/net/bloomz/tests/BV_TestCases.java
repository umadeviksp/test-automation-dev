package com.net.bloomz.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateEventInClassPage;
import com.net.bloomz.pages.CreateMessagePage;
import com.net.bloomz.pages.EditMyProfilePage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.utils.Config;


public class BV_TestCases extends BaseTest {
	
	String sCCode;
	static String my_email = "alphateacher@test.com";
	static String my_pwd = "bloomz999" ;
	
	// Installation
	// 1.1 Verify that the Bloomz apk Installation succeeds
	@Test(groups = { "android", "BVT0101" })
	public void BVT_01_testAppInstallation() {
		System.out.println("BVT_01_testAppInstallation");
		Assert.assertTrue(((AndroidDriver<?>) browser.getWebDriver()).isAppInstalled("net.bloomz"),
				"App is not Installed");
	}
	
	// Launch
	// 2.1 Verify that the Bloomz app can be Launched
	@Test(groups = { "android", "ios", "BVT0201" })
	public void BVT_02_testAppLauch() {
		System.out.println("BVT_02_testAppLauch");
		LandingPage.getLandingPage(browser).thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}
	
	
	//Sign In
	// 3.1 Verify that the registered user can Sign In 
	@Test(groups = { "android", "ios", "web", "BVT0301" })
	public void BVT_03_testSignInWithValidInputs() throws Exception {
		System.out.println("BVT_03_testSignInWithValidInputs");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.thenVerifyProfileName("Alpha Teacher").clickOnSettingButton().clickOnSignOutButton();
	}
	
		
	// Sign Up - Teacher
	// 4.1 Verify that a new user (no Invitation) can sign up as a Teacher
	@Test(groups = { "android", "ios", "web", "BVT0401" })
	public void BVT_04_1_testSignUpAsATeacher() throws Exception {
		System.out.println("BVT_04_1_testSignUpAsATeacher");
		String sEmail = "test_" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		System.out.println(sEmail);
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("test").enterLastName("bloomz")
		.enterEmailId(sEmail).enterPassword(my_pwd)
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test bloomz")
		.thenVerifyWelcomeScreen().clickOnSettingButton().clickOnSignOutButton();
	}
	
	
	// FRE - Teacher
	// 4.2 Verify the New Teacher FRE - No Invitation
	@Test(groups = { "android", "ios", "web", "BVT0402" })
	public void BVT_04_2_testSignUpAsATeacherFRE() throws Exception {
		System.out.println("BVT_04_2_testSignUpAsATeacherFRE");
		String sClassName = "test_" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sClassName);
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnCreateClass().enterClassName(sClassName)
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickOnSaveButtonLocator().thenVerifyMainFeed().clickOnMembersTab().clickOnMembersManageButton()
		.clickOnMembersGeneralTab().clickOnDeleteClass().clickOnDeleteClassConfirm();	
	}	
	
	
	// Add member, Teacher to a class
	// 4.3 Verify that a teacher can be invited to a class
	@Test(groups = { "android", "ios", "web", "BVT0403" })
	public void BVT_04_3_testInviteteacherToAClass() throws Exception {
		System.out.println("BVT_04_3_testInviteteacherToAClass");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().clickOnMembersTab()
		.clickOnAddMembers().clickOnInviteMembers().selectTeacherRole().selectEmailsManually().enterEmailId("test@test.com")
		.clickOnEmailSendButton().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers("test@test.com")
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
		//.clickOnSettingButton().clickOnSignOutButton();
	}
		
	
	// Sign Up - Room Parent
	// 4.4 Verify that new user can sign up as the Room parent with no invitation code
	@Test(groups = { "android", "ios", "web", "BVT0404" })
	public void BVT_04_4_testSignUpAsARoomParent() throws Exception {
		System.out.println("BVT_04_4_testSignUpAsARoomParent");
		String sEmail = "test_" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		System.out.println(sEmail);
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("test").enterLastName("bloomz")
		.enterEmailId(sEmail).enterPassword(my_pwd).clickOnRoomParent()
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test bloomz")
		.clickOnSettingButton().clickOnSignOutButton();
	}
	
	
	// FRE - Room Parent
	// 4.5 Verify the new room parent FRE- No Invitation code
	@Test(groups = { "android", "ios", "web", "BVT0405" })
	public void BVT_04_5_testSignUpAsARoomParentFRE() throws Exception {
		System.out.println("BVT_04_5_testSignUpAsARoomParentFRE");
		String sClassName = "test_" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sClassName);
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnCreateClass().enterClassName(sClassName)
		.clickRoomParentButton()
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickOnSaveButtonLocator().thenVerifyMainFeed().clickOnMembersTab().clickOnMembersManageButton()
		.clickOnMembersGeneralTab().clickOnDeleteClass().clickOnDeleteClassConfirm();
	}
	
	
	
	
		
	// Calendar screen loading
	// 5.2 Verify an existing Teacher (account with a bunch of events in the class) is able to load the Calendar screen
	@Test(groups = { "android", "ios", "web", "BVT0502" })
	public void BVT_05_2_testCalendarEventsOnMainFeedForExistingAccount() throws Exception {
		System.out.println("BVT_05_2_testCalendarEventsOnMainFeedForExistingAccount");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnMyCalendarTab()
		.thenVerifyCalendarEventsShouldNotBeNull();
	}	
	
	
	// Messages screen loading 
	// Pre-requisite for testcase 5.3 also covers 10.4
	//Feature Message To - Row 69, message to a personal connection/my classes
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void BVT_05_3_1_testCreateMessageToAConnection() throws Exception {
		System.out.println("BVT_05_3_1_testCreateMessageToAConnection");
		String sinputMessage = "Message to a contact_" + getTimeStamp();
		System.out.println(sinputMessage);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts ().clickOnToFirstContact ()
		.clickOnMessageDone ().inputOnMessageField(sinputMessage).clickOnSendButton().clickOnBackButton()
		.clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton();
	}
	
	
	// 5.3 Verify an existing Teacher (account with a bunch of messages) is able to load the Messages screen
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void BVT_05_3_2_testMessagesOnMainFeedForExistingAccount() throws Exception {
		System.out.println("BVT_05_3_2_testMessagesOnMainFeedForExistingAccount");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyMessagesShouldNotBeNull()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteMessageButton();
	}
	
	
	
	
	// Contacts screen loading
	// 5.5 Verify an existing Teacher (account with contacts) is able to load the Contacts screen
	@Test(groups = { "android", "ios", "web", "BVT0505" })
	public void BVT_05_5_testContactsOnMainFeedForExistingAccount() throws Exception {
		System.out.println("BVT_05_5_testContactsOnMainFeedForExistingAccount");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnMyContactsTab().thenVerifyContactsShouldNotBeNull();
	}	
	
	
	// 
	@Test(groups = { "android", "ios", "BVT0601" })
	public void testBackgroundingForegroundingApp() throws Exception {
		System.out.println("testBackgroundingForegroundingApp");
		// needs to be implemented
		// mobile only
	}
	
	
	// Scroll up and down the Home feed
	// 7.1 Verify the Teacher (account with multiple posts) is able to scroll up and down the Home screen
	@Test(groups = { "android", "ios", "web", "BVT0701" })
	public void BVT_07_1_testScrollUpDownHomeFeed() throws Exception {
		System.out.println("BVT_07_1_testScrollUpDownHomeFeed");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().ScrollDownHomeFeed().thenVerifyScrollDown("support site")
		.ScrollUpHomeFeed().thenVerifyScrollUp("Welcome to Bloomz");
	}
	
	
	// Scroll up and down the Calendar feed
	// 7.2 Verify the Teacher (account with multiple posts) is able to scroll up and down the Calendar screen
	@Test(groups = { "android", "ios", "web", "BVT0702" })
	public void BVT_07_2_testScrollUpDownCalendarFeed() throws Exception {
		System.out.println("BVT_07_2_testScrollUpDownCalendarFeed");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnMyCalendarTab().ScrollDownCalendarFeed()
		.ScrollUpCalendarFeed().thenVerifyScrollUp("Today");
	}	
	
	
	
	// Launching the Class from left nav
	// 8.1 Verify the Teacher ( existing account which has class created and data in the class) is able to launch his class from the left nav
	@Test(groups = { "android", "ios", "web", "BVT0801" })
	public void BVT_08_1_testLaunchingClassFromLeftNav() throws Exception {
		System.out.println("BVT_08_1_testLaunchingClassFromLeftNav");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().thenVerifyClassname("Alpha Teacher");
	}	
	
		
	// Switching between tabs inside the Class
	// 8.2 Verify the Teacher ( existing account which has class created and data in the class) is able to switch between the tabs in the Class screen
	@Test(groups = { "android", "ios", "web", "BVT0802" })
	public void BVT_08_2_testSwitchTabsInClass() throws Exception {
		System.out.println("BVT_08_2_testSwitchTabsInClass");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().thenVerifyClassname("Alpha Teacher")
		.clickOnCalendarTab().thenVerifyElementExists();
		ClassPage.getClassPage(browser).clickOnMediaTab().thenVerifyElementExists();
		ClassPage.getClassPage(browser).clickOnMembersTab().thenVerifyElementExists();
	}
	
	
	// Create Post in a Class - with pictures
	// 9.1 Verify the Teacher (existing account which has class created) is able to create a post with pictures in the class
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void BVT_09_1_testCreatePostInClassWithPictures() throws Exception {
		System.out.println("BVT_09_1_testCreatePostInClassWithPictures");
	
		Path currentRelativePath = Paths.get("");
		String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle("Create new post").enterGeneralUpdate("random text")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton().clickOnUpdatesTab();		
	}
	
	
	// Create Announcement in a class
	// 9.2 Verify the Teacher (existing account which has class created) is able to create an announcement in the class
	@Test(groups = { "android", "ios", "web", "BVT0902" })
	public void BVT_09_2_testCreateAnnouncementInClass() throws Exception {
		System.out.println("BVT_09_2_testCreateAnnouncementInClass");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName()
		.createNewAnnouncement()
		.enterTitle("test announcement").enterGeneralUpdate("random text for verifying announcement feature")
		.clickOnPostButton().thenVerifyAnnouncements("(1)").
		clickOnAnnouncement().clickOnAnnouncementOptions()
		.clickOnAnnouncementDeleteButton().clickOnConfirmAnnouncementDeleteButton();
	}
	
	
	// Create Alert in a class
	// 9.3 Verify the Teacher (existing account which has class created) is able to create an alert in the class	
	// Checkpoint has to be added
	@Test(groups = { "android", "ios", "web", "BVT0903" })
	public void BVT_09_3_testCreateAlertInClass() throws Exception {
		System.out.println("BVT_09_3_testCreateAlertInClass");
		String sTitle = "test_alert_message" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().createNewAlert()
		.clickOnContinueCreateAlertButton().clickOnToFieldLocator().clickOnToClassFieldLocator().clickOnDoneLocator()
		.enterTitle(sTitle).enterGeneralUpdate("Create alert in class").clickOnPostButton().clickOnAllGroupsButton();
		
//		HomePage.getHomePage(browser).clickOnAlertEventButton().readAlertEventTitle(sTitle).thenVerifyAlertMessgae()
//		.clickOnOptionsLocator().clickOnDeletePostLocator().clickOnConfirmDeleteAlert();		
	}	
	
	
	// Create Event with invitees in a class
	// 10.1 Verify the Teacher (existing account which has class created) is able to create an event in the class and invite all the class parents
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void BVT_10_1_createEventWithInviteesInAClass() throws Exception {
		System.out.println("BVT_10_1_createEventWithInviteesInAClass");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().clickOnCalendarTab();
		
		CreateEventInClassPage.getCreateEventInClassPage(browser).createNewEvent()		
		.enterTitle(sTitle).enterLocation("random location").enterNotes("some notes")
		.clickRSVPButton().clickInviteButton().clickInviteAllButton().clickDoneButton()
		.clickOnReminderButton().selectFifteenMinsReminder().clickOnDoneReminderButton()
		.clickStartDate().clearStartDate().enterStartDate(0, 0, 5).clickCloseCalendar().clickStartTime()
		.clearStartTime().enterStartTime("10:00 AM").clickEndDate().clearEndDate().enterEndDate(0, 0, 5)
		.clickCloseCalendar().clearEndTime().enterEndTime("12:00 PM")
		.clickSaveButton().clickOnOKButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
		//HomePage.getHomePage(browser).clickOnEventBubbleButton();
		//ClassPage.getClassPage(browser).clickOnUpdatesTab().clickOnUpcomingEventSection()
		//.clickOnEventOptions().clickOnEventOptionsDeleteReminder().clickOnConfirmEventDelete()
		//.thenVerifyThatEventWasSuccessful("Event Deleted Successfully!");		
	}	
	
	
	// Create VR Recurring Event in a class
	// 10.2 Verify the Teacher (existing account which has class created) is able to create a Recurring VR event in the class and notifies all the parents
	@Test(groups = { "android", "ios", "web", "BVT01002" })
	public void BVT_10_2_createVRRecurringEventInAClass() throws Exception {
		System.out.println("BVT_10_2_createVRRecurringEventInAClass");
		String sTitle = "test_VRRecurringevent" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName()
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
		System.out.println("BVT_10_3_createPTCEventInAClass");
		String sTitle = "test_PTCEvent" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnAClassName().createNewPTCEvent()
		.enterTitle(sTitle).enterLocation("random location").enterDate().enterNotes("some notes").clickNextButton().clickNext2Button()
		.selectFirstClassButton().clickDoneButton().clickSendButton().thenVerifyThatPTCEventWasSuccessful("Successfully added to Calendar!");
	}
	
	
	// Send a Message to the class
	// 10.4 Verify the Teacher (existing account which has class created) is able to message to the class 	
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void BVT_10_4_testCreateMessageToAClass() throws Exception {
		System.out.println("BVT_10_4_testCreateMessageToAClass");
		String sinputMessage = "Message to a class_" + getTimeStamp();
		System.out.println(sinputMessage);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyClasses().clickOnToFirstClass().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnSendToEveryoneButton()
		.clickOnBackButton().clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	
	
	// Invite Parents to Class -  Copy Paste
	// 10.5 Verify the Teacher (existing account which has class created) is able to Invite Parent to the class by copy and paste
	@Test(groups = { "android", "ios", "web", "BVT1005" })
	public void BVT_10_5_testInviteParentsToClassCopyAndPaste() {
		System.out.println("BVT_10_5_testInviteParentsToClassCopyAndPaste");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectParentRole().selectEmailsManually().enterEmailId("test@test.com ")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers("test")
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
	}
	
	
	// Invite Parents to Class - Smart Invite
	// 10.6 Verify the Teacher (existing account which has class created) is able to Invite Parent to the class through smart invite
	@Test(groups = { "android", "ios", "web", "BVT1006" })
	public void BVT_10_6_testInviteParentsToClassSmartInvite() {
		System.out.println("BVT_10_6_testInviteParentsToClassSmartInvite");
		LandingPage.getLandingPage(browser).clickOnSignInButton()
				.enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton()
				.thenVerifyCreateButtonShouldBeDisplayed()
				.clickOnInviteButton().selectAnyOneClass().selectParentRole()
				.selectSmartInviteUseGmail().clickOnGmailOption().clickOnContinue();
	}
	
	
	//Upload the Cover photo of the class
	//10.7 Verify the Teacher (existing account which has class created) is able to Upload the Cover photo of the class
	@Test(groups = { "android", "ios", "web", "BVT1007" })
	public void BVT_10_7_testUploadTheCoverPhotoOfTheClass() throws InterruptedException, IOException {
		System.out.println("BVT_10_07_testUploadTheCoverPhotoOfTheClass");
		Path currentRelativePath = Paths.get("");
		String sCurrentPath = currentRelativePath.toAbsolutePath().toString() ;
		String sUploadapp = sCurrentPath + Config.getConfigData("test_cover_image");
		if (sCurrentPath.contains("/"))
		{
			System.out.println ("this is not windows") ;
		}
		else
		{
			sUploadapp = sUploadapp.replaceAll("/","\\\\");
			System.out.println ("this is windows") ;
		}
		System.out.println(sUploadapp);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnAClassName()
		.clickOnEditCoverPhotoButton().clickOnUploadNewPhotoButton().uploadImage(sUploadapp);
		HomePage.getHomePage(browser).thenVerifyThatUploadWasSuccessful("Updated cover photo successfully").clickOnSettingButton().clickOnSignOutButton();
	}
	
	
	//Upload the mascot image of the class
	//10.8 Verify the Teacher (existing account which has class created) is able to Upload the Mascot image of the class
	@Test(groups = { "android", "ios", "web", "BVT1008" })
	public void BVT_10_8_testUploadTheMascotPhotoOfTheClass() throws InterruptedException, IOException {
		System.out.println("BVT_10_08_testUploadTheMascotPhotoOfTheClass");
		Path currentRelativePath = Paths.get("");
		String sCurrentPath = currentRelativePath.toAbsolutePath().toString() ;
		String sUploadapp = sCurrentPath + Config.getConfigData("test_cover_image");
		if (sCurrentPath.contains("/"))
		{
			System.out.println ("this is not windows") ;
		}
		else
		{
			sUploadapp = sUploadapp.replaceAll("/","\\\\");
			System.out.println ("this is windows") ;
		}
		System.out.println(sUploadapp);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnAClassName()
		.clickOnMascotPhoto().clickOnUploadNewPhotoButton().uploadImage(sUploadapp);
			
		HomePage.getHomePage(browser).thenVerifyThatUploadWasSuccessful("Group Logo updated successfully").clickOnSettingButton().clickOnSignOutButton();
	}
	
	//Upload the profile picture
	//10.9 Verify the Teacher (existing account which has class created) is able to Upload the Profile picture
	@Test(groups = { "android", "ios", "web", "BVT1009" })
	public void BVT_10_9_testUploadTheProfilePictureOfTheUser() throws InterruptedException, IOException {
		System.out.println("BVT_10_09_testUploadTheProfilePictureOfTheUser");
		Path currentRelativePath = Paths.get("");
		String sCurrentPath = currentRelativePath.toAbsolutePath().toString() ;
		String sUploadapp = sCurrentPath + Config.getConfigData("test_cover_image");
		if (sCurrentPath.contains("/"))
		{
			System.out.println ("this is not windows") ;
		}
		else
		{
			sUploadapp = sUploadapp.replaceAll("/","\\\\");
			System.out.println ("this is windows") ;
		}
		System.out.println(sUploadapp);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed();
		
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton()
		.uploadProfileImage()
		//.clickOnUploadNewPhotoButton()
		.uploadImage(sUploadapp);
		
		EditMyProfilePage.getEditMyProfilePage(browser).clickOnSaveButton();
		
		HomePage.getHomePage(browser).thenVerifyThatPostWasSuccessful("Profile updated successfully");
		
		MyProfilePage.getMyProfilePage(browser).clickOnGoBackButton();
		
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton();
	}
	
	// Pre-requisite to run the invitation code testcase
	@Test(groups = { "android", "ios", "web", "BVT1100" })
	public void BVT_11_0_ReadClassAccess() throws Exception {
		System.out.println("BVT_11_0_ReadClassAccess");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnAClassName().clickOnUpdatesTab();
		ClassPage.getClassPage(browser).clickOnAccessCodes().clickOnForParentsAccessCodes();
		
		sCCode = ClassPage.getClassPage(browser).readClassCode();
		
		ClassPage.getClassPage(browser).clickOnDoneButton();		
		
	}
	
	// Parent sign up with Class Access Code - Class with B/P ON
	// 11.1 Verify the parent is able to sign up with class access code and is able to pick the student from the list
	@Test(groups = { "android", "ios", "web", "BVT1101" })
	public void BVT_11_1_SignUpWithExistingChild() throws Exception {
		System.out.println("BVT_11_1_SignUpWithExistingChild");
		String sEMail = "test_" + getTimeStamp() + "@test.com" ;
		System.out.println(sEMail);
		
		sEMail = sEMail.toLowerCase();
		
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnJoinAClassGroup().enterInvitationCode(sCCode)
		.clickInviteNext().enterFirstName("test").enterLastName("automation").enterEmailID(sEMail).enterPassword(my_pwd)
		.clickOnNext().selectTestChildName().clickOnJoinClass().thenVerifyJoinClass(sEMail, "Click on the \"Verify\" button in the email we sent you.");
	}
	
	
	// Parent sign up with Class Access Code - Class with B/P ON
	// 11.2 Verify the parent is able to sign up with class access code and is able to add a student
	@Test(groups = { "android", "ios", "web", "BVT1102" })
	public void BVT_11_2_SignUpWithNewChild() throws Exception {
		System.out.println("BVT_11_2_SignUpWithNewChild");
		String sEMail = "test_" + getTimeStamp() + "@test.com" ;
		sEMail = sEMail.toLowerCase();
		System.out.println(sEMail);
		
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnJoinAClassGroup().enterInvitationCode(sCCode)
		.clickInviteNext().enterFirstName("test").enterLastName("automation").enterEmailID(sEMail).enterPassword(my_pwd)
		.clickOnNext().selectAddYourChild().enterChildFirstName("testChild" + getTimeStamp()).clickOnAddClass().clickOnJoinClass()
		.thenVerifyJoinClass(sEMail, "Click on the \"Verify\" button in the email we sent you.");
	}
	
	
	// Pre-requisite to run the invitation code testcase
	@Test(groups = { "android", "ios", "web", "BVT1103" })
	public void BVT_11_3_ReadClassAccessBOPff() throws Exception {
		System.out.println("BVT_11_3_ReadClassAccessBPOff");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnBPOffClassName().clickOnUpdatesTab();
		ClassPage.getClassPage(browser).clickOnAccessCodes().clickOnForParentsAccessCodes();
		
		sCCode = ClassPage.getClassPage(browser).readClassCode();
		System.out.println(sCCode);
		ClassPage.getClassPage(browser).clickOnDoneButton();		
		
	}
	
	// Parent sign up with Class Access Code - Class with no B/P
	// 11.3 Verify the parent is able to sign up with class access code and is able to add the child info while joining
	@Test(groups = { "android", "ios", "web", "BVT1104" })
	public void BVT_11_4_SignUpWithNewChildBPOFF() throws Exception {
		System.out.println("BVT_11_4_SignUpWithNewChildBPOFF");
		String sEMail = "test_" + getTimeStamp() + "@test.com" ;
		sEMail = sEMail.toLowerCase();
		System.out.println(sEMail);
		
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnJoinAClassGroup().enterInvitationCode(sCCode)
		.clickInviteNext().enterFirstName("test").enterLastName("automation").enterEmailID(sEMail).enterPassword(my_pwd)
		.clickOnNext().addChildFirstName("test child")//.thenVerifyLastName("automation")
		.clickOnJoinClass().thenVerifyJoinClass(sEMail, "Click on the \"Verify\" button in the email we sent you.");
	}
	
	// Home screen loading
	// 5.1 Verify an existing Teacher (account with a bunch of posts to the class) is able to load the Home screen
	@Test(groups = { "android", "ios", "web", "BVT0501" })
	public void BVT_12_05_1_testPostsOnMainFeedForExistingAccount() throws Exception {
		System.out.println("BVT_05_1_testPostsOnMainFeedForExistingAccount");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.thenVerifyProfileName("Alpha Teacher").thenVerifyMainFeedPostShouldNotBeNull().
		clickOnSettingButton().clickOnSignOutButton();
	}	
	
	// 5.4 Verify an existing Teacher (account with Volunteer Asks in the class) is able to load the Volunteer Asks screen
	@Test(groups = { "android", "ios", "web", "BVT0504" })
	public void BVT_12_05_4_testSignupssOnMainFeedForExistingAccount() throws Exception {
		System.out.println("BVT_05_4_testSignupssOnMainFeedForExistingAccount");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnMySignupsTab().thenVerifySignupButton();
	}
}