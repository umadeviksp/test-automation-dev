package com.net.bloomz.tests;

import org.testng.annotations.Test;

import com.net.bloomz.pages.GroupSettingPage;
import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.SignInPage;

public class P0Pass_TeacherProfileSetup extends BaseTest {
	
	
	// Teacher - profile setup
	// Edit name
	@Test(groups = { "android", "ios", "web", "P0Pass_01" })
	public void P0Pass_1_ProfileSetupAsATeacher_EditName() throws Exception {
		System.out.println("P0Pass_1_ProfileSetupAsATeacher_EditName");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton().enterFirstName("Alpha edit")
		.enterLastName("Teacher edit").clickOnSaveButton().thenVerifyThatUploadWasSuccessful("Profile updated successfully")
		.clickOnGoBackButton().thenVerifyProfileName("Alpha edit Teacher edit")
		.clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton().enterFirstName("Alpha")
		.enterLastName("Teacher").clickOnSaveButton().thenVerifyThatUploadWasSuccessful("Profile updated successfully")
		.clickOnGoBackButton().thenVerifyProfileName("Alpha Teacher");
	
	}
	
	
	// Invite Spouse
	@Test(groups = { "android", "ios", "web", "P0Pass_02" })
	public void P0Pass_2_ProfileSetupAsATeacher_InviteSpouse() throws Exception {
		System.out.println("P0Pass_2_ProfileSetupAsATeacher_InviteSpouse");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().clickOnInviteSpouseButton().enterInviteSpouseEmail("test@test.com")
		.clickOnDoneButton().thenVerifyTheToastMessage("Spouse Invited Successfully!").clickOnCancelButton()
		.clickOnSettingButton().clickOnMyProfileButton().clickOnSpouseInvited().clickOnYesButton();
		
		InvitationGroupPage.getInvitationGroupPage(browser).thenVerifyTheToastMessage("Invitation Cancelled Successfully!");
	
	}
	
	
	// Sign In with Invalid email / password
	@Test(groups = { "android", "ios", "web", "P0Pass_04" })
	public void P0Pass_4_Teacher_InvalidLogin() throws Exception {
		System.out.println("P0Pass_4_Teacher_InvalidLogin");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz").clickOnSignInButton();
		
		SignInPage.getSignInPage(browser).thenVerifyTheToastMessage("Invalid username or password");	
	}
	
	// Forgot Password
	@Test(groups = { "android", "ios", "web", "P0Pass_05" })
	public void P0Pass_5_Teacher_ForgotPassword() throws Exception {
		System.out.println("P0Pass_5_Teacher_ForgotPassword");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton();
		SignInPage.getSignInPage(browser).clickOnForgotPassword().enterEmailName("test@test.com").clickOnRequestNewPassword()
		.thenVerifyTheToastMessage("Please check your email for your temporary password. In some cases, it may take upto 15 minutes for the email to show up.");
	}
	
	
	// Change Email address	
	@Test(groups = { "android", "ios", "web", "P0Pass_06" })
	public void P0Pass_6_Teacher_EditEmailAddress() throws Exception {
		System.out.println("P0Pass_6_Teacher_EditEmailAddress");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateachernobp@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnSettingButton().clickOnAccountSettingsButton()
		.clickOnChangeEmailAddressButton().enterNewEmailAddress("alphateachernobp_edit@test.com").enterPassword("bloomz999")
		.clickOnSaveButton().clickOnSaveSignOutButton();
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateachernobp_edit@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
		.clickOnAccountSettingsButton().clickOnChangeEmailAddressButton().enterNewEmailAddress("alphateachernobp@test.com")
		.enterPassword("bloomz999").clickOnSaveButton().clickOnSaveSignOutButton();
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateachernobp@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed().clickOnSettingButton()
		.clickOnSignOutButton();		
	}
	
	// Set the theme for the class - from SETTINGS page
	@Test(groups = { "android", "ios", "web", "P0Pass_07" })
	public void P0Pass_7_ChangeTheThemeClass() throws Exception {
		System.out.println("P0Pass_7_ChangeTheThemeClass");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnGroupSettings()
		.clickOnEditSettings().changeTheTheme("#00b530").clickOnDoneButton().getClassThemeColor("rgba(0, 181, 48, 1)")
		.clickOnGroupSettings().clickOnEditSettings().changeTheTheme("#00b1db").clickOnDoneButton()
		.getClassThemeColor("rgba(0, 177, 219, 1)");
	}
	

}