package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.CalendarSettingsPage;
import com.net.bloomz.pages.ChangeEmailAddressPage;
import com.net.bloomz.pages.ChangePasswordPage;
import com.net.bloomz.pages.ChildAddActivitiesPage;
import com.net.bloomz.pages.ChildAddSchoolPage;
import com.net.bloomz.pages.EditMyProfilePage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.pages.NotificationsPage;
import com.net.bloomz.pages.PreferredLanguagePage;
import com.net.bloomz.pages.ProfileAddChildPage;
import com.net.bloomz.pages.ProfileAddSpousePage;
import com.net.bloomz.pages.ProfilePicOptionsPage;
import com.net.bloomz.pages.ProfileSettingsPage;
import com.net.bloomz.pages.ProfileTimezonePage;
import com.net.bloomz.pages.StudentSignInPage;
import com.net.bloomz.utils.Config;

public class FEATURE_Message_TestCases extends BaseTest {

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

	
	
	/*
	//Feature Message To - Row 69, message to a personal connection/my contacts
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToAConnection() throws Exception {
		String sinputMessage = "Message to a contact_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts ().clickOnToFirstContact ()
		.clickOnMessageDone ().inputOnMessageField(sinputMessage).clickOnSendButton().clickOnBackButton()
		.clickOnFirstMessageInTray ().thenVerifyMessages(sinputMessage).clickOnBackButton ()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteMessageButton();
	}*/
	
	/*
	//Feature Message To - Row 70, message to a multiple connections/my contacts
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToMultipleConnection() throws Exception {
		String sinputMessage = "Message to a contact_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts ().clickOnMultipleContacts ()
		.clickOnMessageDone ().inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnBackButton()
		.clickOnFirstMessageInTray ().thenVerifyMessages(sinputMessage).clickOnBackButton ()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton()
		.clickOnDeleteButton();
	}*/
	
	/*//Feature Message To - Row 72, message to a class
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToAClass() throws Exception {
		String sinputMessage = "Message to a class_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyClasses().clickOnToFirstClass().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnSendToEveryoneButton()
		.clickOnBackButton().clickOnFirstMessageInTray ().thenVerifyMessages(sinputMessage).clickOnBackButton ()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}*/
	
	//Feature Message To - Row 74, message to a class
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToAllClasses() throws Exception {
		String sinputMessage = "Message to all classes_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnSelectAllClasses().clickOnToFirstClass().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnSendToEveryoneButton()
		.clickOnBackButton().clickOnFirstMessageInTray ().thenVerifyMessages(sinputMessage).clickOnBackButton ()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	
	
	

}