package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.net.bloomz.pages.CreateMessagePage;
import com.net.bloomz.pages.LandingPage;


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

	
	//Feature Message To - Row 69, message to a personal connection/my contacts
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToAConnection() throws Exception {
		String sinputMessage = "Message to a contact_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts ().clickOnToFirstContact ()
		.clickOnMessageDone ().inputOnMessageField(sinputMessage).clickOnSendButton().clickOnBackButton()
		.clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteMessageButton();
	}
	
	
	//Feature Message To - Row 70, message to a multiple connections/my contacts
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToMultipleConnection() throws Exception {
		String sinputMessage = "Message to a contact_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts ().clickOnMultipleContacts ()
		.clickOnMessageDone ().inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnBackButton()
		.clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton()
		.clickOnDeleteButton();
	}
	
	
	//Feature Message To - Row 72, message to a class
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToAClass() throws Exception {
		String sinputMessage = "Message to a class_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyClasses().clickOnToFirstClass().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnSendToEveryoneButton()
		.clickOnBackButton().clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	
	
	//Feature Message To - Row 74, message to a class
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToAllClasses() throws Exception {
		String sinputMessage = "Message to all classes_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyClasses().clickOnSelectAllClasses().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnReplyAllButton().clickOnSendToEveryoneButton()
		.clickOnBackButton().clickOnFirstMessageInTray ();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage,CreateMessagePage.getCreateMessagePage(browser).getFirstMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	
	
	//Feature Message To - Row 76, message to an existing thread
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreateMessageToExistingThread() throws Exception {
		String sinputMessage = "Message to a new thread_" + getTimeStamp();
		String sinputMessage1 = "Message to an existing thread_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts().clickOnToFirstContact ().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnSendButton().clickOnBackButton()
		.clickOnFirstMessageInTray ().inputOnMessageField(sinputMessage1).clickOnSendButton()
		.clickOnBackButton ().clickOnFirstMessageInTray();
		CreateMessagePage.getCreateMessagePage(browser).thenVerifyMessages(sinputMessage1,CreateMessagePage.getCreateMessagePage(browser).getLastMessageLocator());
		CreateMessagePage.getCreateMessagePage(browser).clickOnBackButton()
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	
	
	//Feature Message To - Row 77, Latest Message should bubble to the top
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCheckLatestMessageToTheTop() throws Exception {
		String sinputMessage = "Check Latest Message bubbles to the top_" + getTimeStamp();
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMyMessageButton ()
		.clickOnMessageToField ().clickOnMyContacts().clickOnToFirstContact ().clickOnMessageDone ()
		.inputOnMessageField(sinputMessage).clickOnSendButton().clickOnBackButton()
		.ReadkOnFirstMessageInTray(sinputMessage)
		.clickOnFirstMessageInTray().clickOnOptionsButton().clickOnDeleteMessageButton().clickOnDeleteButton();
	}
	
	
}