package com.net.bloomz.tests;


import org.testng.annotations.Test;
import com.net.bloomz.pages.LandingPage;


public class Setup extends BaseTest {

	static String my_email = "alphateacher1@test.com";
	static String my_pwd = "bloomz999" ;
	
	// Pre-requisite testcase to run BVT cases
	// Create alpha teacher account and Class Alpha Teacher
	@Test(groups = { "android", "ios", "web", "Setup_1" })
	public void setup_1_CreateTestAccount() {
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("Alpha").enterLastName("Teacher")
		.enterEmailId(my_email).enterPassword(my_pwd)
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("Alpha Teacher")
		.thenVerifyWelcomeScreen().thenVerifyEmailAddress(my_email);
		//clickOnSettingButton().clickOnSignOutButton();
	}
	
	// Create a class with BP ON
	@Test(groups = { "android", "ios", "web", "Setup_2" })
	public void setup_2_CreateTestClass() {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnCreateClass().enterClassName("Alpha Class")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
		
	// Create an account with BP off
	@Test(groups = { "android", "ios", "web", "Setup_3" })
	public void setup_3_CreateTestClassBPOFF() {
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().clickOnCreateClass().enterClassName("BPOff Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickBehaviorManagementButton().clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
	
	
	//Add a contact
	@Test(groups = { "android", "ios", "web", "Setup_4" })
	public void setup_4_testAddContact() throws Exception {
		System.out.println("setup_5_testAddContact");

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectTeacherRole().selectEmailsManually().enterEmailId("sample@sample.com")
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!");
	}
	
	//Add a student/child
	@Test(groups = { "android", "ios", "web", "Setup_5" })
	public void setup_5_testAddChild() throws Exception {
		System.out.println("setup_5_testAddChild");

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
		.enterPasswordOnTextBox(my_pwd).clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnAddStudents().enterStudentName().clickOnAddStudentButton().clickOnDoneButton();
	}
	
}



