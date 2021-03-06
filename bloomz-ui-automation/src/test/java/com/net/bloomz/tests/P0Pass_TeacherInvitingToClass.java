package com.net.bloomz.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.MembersTabPage;

public class P0Pass_TeacherInvitingToClass extends BaseTest {	
	
	static String my_email = "alphateacher1@test.com";
	static String my_pwd = "bloomz999" ;
	
	// Invite 20 parents to the class by copy pasting emails - validate if the invited emails show in invited section
	@Test(groups = { "android", "ios", "web", "P0Pass_4" })
	public void P0Pass_4_testInvite20ParentViaCopyPaste() throws InterruptedException, IOException {
		System.out.println("P0Pass_4_testInvite20ParentViaCopyPaste");
		String sEmail = "testparent1@test.com,testparent2@test.com,testparent3@test.com,testparent4@test.com,testparent5@test.com,"
				+ "testparent6@test.com,testparent7@test.com,testparent8@test.com,testparent9@test.com,testparent10@test.com,"
				+ "testparent11@test.com,testparent12@test.com,testparent13@test.com,testparent14@test.com,testparent15@test.com,"
				+ "testparent16@test.com,testparent17@test.com,testparent18@test.com,testparent19@test.com,testparent20@test.com";
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectParentRole().selectEmailsManually().clickEmailId().copyPaste(sEmail)
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().thenVerifyTheInviteMembers("Invited (21)").clickOnMembersManageButton()
		.enterEmailSearchMembers("testparent").clickOnSelectAll().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Members removed from this group.").clickOnDoneButton();
	}
	
	// Invite another teacher to the class
	@Test(groups = { "android", "ios", "web", "P0Pass_5" })
	public void P0Pass_5_testInviteTeacherToClass() {
		System.out.println("P0Pass_5_testInviteTeacherToClass");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectTeacherRole().selectEmailsManually().enterEmailId("testteacher@test.com")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers("testteacher@test.com")
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
	}
		
	// Invite class admin to the class
	@Test(groups = { "android", "ios", "web", "P0Pass_6" })
	public void P0Pass_6_testInviteClassAdminToClass() {
		System.out.println("P0Pass_6_testInviteClassAdminToClass");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectClassAdminRole().selectEmailsManually().enterEmailId("testclassadmin@test.com")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers("testclassadmin@test.com")
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
	}
	

	// Invite room parent to the class
	@Test(groups = { "android", "ios", "web", "P0Pass_7" })
	public void P0Pass_7_testInviteClassAdminToClass() {
		System.out.println("P0Pass_7_testInviteRoomParentToClass");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectRoomParentRole().selectEmailsManually().enterEmailId("testroomparent@test.com")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers("testroomparent@test.com")
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
	}
	
	
	// Invite parent to the class and edit the role to room parent
	@Test(groups = { "android", "ios", "web", "P0Pass_8" })
	public void P0Pass_8_testInviteParentAndEditRole() {
		System.out.println("P0Pass_8_testInviteParentAndEditRole");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectParentRole().selectEmailsManually().enterEmailId("testparent@test.com")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers("testparent@test.com")
		.selectMembersEmailId().clickOnEditRole();
		
		InvitationGroupPage.getInvitationGroupPage(browser).selectRoomParentRole();
		MembersTabPage.getMembersTabPage(browser).clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member update.").thenVerifyRoomParentExists().enterEmailSearchMembers("testparent@test.com")
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
	}
	
}