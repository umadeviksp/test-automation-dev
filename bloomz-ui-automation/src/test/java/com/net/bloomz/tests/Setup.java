package com.net.bloomz.tests;


import org.testng.annotations.Test;
import com.net.bloomz.pages.LandingPage;


public class Setup extends BaseTest {
	
	// Pre-requisite testcase to run BVT cases
	// Create alpha teacher account and Class Alpha Teacher
	@Test(groups = { "android", "ios", "web", "Setup_1" })
	public void setup_1_CreateTestAccount() {
		String sEmail = "alphateacher@test.com";
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("Alpha").enterLastName("Teacher")
		.enterEmailId(sEmail).enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("Alpha Teacher")
		.thenVerifyWelcomeScreen().thenVerifyEmailAddress(sEmail);
		//clickOnSettingButton().clickOnSignOutButton();
	}
	
	// Create a class with BP ON
	@Test(groups = { "android", "ios", "web", "Setup_2" })
	public void setup_2_CreateTestClass() {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName("Alpha Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
		
	// Create an account with BP off
	@Test(groups = { "android", "ios", "web", "Setup_3" })
	public void setup_3_CreateTestClassBPOFF() {
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName("BPOff Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickBehaviorManagementButton().clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
	
	
	//Add a contact
	@Test(groups = { "android", "ios", "web", "Setup_4" })
	public void setup_4_testAddContact() throws Exception {
		System.out.println("setup_5_testAddContact");
		String sEmail = "alphateacher@test.com";

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(sEmail)
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectTeacherRole().selectEmailsManually().enterEmailId("sample@sample.com")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!");
	}
	
	//Add a student/child
	@Test(groups = { "android", "ios", "web", "Setup_5" })
	public void setup_5_testAddChild() throws Exception {
		System.out.println("setup_5_testAddChild");
		String sEmail = "alphateacher@test.com";

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(sEmail)
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnAddStudents().enterStudentName().clickOnAddStudentButton().clickOnDoneButton();
	}
	
}
