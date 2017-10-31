package com.net.bloomz.tests;

//import java.io.IOException;

import org.testng.annotations.Test;

//import com.net.bloomz.pages.CreateEventInClassPage;
//import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.LandingPage;
//import com.net.bloomz.pages.MembersTabPage;

public class P0Pass_TeacherAddEvent extends BaseTest {	
	
	
	// Add event to the class calendar - notify all
	@Test(groups = { "android", "ios", "web", "P0Pass_01" })
	public void P0Pass_01_createEventWithNotifyAll() throws Exception {
		System.out.println("P0Pass_01_createEventWithNotifyAll");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar - notify all")
		.clickSaveButton().clickNotifyAllMembersButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	// Add event to the class calendar - Do not notify all
	@Test(groups = { "android", "ios", "web", "P0Pass_02" })
	public void P0Pass_02_createEventWithoutNotifyAll() throws Exception {
		System.out.println("P0Pass_02_createEventWithoutNotifyAll");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar - Do not notify all")
		.clickSaveButton().clickDoNotNotifyAllMembersButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	// Add event to the class calendar and invite the entire class
	@Test(groups = { "android", "ios", "web", "P0Pass_04" })
	public void P0Pass_04_createEventInviteAllClass() throws Exception {
		System.out.println("P0Pass_04_createEventInviteAllClass");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar and invite the entire class")
		.clickInviteButton().clickInviteAllButton().clickDoneButton().clickSaveButton().clickOnOKButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	
	//Invite more people to an existing PTC event and invite the rest of the class
	@Test(groups = { "android", "ios", "web", "P0Pass_11" })
	public void P0Pass_11_editPTCEventWithInvitees() throws Exception {
		System.out.println("P0Pass_11_editPTCEventWithInvitees");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnCalendarTab().clickOnPTCvent()
		.clickOnOptionsEditEvent().clickOnInviteMorePeople().clickOnAllMembers().clickOnDoneButton()
		.clickOnSendButton().thenVerifyEmailUpdate();
	}	
		
}