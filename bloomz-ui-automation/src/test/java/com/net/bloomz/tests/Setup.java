package com.net.bloomz.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.appium.pagefactory.framework.exception.IWebDriverException;
import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateEventInClassPage;
import com.net.bloomz.pages.CreateMessagePage;
import com.net.bloomz.pages.EditMyProfilePage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.utils.Config;

public class Setup extends BaseTest {
	/*	
	// Pre-requisite testcase to run BVT cases
	// Create alpha teacher account and Class Alpha Teacher
	@Test(groups = { "android", "ios", "web", "Setup" })
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
	@Test(groups = { "android", "ios", "web", "Setup" })
	public void setup_2_CreateTestClass() {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName("Alpha Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
		
	// Create an account with BP off
	@Test(groups = { "android", "ios", "web", "Setup" })
	public void setup_3_CreateTestClassBPOFF() {
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName("BPOff Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickBehaviorManagementButton().clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
	
	
	@Test(groups = { "android", "ios", "web", "BVT0301" })
	public void BVT_03_testSignInWithValidInputs() throws Exception {
		System.out.println("BVT_03_testSignInWithValidInputs");
		String sEmail = "alphateacher@test.com";

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(sEmail)
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.thenVerifyProfileName("Alpha Teacher").thenVerifyEmailAddress(sEmail);
	}
	*/	
}