package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.pages.ChildAddActivitiesPage;
import com.net.bloomz.pages.ChildAddSchoolPage;
import com.net.bloomz.pages.EditMyProfilePage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.pages.ProfileAddSpousePage;
import com.net.bloomz.pages.ProfileAddChildPage;
import com.net.bloomz.pages.ProfilePicOptionsPage;
import com.net.bloomz.pages.StudentSignInPage;

public class BV_Feature_TestCases extends BaseTest {

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

		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503" })
		public void a_testCancelOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
					.enterPasswordOnTextBox("bloomz999").clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnCancelButton().clickOnSettingButton();

		}
		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503" })
		public void testMyProfileOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox("alphateacher@test.com")
					.enterPasswordOnTextBox("bloomz999").clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton();

		}
		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503" })
		public void testAccountSettingsOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnAccountSettingsButton().clickOnSignOutButton().clickOnCancelButton();

		}

		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503", "Profile" })
		public void testCancelOnMyProfileOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnGoBackButton() ;
			
		}

		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503", "Profile" })
		public void testEditOnMyProfileOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton() ;
			
		}
		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503", "Profile" })
		public void testChoosePhotoOnMyProfileOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton().clickOnChoosePhotoButton() ;
			
		}
		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503", "Profile" })
		public void testChoosePhotoOnMyProfileandCancelOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton();
			MyProfilePage.getMyProfilePage(browser).clickOnEditButton().clickOnChoosePhotoButton() ;
			ProfilePicOptionsPage.getProfilePicOptionsPage(browser).clickOnCancelButton() ;
			EditMyProfilePage.getEditMyProfilePage(browser).clickOnChoosePhotoButton() ;
			ProfilePicOptionsPage.getProfilePicOptionsPage(browser).clickOnUploadPhotoButton() ;
			
		}
		@Test(groups = { "android", "ios", "web", "BVT0503" })
		public void testStudentLogin() throws Exception {
			LandingPage.getLandingPage(browser).clickOnStudentButton().clickOnGoBackButton() ;

		}

		@Test(groups = { "android", "ios", "web", "BVT0503" })
		public void testSignInOnStudentLogin() throws Exception {
			LandingPage.getLandingPage(browser).clickOnStudentButton().enterStudentCode(my_student_code).clickOnSignInButton() ;
			StudentSignInPage.getStudentSignInPage(browser).clickOnGoBackButton() ;
		}
		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503", "Profile" })
		public void testAddSpouseOnMyProfileOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton();
			MyProfilePage.getMyProfilePage(browser).clickOnAddSpouseButton() ;
			ProfileAddSpousePage.getProfileAddSpousePage(browser).enterTextForSpouseEmail("pop@pop.pop").clickOnaddContactButton() ;
			MyProfilePage.getMyProfilePage(browser).clickOnRemoveSpouseButton().clickOnNoButton() ;
			MyProfilePage.getMyProfilePage(browser).clickOnRemoveSpouseButton().clickOnYesButton() ;
			MyProfilePage.getMyProfilePage(browser).clickOnGoBackButton() ;
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton() ;
		}
		
		// NEEDS TO BE IMPLEMENTED FULLY
		@Test(groups = { "android", "ios", "web", "BVT0503", "Profile" })
		public void testAddChildOnMyProfileOnSettings() throws Exception {
			LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
					.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton();
			MyProfilePage.getMyProfilePage(browser).clickOnAddChildButton().enterTextForChildName("popolkppop") ;
			ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourPink() ;
/*			ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourPurple() ;
			ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourBlue() ;
			ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourGreen() ;
			ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourOrange() ;
*/			ProfileAddChildPage.getProfileAddChildPage(browser).clickOnAddSchoolButton().clickOnGoBackButton() ;
			ProfileAddChildPage.getProfileAddChildPage(browser).clickOnAddSchoolButton() ;
			ChildAddSchoolPage.getChildAddSchoolPage(browser).enterTextForSchoolName("plokjk").clickOnGoBackButton() ;
			ProfileAddChildPage.getProfileAddChildPage(browser).clickOnAddActivitiesButton() ;
			ChildAddActivitiesPage.getChildAddActivitiesPage(browser).enterTextForActivityName("activity").clickOnDoneButton() ;


			MyProfilePage.getMyProfilePage(browser).clickOnGoBackButton() ;
			HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton() ;
		}
		

}