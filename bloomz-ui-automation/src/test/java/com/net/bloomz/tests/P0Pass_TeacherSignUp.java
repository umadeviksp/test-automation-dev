package com.net.bloomz.tests;

import org.testng.annotations.Test;
import com.net.bloomz.pages.LandingPage;

public class P0Pass_TeacherSignUp extends BaseTest {
	
	// Sign Up - Teacher
	// Teacher - Direct Sign Up - User directly signing up as a teacher and creating a Girls Scout
	@Test(groups = { "android", "ios", "web", "BVT01" })
	public void P0Pass_1_testSignUpAsATeacher_GirlScout() throws Exception {
		System.out.println("P0Pass_1_testSignUpAsATeacher_BoysScout");
		String sEmail = "test_GirlScouts" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		System.out.println(sEmail);
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnGirlScoutsGroup()
		.enterFirstName("test").enterLastName("Girl Scouts")
		.enterEmailId(sEmail).enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test Girl Scouts")
		.thenVerifyWelcomeScreenTroop("Create a Troop").clickOnSettingButton().clickOnAccountSettingsButton()
		.clickOnDeleteAccountButton().selectReasonForDeleteButton().selectReasonAsOthersButton()
		.enterPassword().clickDeletePermanentButton().clickOnYesButton().thenVerifyConfirmMessage().clickOnOkButton()
		.thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}

	// Sign Up - Teacher
	// Teacher - Direct Sign Up - User directly signing up as a teacher and creating a Boys Scout
	@Test(groups = { "android", "ios", "web", "BVT02" })
	public void P0Pass_2_testSignUpAsATeacher_BoysScout() throws Exception {
		System.out.println("P0Pass_1_testSignUpAsATeacher_BoysScout");
		String sEmail = "test_BoyScouts" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		System.out.println(sEmail);
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnBoyScoutsGroup()
		.enterFirstName("test").enterLastName("Boy Scouts")
		.enterEmailId(sEmail).enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test Boy Scouts")
		.thenVerifyWelcomeScreenTroop("Create a Troop").clickOnSettingButton().clickOnAccountSettingsButton()
		.clickOnDeleteAccountButton().selectReasonForDeleteButton().selectReasonAsOthersButton()
		.enterPassword().clickDeletePermanentButton().clickOnYesButton().thenVerifyConfirmMessage().clickOnOkButton()
		.thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}
	
	// Sign Up - Teacher
	// Teacher - Direct Sign Up - User directly signing up as a teacher and creating a Sports Team
	@Test(groups = { "android", "ios", "web", "BVT03" })
	public void P0Pass_3_testSignUpAsATeacher_SportsTeam() throws Exception {
		System.out.println("P0Pass_1_testSignUpAsATeacher_BoysScout");
		String sEmail = "test_SportsTeam" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		System.out.println(sEmail);
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnSportsTeamGroup()
		.enterFirstName("test").enterLastName("Sports Team")
		.enterEmailId(sEmail).enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test Sports Team")
		.thenVerifyWelcomeScreenTroop("Create a Sports Team").clickOnSettingButton().clickOnAccountSettingsButton()
		.clickOnDeleteAccountButton().selectReasonForDeleteButton().selectReasonAsOthersButton()
		.enterPassword().clickDeletePermanentButton().clickOnYesButton().thenVerifyConfirmMessage().clickOnOkButton()
		.thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}
	
	// Sign Up - Teacher
	// Teacher - Direct Sign Up - User directly signing up as a teacher and creating a Sports Team
	@Test(groups = { "android", "ios", "web", "BVT04" })
	public void P0Pass_4_testSignUpAsATeacher_ChildCareRoom() throws Exception {
		System.out.println("P0Pass_1_testSignUpAsATeacher_BoysScout");
		String sEmail = "test_ChildCareRoom" + getTimeStamp().replaceAll("-", "_") + "@test.com";
		System.out.println(sEmail);
		LandingPage.getLandingPage(browser).clickOnCreateAccount().clickOnCreateNewClassGroup().clickOnChildCareRoomGroup()
		.enterFirstName("test").enterLastName("ChildCare Room")
		.enterEmailId(sEmail).enterPassword("bloomz999")
		.clickOnSignUpButton().thenVerifyCreateButtonShouldBeDisplayed().thenVerifyProfileName("test ChildCare Room")
		.thenVerifyWelcomeScreenTroop("Create a Childcare Room").clickOnSettingButton().clickOnAccountSettingsButton()
		.clickOnDeleteAccountButton().selectReasonForDeleteButton().selectReasonAsOthersButton()
		.enterPassword().clickDeletePermanentButton().clickOnYesButton().thenVerifyConfirmMessage().clickOnOkButton()
		.thenVerifySignInAndCreateButtonsShouldBeDisplayed();
	}	
		
}