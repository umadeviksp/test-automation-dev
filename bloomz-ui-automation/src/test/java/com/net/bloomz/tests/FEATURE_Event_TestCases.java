package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.LandingPage;


public class FEATURE_Event_TestCases extends BaseTest {

	static String my_email = "alphateacher@test.com";
	static String my_pwd = "bloomz999" ;
	static String my_student_code = "test_student code" ;
	
	@Test(groups = { "android", "BVT0101" })
	public void testAppInstallation() {
		Assert.assertTrue(((AndroidDriver<?>) browser.getWebDriver()).isAppInstalled("net.bloomz"),
				"App is not Installed");
	}
	
	@Test(groups = { "android", "ios", "BVT0201" })
	public void testAppLauch() {
		LandingPage.getLandingPage(browser).thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}
	
	
	//Create a Event for Personal calendar with Start and End, inviting a contact 
	//and editing an event title, Location and Notes
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createAndEditEventWithInvitees() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnEventItemButton()
		.enterTitle("Create an Event").enterLocation("Event Location").enterNotes("Create an event with calendar personal and invitees")
		.clickInviteButton().clickOnMyContactsButton().selectFirstContact().clickDoneButton()
		.clickStartDate().clearStartDate().enterStartDate(0, 0, 5).clickCloseCalendar().clickStartTime()
		.clearStartTime().enterStartTime("10:00 AM").clickEndDate().clearEndDate().enterEndDate(0, 0, 5)
		.clickCloseCalendar().clearEndTime().enterEndTime("12:00 PM")
		.clickSaveButton().thenVerifyThatEventWasSuccessful("Event successfully added to calendar!").clickOnEventBubbleButton()
		.clickOnEventList().clickOnEventOptions().clickOnEventOptionsEdit().enterTitle("Edit an Event")
		.enterLocation("Edit an event Location").enterNotes("Edit an event with calendar personal and invitees")
		.clickSendButton().clickOnEditNotifyYes().thenVerifyThatEventWasSuccessful("Event Updated Successfully!")
		.clickOnEventOptions().clickOnEventOptionsDeleteReminder().clickOnConfirmEventDelete()
		.thenVerifyThatEventWasSuccessful("Event Deleted Successfully!");		
	}
	
	
	//Create an Event for Personal calendar with Start and End, without invite
	//and editing an event schedule (start and end time)
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createAndEditEventWithoutInvitees() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnEventItemButton()
		.enterTitle("Create an Event").enterLocation("Event Location").enterNotes("Create an event with calendar personal and no invitees")
		.clickStartDate().clearStartDate().enterStartDate(0, 0, 3).clickCloseCalendar().clickStartTime()
		.clearStartTime().enterStartTime("10:00 AM").clickEndDate().clearEndDate().enterEndDate(0, 0, 3)
		.clickCloseCalendar().clearEndTime().enterEndTime("12:00 PM")
		.clickSaveButton().thenVerifyThatEventWasSuccessful("Event successfully added to calendar!").clickOnEventBubbleButton()
		.clickOnEventList().clickOnEventOptions().clickOnEventOptionsEdit()
		.clickStartDate().clearStartDate().enterStartDate(0, 0, 4).clickCloseCalendar()
		.clickEndDate().clearEndDate().enterEndDate(0, 0, 4).clickCloseCalendar()
		.clickSaveButton().thenVerifyThatEventWasSuccessful("Event Updated Successfully!")
		.clickOnEventOptions().clickOnEventOptionsDelete().clickOnConfirmEventDelete()
		.thenVerifyThatEventWasSuccessful("Event Deleted Successfully!");		
	}
	
	
	//Create an all day event to class for personal calendar, inviting a class
	// and post a comment
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createAndPostCommentToAllDayEvent() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton()
		.clickCreateButton().clickOnEventItemButton()
		.enterTitle("Create an All Day Event").enterLocation("All Day Event Location").enterNotes("Create an all day event with calendar personal and post a comment")
		.clickInviteButton().clickOnMyClassesButton().selectFirstClass().clickDoneButton()
		.clickOnAllDayButton().clickStartDate().clearStartDate().enterStartDate(0, 0, 2).clickCloseCalendar()
		.clickEndDate().clearEndDate().enterEndDate(0, 0, 2).clickCloseCalendar()
		.clickSendButton().thenVerifyThatEventWasSuccessful("Event successfully added to calendar!").clickOnEventBubbleButton()
		.clickOnEventList().enterPostComment().clickOnSendComment().thenVerifyThatCommentWasSuccessful("1 Comments")
		.clickOnBackButton().clickOnEventList().clickOnEventOptions().clickOnEventOptionsDeleteReminder().clickOnConfirmEventDelete()
		.thenVerifyThatEventWasSuccessful("Event Deleted Successfully!");		
	}
	
	
	//Create an event to all classes for personal calendar, with RSVP and Reminders set
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createEventwithRSVPAllClasses() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnEventItemButton()
		.enterTitle("Create an Event with RSVP").enterLocation("Event Location").enterNotes("Create an event with calendar personal and RSVP")
		.clickRSVPButton().clickInviteButton().clickOnMyClassesButton().selectAllClasses().clickDoneButton()
		.clickOnReminderButton().selectFifteenMinsReminder().clickOnDoneReminderButton()
		.clickStartDate().clearStartDate().enterStartDate(0, 0, 2).clickCloseCalendar()
		.clickEndDate().clearEndDate().enterEndDate(0, 0, 2).clickCloseCalendar()
		.clickSendButton().thenVerifyThatEventWasSuccessful("Event successfully added to calendar!").clickOnEventBubbleButton()
		.clickOnEventList().clickOnEventOptions().clickOnEventOptionsDeleteReminder().clickOnConfirmEventDelete()
		.thenVerifyThatEventWasSuccessful("Event Deleted Successfully!");		
	}
	
	//Bug there is no option to create event under community
	/*
	@Test(groups = { "android", "ios", "web", "BVT01001" })
	public void createEventInACommunity() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnACommunity().clickOnCalendarTab()
		.createNewEvent().enterTitle("test title").enterLocation("random location").enterNotes("some notes")
		.clickInviteButton().clickInviteAllButton().clickDoneButton().clickSaveButton();
	}*/

	
}