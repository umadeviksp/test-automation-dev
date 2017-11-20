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

public class Setup extends BaseTest {
		
	// Pre-requisite testcase to run BVT cases
	// Create alpha teacher account and Class Alpha Teacher
	@Test(groups = { "android", "ios", "web", "Setup" })
	public void a_CreateTestAccount() {

		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnClassGroup()
		.enterFirstName("Alpha").enterLastName("Teacher")
		.enterEmailId("alphateacher@test.com").enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("Alpha Teacher")
		.thenVerifyWelcomeScreen().clickOnSettingButton().clickOnSignOutButton();
	}
	
	// Create a class with BP ON
	@Test(groups = { "android", "ios", "web", "Setup" })
	public void a_CreateTestClass() {

		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName("Alpha Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
		
	// Create an account with BP off
	@Test(groups = { "android", "ios", "web", "Setup" })
	public void a_CreateTestClassBPOFF() {
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnCreateClass().enterClassName("BPOff Teacher")
		.clickOnchooseSchoolButtonLocator().enterSchoolSearch("1050 ADAIR CO. HIGH").clickOnSchoolCommunity()
		.clickBehaviorManagementButton().clickOnSaveButtonLocator().clickOnSettingButton().clickOnSignOutButton();
	}
	
	
}
