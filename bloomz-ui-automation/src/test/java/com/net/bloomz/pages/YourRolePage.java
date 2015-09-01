package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidYourRolePage;
import com.net.bloomz.pages.interfaces.YourRolePageActions;
import com.net.bloomz.pages.web.WebYourRolePage;

public class YourRolePage extends BasePage implements YourRolePageActions {

	static By invitationEditTextLocator;
	static By teacherLocator;
	static By roomParentLocator;
	static By ptaLeaderLocator;
	static By cancelButtonLocator;

	public YourRolePage(Browser<?> browser) {
		super(browser);
	}

	public static YourRolePage getYourRolePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			invitationEditTextLocator = By.id("net.bloomz:id/editInvitationcode");
			teacherLocator = By.id("net.bloomz:id/teacher");
			roomParentLocator = By.id("net.bloomz:id/roomParent");
			ptaLeaderLocator = By.id("net.bloomz:id/ptaLeader");
			cancelButtonLocator = By.id("net.bloomz:id/CancelBtn");
			return new AndroidYourRolePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			invitationEditTextLocator = By.xpath("//*[@ ng-model=\"invitation.code\"]");
			teacherLocator = By.xpath("//*[@ng-click=\"roleSelected('Teacher')\"]");
			roomParentLocator = By.xpath("//*[@ng-click=\"roleSelected('RoomParent')\"]");
			ptaLeaderLocator = By.id("//*[@ng-click=\"roleSelected('ptaleader')\"]");
			cancelButtonLocator = By.xpath("//*[@ng-click=\"leftButtonClickCallback()\"]");
			return new WebYourRolePage(browser);
		}
		return null;
	}

	@Override
	public SignUpPage clickOnTeacherIcon() {
		click(teacherLocator);
		return SignUpPage.getSignUpPage(browser);
	}

	@Override
	public SignUpPage clickOnRoomParentIcon() {
		click(roomParentLocator);
		return SignUpPage.getSignUpPage(browser);
	}

}
