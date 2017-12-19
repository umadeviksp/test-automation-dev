package com.net.bloomz.tests;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateAnnouncementInClassPage;
import com.net.bloomz.pages.CreatePostInClassPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.utils.Config;

public class P0Pass_TeacherCommunication extends BaseTest {	
	
	static String my_email = "alphateacher1@test.com";
	static String my_pwd = "bloomz999" ;
	
	// Make Post with No Comments Enabled
	@Test(groups = { "android", "ios", "web", "P0Pass_01" })
	public void P0Pass_01_testCreatePostWithNoComments() throws Exception {
		System.out.println("P0Pass_01_testCreatePostWithNoComments");
		String sPostTitle = "test_New Post with no comments" + getTimeStamp().replaceAll("-", "_");
	
		//Path currentRelativePath = Paths.get("");
		//String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("my_email")
		.enterPasswordOnTextBox("my_pwd").clickOnSignInButton().clickOnAClassName().createNewPost()
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
	
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("my_email")
		.enterPasswordOnTextBox("my_pwd").clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle(sPostTitle).enterGeneralUpdate("New post scheduled").clickOnScheduleButton()
		.clearScheduleDate().enterScheduleDate(0, 0, 1).clickStartTime()
		.clearStartTime().enterStartTime("10:00 AM").clickOnSchedulePost().thenVerifyThatSchedulePostWasSuccessful()
		.clickOnScheduledPost().clickOnDeleteScheduledPost().clickOnConfirmDeletePost();
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
	
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("my_email")
		.enterPasswordOnTextBox("my_pwd").clickOnSignInButton().clickOnAClassName().createNewPost()
		.enterTitle(sPostTitle).enterGeneralUpdate("New post with attachment").clickOnFileAttachPost();
		ClassPage.getClassPage(browser).uploadImage(sUploadapp);
		CreatePostInClassPage.getCreatePostInClassPage(browser).clickOnPostButton();
		//HomePage.getHomePage(browser).thenVerifyThatUploadWasSuccessful("Posted successfully")
		//.clickOnBackButton();	
	}
	
	// Create Announcement in a class with pictures
	@Test(groups = { "android", "ios", "web", "P0Pass_09" })
	public void P0Pass_09_testCreateAnnouncementWithPicture() throws Exception {
		System.out.println("P0Pass_09_testCreateAnnouncementWithPicture");
		Path currentRelativePath = Paths.get("");
		String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("my_email")
		.enterPasswordOnTextBox("my_pwd").clickOnSignInButton().clickOnAClassName()
		.createNewAnnouncement()
		.enterTitle("test announcement").enterGeneralUpdate("random text for verifying announcement feature with picture");
		CreatePostInClassPage.getCreatePostInClassPage(browser).uploadImage(testImageFilePath);
		CreateAnnouncementInClassPage.getCreateAnnouncementInClassPage(browser).clickOnPostButton().thenVerifyAnnouncements("(1)").
		clickOnAnnouncement().clickOnAnnouncementOptions()
		.clickOnAnnouncementDeleteButton().clickOnConfirmAnnouncementDeleteButton();
	}
	
	// Make posts to the parents individually with pictures
	@Test(groups = { "android", "ios", "web", "P0Pass_10" })
	public void P0Pass_10_testMakePostToParents() throws Exception {
		System.out.println("P0Pass_10_testMakePostToParents");
		Path currentRelativePath = Paths.get("");
		String testImageFilePath = currentRelativePath.toAbsolutePath().toString() + Config.getConfigData("test_image_location");
		String sEmailID = "test_addParent" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		//Pre-requisite to add parent to the class
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("my_email")
		.enterPasswordOnTextBox("my_pwd").clickOnSignInButton().thenVerifyCreateButtonShouldBeDisplayed()
		.clickOnInviteButton().selectAnyOneClass().selectParentRole().selectEmailsManually().enterEmailId(sEmailID)
		.clickOnEmailSendButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyThatPostWasSuccessful("Member(s) Added Successfully!")
		.clickCreateButton().clickOnPostButton().clickOnPostToField().clickOnSeeMembersOfAClass().clickOnSearchString()
		.enterEmailID(sEmailID).selectEmailID().ClickOnDoneLocator().clickOnToDoneButton().enterTitle("Make posts to the parents individually with pictures")
		.enterGeneralUpdate("Make posts to the parents individually with pictures").uploadImage(testImageFilePath).clickOnPostButton()
		.thenVerifyThatPostWasSuccessful().clickOnBackButton();
		
		HomePage.getHomePage(browser).clickOnAClassName().clickOnMembersTab().clickOnMembersManageButton().clickOnMembersButton().enterEmailSearchMembers(sEmailID)
		.selectMembersEmailId().clickOnRemoveMembersEmailId().clickOnConfirmRemoveEmailId()
		.thenVerifyTheToastMessage("Successful! Member removed from this group.").clickOnDoneButton();
	}
		
	// Add files/ insert pictures, input hyper links to the class Info section
	@Test(groups = { "android", "ios", "web", "P0Pass_13" })
	public void P0Pass_13_testUploadDocumentsToClass() throws Exception {
		System.out.println("P0Pass_13_testUploadDocumentsToClass");
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
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("my_email")
		.enterPasswordOnTextBox("my_pwd").clickOnSignInButton().clickOnAClassName().clickOnMediaTab().clickOnDocumentsTab()
		.clickOnUploadDocuments().enterTitleUploadDocuments("Upload documents to a class")
		.enterDescriptionUploadDocuments("upload documents to a class")
		.clickOnAttachFiles().uploadFile(sUploadapp).clickOnSave().thenVerifyThatEventWasSuccessful("Successfuly saved the information");		
	}
		
}