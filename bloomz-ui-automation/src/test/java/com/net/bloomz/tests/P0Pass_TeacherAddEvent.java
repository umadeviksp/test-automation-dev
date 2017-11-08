package com.net.bloomz.tests;

//import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;



//import com.net.bloomz.pages.CreateEventInClassPage;
//import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.LandingPage;
//import com.net.bloomz.pages.MembersTabPage;
import com.net.bloomz.utils.Config;

public class P0Pass_TeacherAddEvent extends BaseTest {	
	
	
	// Add event to the class calendar - notify all
	@Test(groups = { "android", "ios", "web", "P0Pass_01" })
	public void P0Pass_01_createEventWithNotifyAll() throws Exception {
		System.out.println("P0Pass_01_createEventWithNotifyAll");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar - notify all")
		.clickSaveButton().clickNotifyAllMembersButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	// Add event to the class calendar - Do not notify all
	@Test(groups = { "android", "ios", "web", "P0Pass_02" })
	public void P0Pass_02_createEventWithoutNotifyAll() throws Exception {
		System.out.println("P0Pass_02_createEventWithoutNotifyAll");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar - Do not notify all")
		.clickSaveButton().clickDoNotNotifyAllMembersButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	// Add event to the class calendar and invite the entire class
	@Test(groups = { "android", "ios", "web", "P0Pass_04" })
	public void P0Pass_04_createEventInviteAllClass() throws Exception {
		System.out.println("P0Pass_04_createEventInviteAllClass");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar and invite the entire class")
		.clickInviteButton().clickInviteAllButton().clickDoneButton().clickSaveButton().clickOnOKButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	
	//Invite more people to an existing PTC event and invite the rest of the class
	@Test(groups = { "android", "ios", "web", "P0Pass_11" })
	public void P0Pass_11_editPTCEventWithInvitees() throws Exception {
		System.out.println("P0Pass_11_editPTCEventWithInvitees");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnCalendarTab().clickOnPTCvent()
		.clickOnOptionsEditEvent().clickOnInviteMorePeople().clickOnAllMembers().clickOnDoneButton().clickOnSendButton()
		.thenVerifyEmailUpdate();
	}	
	
	
	//Create the Events using different signatures of the Teacher in a Class
	@Test(groups = { "android", "ios", "web", "P0Pass_12" })
	public void P0Pass_12_CreateEventWithDiffSignature() throws Exception {
		System.out.println("P0Pass_12_CreateEventWithDiffSignature");
		String sTitle = "test_event" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnAClassName().clickOnUpdatesTab()
		.createNewEvent().enterTitle(sTitle).enterLocation("random location").enterNotes("Add event to the class calendar - different signature")
		.pickSignature().selectSignature().clickSaveButton().clickNotifyAllMembersButton()
		.thenVerifyThatEventWasSuccessful("Event successfully added to calendar!");
	}	
	
	
	
	// Create an Album in the class and add photos to the album
	// Delete a photo from an album created by the teacher herself
	@Test(groups = { "android", "ios", "web", "P0Pass_13" })
	public void P0Pass_13_CreateAlbumAddDeletePhotos() throws Exception {
		System.out.println("P0Pass_13_CreateAlbumAddPhotos");
		String sTitle = "test_" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
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
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMediaTab().clickOnAlbumsTab().clickOnCreateAlbumTab()
		.enterAlbumTitle(sTitle).clickOnPickClassGroup().selectClass().clickOnDoneButton().clickOnCreateButton()
		.thenVerifyThatEventWasSuccessful("Album created successfully.").clickOnAddPhotoButton()
		.uploadImage(sUploadapp).thenVerifyThatEventWasSuccessful("1 photo added.").clickOnPhoto().clickOnOptionsPhoto()
		.clickOnSetAsAlbumCover().thenVerifyThatEventWasSuccessful("Updated cover photo successfully").clickOnOptionsPhoto()
		.clickOnRemovePhoto().thenVerifyThatEventWasSuccessful("Photo deleted successfully").clickOnBackButton().clickOnAlbumOptions()
		.clickOnDeleteAlbum();
	}
	
	
	//Verification to be added
	// Delete a photo from All photos
	@Test(groups = { "android", "ios", "web", "P0Pass_14" })
	public void P0Pass_14_DeletePhotosFromAllPhotos() throws Exception {
		System.out.println("P0Pass_14_DeletePhotosFromAllPhotos");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMediaTab().clickOnPhotosTab()
		.clickOnPhotosTabPhoto().clickOnOptionsPhoto().clickOnPhotosTabDeletePhoto();
		//.clickOnPhotosTabDownloadPhoto();
	}
	
	// Add photos to an album created by the parent in the class
	@Test(groups = { "android", "ios", "web", "P0Pass_15" })
	public void P0Pass_15_CreateAlbumAddDeletePhotos_Parent() throws Exception {
		System.out.println("P0Pass_15_CreateAlbumAddDeletePhotos_Parent");
		String sTitle = "test_" + getTimeStamp().replaceAll("-", "_");
		System.out.println(sTitle);
		
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
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alpharoomparent@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMediaTab().clickOnAlbumsTab().clickOnCreateAlbumTab()
		.enterAlbumTitle(sTitle).clickOnPickClassGroup().SelectClassParent().clickOnDoneButton().clickOnCreateButton()
		.thenVerifyThatEventWasSuccessful("Album created successfully.").clickOnAddPhotoButton()
		.uploadImage(sUploadapp).thenVerifyThatEventWasSuccessful("1 photo added.").clickOnPhoto().clickOnOptionsPhoto()
		.clickOnRemovePhoto().thenVerifyThatEventWasSuccessful("Photo deleted successfully").clickOnBackButton().clickOnAlbumOptionsParent()
		.clickOnDeleteAlbum();
	}
	
	
	//Verification to be added
	// Download a photo from All photos
	@Test(groups = { "android", "ios", "web", "P0Pass_16" })
	public void P0Pass_16_DownloadPhotosFromAllPhotos() throws Exception {
		System.out.println("P0Pass_16_DownloadPhotosFromAllPhotos");
		
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
		.enterPasswordOnTextBox("bloomz999").clickOnSignInButton().clickOnMediaTab().clickOnPhotosTab()
		.clickOnPhotosTabPhoto().clickOnOptionsPhoto().clickOnPhotosTabDownloadPhoto();
	}
	
}