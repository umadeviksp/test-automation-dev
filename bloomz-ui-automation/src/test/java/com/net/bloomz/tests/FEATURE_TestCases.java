package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.CreatePostInClassPage;
import com.net.bloomz.pages.CreatePostToMyContactsPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.utils.Config;

public class FEATURE_TestCases extends BaseTest {

	@Test(groups = { "android", "BVT0101" })
	public void testAppInstallation() {
		Assert.assertTrue(((AndroidDriver<?>) browser.getWebDriver()).isAppInstalled("net.bloomz"),
				"App is not Installed");
	}
	
	@Test(groups = { "android", "ios", "BVT0201" })
	public void testAppLauch() {
		LandingPage.getLandingPage(browser).thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}

	
	
	//Feature Posts - Row 59, post to a class with picture
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostToAClassWithPictures() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnCreatePostButton()
		.clickOnPostToField().clickOnToFirstClass().clickOnToDoneButton()
		.enterTitle("test - post to a class").enterGeneralUpdate("verify post to a class feature with picture")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton();
	}
		
	
	//Feature Posts - Row 60, post to all class with picture
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostToAllClasswithpicture() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnCreatePostButton()
		.clickOnPostToField().clickOnSelectAll ().clickOnToDoneButton()
		.enterTitle("test - post to all class").enterGeneralUpdate("verify post to all class feature with picture")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton();
	}
		
	
	//Feature Posts - Row 56, post to a contact with picture
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostToAContactWithPictures() throws Exception {
	String testImageFilePath = Config.getConfigData("test_image_location");
	LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
	.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnCreatePostButton()
	.clickOnPostToField().clickOnMyContacts ().clickOnToFirstContact ()
	.clickOnToDoneButton().enterTitle("test - post to a contact").enterGeneralUpdate("verify post to a contact feature with picture")
	.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
	.clickOnBackButton();
	}
		
	
	//Feature Posts - Row 55, post to a multiple contacts with picture
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostToAllContactswithPictures() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickCreateButton().clickOnCreatePostButton()
		.clickOnPostToField().clickOnMyContacts (). clickOnMultipleContacts (). clickOnToDoneButton()
		.enterTitle("test - post to multiple contacts").enterGeneralUpdate("verify post to multiple contacts feature with pictures")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton();
	}
		
	
	//Feature Posts - Row 65, post in a class with picture and like the post
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostInClassWithPicturesAndLike() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		// .clickOnPostToField().clickOnToFirstClass().clickOnToDoneButton()
		.enterTitle("test - post to a class and like the post").enterGeneralUpdate("verify post to a class and like the post")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful()
		.clickOnBackButton().clickOnLikeButton().thenVerifyThatLikeWasSuccessful("1 Like 0 Comment");
	}
		
	
	//Feature Posts - Row 66, post in a class with picture and comment the post
	@Test(groups = { "android", "ios", "web", "BVT0901" })
	public void testCreatePostInClassWithPicturesAndComment() throws Exception {
		String testImageFilePath = Config.getConfigData("test_image_location");
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		// .clickOnPostToField().clickOnToFirstClass().clickOnToDoneButton()
		.enterTitle("test - post to a class and comment the post").enterGeneralUpdate("verify post to a class and comment the post")
		.uploadImage(testImageFilePath).clickOnPostButton().thenVerifyThatPostWasSuccessful().enterPostComment()
		.clickOnSendPostComment().clickOnBackButton().thenVerifyThatLikeWasSuccessful("0 Like 1 Comment");
	}
	
	

}