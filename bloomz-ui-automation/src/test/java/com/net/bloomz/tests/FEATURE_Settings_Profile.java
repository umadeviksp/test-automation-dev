package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.CalendarSettingsImportCalendarPage;
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
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.StudentSignInPage;
import com.net.bloomz.utils.Config;

public class FEATURE_Settings_Profile extends BaseTest {

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
	public void testCancelOnSettings() throws Exception {
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
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testCancelOnMyProfileOnSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnGoBackButton() ;
		
	}

	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testEditOnMyProfileOnSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton() ;
		
	}
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testChoosePhotoOnMyProfileOnSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton().clickOnEditButton().clickOnChoosePhotoButton() ;
		
	}
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
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
	@Test(groups = { "android", "ios", "web", "BVT0503" })
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
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testAddChildOnMyProfileOnSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnMyProfileButton();
		MyProfilePage.getMyProfilePage(browser).clickOnAddChildButton().enterTextForChildName("popolkppop") ;
		ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourPink() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourPurple() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourBlue() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourGreen() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).pickLabelColourOrange() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).clickOnAddSchoolButton().clickOnGoBackButton() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).clickOnAddSchoolButton() ;
		ChildAddSchoolPage.getChildAddSchoolPage(browser).enterTextForSchoolName("plokjk").clickOnGoBackButton() ;
		ProfileAddChildPage.getProfileAddChildPage(browser).clickOnAddActivitiesButton() ;
		ChildAddActivitiesPage.getChildAddActivitiesPage(browser).enterTextForActivityName("activity").clickOnDoneButton() ;


		MyProfilePage.getMyProfilePage(browser).clickOnGoBackButton() ;
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnSignOutButton() ;
	}
	
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testChangeEmail() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnAccountSettingsButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangeEmailAddressButton() ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).enterNewEmailAddress("pol@p.pom").enterPassword("polklki") ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).clickShowHidePassword() ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangeEmailAddressButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnCalendarSettingsButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnNotificationsButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnProfileSettingsButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnPreferredLanguageButton().clickOnGoBackButton();
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangeEmailAddressButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangePasswordButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnProfileTimezoneButton().clickOnGoBackButton()  ;
	}
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testChangePaasword() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnAccountSettingsButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangeEmailAddressButton() ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).enterNewEmailAddress("pol@p.pom").enterPassword("polklki") ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).clickShowHidePassword() ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).clickOnSaveButton() ;
		ChangeEmailAddressPage.getChangeEmailAddressPage(browser).clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangePasswordButton();
		ChangePasswordPage.getChangePasswordPage(browser).clickShowHidePassword() ;
		ChangePasswordPage.getChangePasswordPage(browser).enterOldPassword("oldpassword").enterNewPassword("newpassword123") ;
		ChangePasswordPage.getChangePasswordPage(browser).clickOnSaveButton() ;
		ChangePasswordPage.getChangePasswordPage(browser).clickShowHidePassword() ;
		ChangePasswordPage.getChangePasswordPage(browser).clickOnGoBackButton() ;
	}
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testCalendarSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnAccountSettingsButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnChangeEmailAddressButton().clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnCalendarSettingsButton();
		CalendarSettingsPage.getCalendarSettingsPage(browser).clickOnExistingCalendarButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickShareWithSpouseButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickOnGoBackButton() ;
		CalendarSettingsPage.getCalendarSettingsPage(browser).clickOnGoBackButton() ;

		AccountSettingsPage.getAccountSettingsPage(browser).clickOnCalendarSettingsButton();
		CalendarSettingsPage.getCalendarSettingsPage(browser).clickOnAddCalendarButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).enterCalendarName("calendarName") ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).enterCalendarURL("http://calendarURL.ics") ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickShareWithSpouseButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickOnSaveButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickOnGoBackButton();
		CalendarSettingsPage.getCalendarSettingsPage(browser).clickOnImportCalendarButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickShareWithSpouseButton() ;
		CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser).clickOnGoBackButton() ;
		CalendarSettingsPage.getCalendarSettingsPage(browser).clickOnGoBackButton() ;

		AccountSettingsPage.getAccountSettingsPage(browser).clickOnProfileTimezoneButton().clickOnGoBackButton()  ;
	}
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void testEditProfileOnMyProfileOnSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnAccountSettingsButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnProfileSettingsButton() ;
		ProfileSettingsPage.getProfileSettingsPage(browser).clickOnEditButton();
//		EditMyProfilePage.getEditMyProfilePage(browser).selectFemaleGenderButton() ;
//		EditMyProfilePage.getEditMyProfilePage(browser).selectMaleGenderButton() ;
//		EditMyProfilePage.getEditMyProfilePage(browser).selectFemaleGenderButton() ;
		
		EditMyProfilePage.getEditMyProfilePage(browser).enterLastName("Last_name") ;
		EditMyProfilePage.getEditMyProfilePage(browser).enterFirstName("FirstName") ;
		EditMyProfilePage.getEditMyProfilePage(browser).clickOnGoBackButton() ;

		ProfileSettingsPage.getProfileSettingsPage(browser).clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnSignOutButton() ;
//		SettingPage.getSettingPage(browser).clickOnSignOutButton() ;
	}
	// NEEDS TO BE IMPLEMENTED FULLY
	@Test(groups = { "android", "ios", "web", "BVT0503" })
	public void a_testNotificationsOnSettings() throws Exception {
		LandingPage.getLandingPage(browser).clickOnSignInButton().enterEmailIdOnTextBox(my_email)
				.enterPasswordOnTextBox(my_pwd).clickOnSignInButton();
		HomePage.getHomePage(browser).clickOnSettingButton().clickOnAccountSettingsButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnNotificationsButton() ;

		NotificationsPage.getNotificationsPage(browser).clickOnNotificationByEmailButton().clickOnNotificationByEmailButton();
		NotificationsPage.getNotificationsPage(browser).clickOnNotificationByPushForPhonesButton().clickOnNotificationByPushForPhonesButton();

		NotificationsPage.getNotificationsPage(browser).clickOnPostAndAnnouncementButton().clickOnPostAndAnnouncementButton();
		NotificationsPage.getNotificationsPage(browser).clickOnCommentsOnPostsButton().clickOnCommentsOnPostsButton();
	                                                   
		NotificationsPage.getNotificationsPage(browser).clickOnInvitationsButton().clickOnInvitationsButton();
		NotificationsPage.getNotificationsPage(browser).clickOnRemindersButton().clickOnRemindersButton();
		NotificationsPage.getNotificationsPage(browser).clickOnRSVPResponsesButton().clickOnRSVPResponsesButton();
		NotificationsPage.getNotificationsPage(browser).clickOnCommentsOnEventsButton().clickOnCommentsOnEventsButton();
		NotificationsPage.getNotificationsPage(browser).clickOnMilestonePostsButton().clickOnMilestonePostsButton();
		NotificationsPage.getNotificationsPage(browser).clickOnMissedMessagesButton().clickOnMissedMessagesButton();
	                                                   
		NotificationsPage.getNotificationsPage(browser).clickOnDailyDigestButton().clickOnDailyDigestButton();
		NotificationsPage.getNotificationsPage(browser).clickOnUnreadPostButton().clickOnUnreadPostButton();
		NotificationsPage.getNotificationsPage(browser).clickOnBehaviourUpdatesButton().clickOnBehaviourUpdatesButton();
		NotificationsPage.getNotificationsPage(browser).clickOnNewGroupMemebersButton().clickOnNewGroupMemebersButton();
		NotificationsPage.getNotificationsPage(browser).clickOnNewConnectionsButton().clickOnNewConnectionsButton();
	                                                   
		NotificationsPage.getNotificationsPage(browser).clickOnVerificationsRequestsButton().clickOnVerificationsRequestsButton();
		NotificationsPage.getNotificationsPage(browser).clickOnPostsAnnouncementButton().clickOnPostsAnnouncementButton();
		NotificationsPage.getNotificationsPage(browser).clickOnEventsButton().clickOnEventsButton();
		NotificationsPage.getNotificationsPage(browser).clickOnParentTeacherConfButton().clickOnParentTeacherConfButton();
		NotificationsPage.getNotificationsPage(browser).clickOnClassGroupInviteButton().clickOnClassGroupInviteButton();
	                                                   
		NotificationsPage.getNotificationsPage(browser).clickOnTipsAndTricksButton().clickOnTipsAndTricksButton();
		NotificationsPage.getNotificationsPage(browser).clickOnNewsAndUpdatesButton().clickOnNewsAndUpdatesButton();
		ProfileSettingsPage.getProfileSettingsPage(browser).clickOnGoBackButton() ;
		AccountSettingsPage.getAccountSettingsPage(browser).clickOnSignOutButton() ;
//		SettingPage.getSettingPage(browser).clickOnSignOutButton() ;
	}

}