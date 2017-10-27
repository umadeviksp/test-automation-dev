package com.net.bloomz.tests;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateAnnouncementInClassPage;
import com.net.bloomz.pages.CreatePostInClassPage;
import com.net.bloomz.pages.CreatePostToMyContactsPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.MembersTabPage;
import com.net.bloomz.utils.Config;

public class P0Pass_TeacherCommunication extends BaseTest {	
	
	
	// Make Post with No Comments Enabled
	@Test(groups = { "android", "ios", "web", "P0Pass_01" })
	public void P0Pass_01_testCreatePostWithNoComments() throws Exception {
		System.out.println("P0Pass_01_testCreatePostWithNoComments");
		String sPostTitle = "test_New Post with no comments" + getTimeStamp().replaceAll("-", "_");
	
		//Path currentRelativePath = Paths.get("");
		//String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle(sPostTitle).enterGeneralUpdate("New post with no comments enabled").clickOnCommentsButton();
		HomePage.getHomePage(browser).thenVerifyThatPostWasSuccessful("Recipients will NOT be able to comment on this post");
		CreatePostInClassPage.getCreatePostInClassPage(browser).clickOnPostButton();
		HomePage.getHomePage(browser).thenVerifyThatPostWasSuccessful("Posted Successfully");
		//.clickOnBackButton();
		//clickOnUpdatesTab();
//		ClassPage.getClassPage(browser).clickOnPostNoComments().readPostNoCommentsTitle(sPostTitle).readNoCommentsTitle("Comments are disabled");
//		CreatePostInClassPage.getCreatePostInClassPage(browser).clickOnPostOptions().clickOnDeletePost().clickOnConfirmDeletePost();

	}
	
	// Make a scheduled Post
	@Test(groups = { "android", "ios", "web", "P0Pass_02" })
	public void P0Pass_02_testCreatePostWithSchedule() throws Exception {
		System.out.println("P0Pass_02_testCreatePostWithSchedule");
		String sPostTitle = "test_New Post with schedule" + getTimeStamp().replaceAll("-", "_");
	
		//Path currentRelativePath = Paths.get("");
		//String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle(sPostTitle).enterGeneralUpdate("New post scheduled").clickOnScheduleButton()
		.clearScheduleDate().enterScheduleDate(0, 0, 1).clickStartTime()
		.clearStartTime().enterStartTime("10:00 AM").clickOnSchedulePost().thenVerifyThatSchedulePostWasSuccessful()
		.clickOnScheduledPost().clickOnDeleteScheduledPost();		
	}
	
	// Make a scheduled Post
	@Test(groups = { "android", "ios", "web", "P0Pass_03" })
	public void P0Pass_03_testCreatePostWithAttachment() throws Exception {
		System.out.println("P0Pass_03_testCreatePostWithAttachment");
		String sPostTitle = "test_New Post with attachment" + getTimeStamp().replaceAll("-", "_");
	
		Path currentRelativePath = Paths.get("");
		String sCurrentPath = currentRelativePath.toAbsolutePath().toString() ;
		String sUploadapp = sCurrentPath + Config.getConfigData("test_cover_image");
		if (sCurrentPath.contains("/"))
		{
			System.out.println ("this is not windows") ;
		}
		else
		{
			sUploadapp = sUploadapp.replaceAll("/","\\\\");
			System.out.println ("this is windows") ;
		}
		System.out.println(sUploadapp);
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle(sPostTitle).enterGeneralUpdate("New post with attachment").clickOnFileAttachPost();
		ClassPage.getClassPage(browser).uploadImage(sUploadapp);
		CreatePostInClassPage.getCreatePostInClassPage(browser).clickOnPostButton();
		//HomePage.getHomePage(browser).thenVerifyThatUploadWasSuccessful("Posted successfully")
		//.clickOnBackButton();	
	}
	
	// Create Announcement in a class with pictures
	@Test(groups = { "android", "ios", "web", "P0Pass_07" })
	public void P0Pass_07_testCreateAnnouncementWithPicture() throws Exception {
		System.out.println("P0Pass_07_testCreateAnnouncementWithPicture");
		Path currentRelativePath = Paths.get("");
		String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName()
		.createNewAnnouncement()
		.enterTitle("test announcement").enterGeneralUpdate("random text for verifying announcement feature with picture");
		CreatePostInClassPage.getCreatePostInClassPage(browser).uploadImage(testImageFilePath);
		CreateAnnouncementInClassPage.getCreateAnnouncementInClassPage(browser).clickOnPostButton().thenVerifyAnnouncements("(1)").
		clickOnAnnouncement().clickOnAnnouncementOptions()
		.clickOnAnnouncementDeleteButton().clickOnConfirmAnnouncementDeleteButton();
	}
	
	
	
}