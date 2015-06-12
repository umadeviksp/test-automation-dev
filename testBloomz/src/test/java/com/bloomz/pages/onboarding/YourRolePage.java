package com.bloomz.pages.onboarding;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;

import com.bloomz.pages.BasePage;
import com.bloomz.pages.LandingPage;

public class YourRolePage extends BasePage {

	By invitationEditTextLocator = By.id("net.bloomz:id/editInvitationcode");
	By teacherLocator = By.id("net.bloomz:id/teacher");
	By roomParentLocator = By.id("net.bloomz:id/roomParent");
	By ptaLeaderLocator = By.id("net.bloomz:id/ptaLeader");
	By cancelButtonLocator = By.id("net.bloomz:id/CancelBtn");

	public YourRolePage(AppiumDriver appiumDriver) {
		super(appiumDriver);
	}

	public LandingPage goBackToOnBoardingPage() {
		click(cancelButtonLocator);
		return new LandingPage(appiumDriver);

	}

	public UserOnBoardingPage goToTeacherOnBoarding() {
		click(teacherLocator);
		return new UserOnBoardingPage(appiumDriver);

	}

	public UserOnBoardingPage goToRoomParentOnBoarding() {
		click(roomParentLocator);
		return new UserOnBoardingPage(appiumDriver);

	}
}
