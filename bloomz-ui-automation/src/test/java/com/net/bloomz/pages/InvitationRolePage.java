package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidInvitationRolePage ;
import com.net.bloomz.pages.interfaces.InvitationRolePageActions;
import com.net.bloomz.pages.web.WebInvitationRolePage;

public class InvitationRolePage extends BasePage implements InvitationRolePageActions {

	static By backButtonLocator = null;
	static By parentButtonLocator = null;
	static By teacherButtonLocator = null;
	static By roomParentButtonLocator = null;
	static By classAdminButtonLocator = null;

	public InvitationRolePage(Browser<?> browser) {
		super(browser);

	}

	
	public InvitationModePage clickOnParentButton() {
		click(parentButtonLocator);
		return InvitationModePage.getInvitationModePage(browser);
	}

	public InvitationModePage clickOnTeacherButton() {
		click(teacherButtonLocator);
		return InvitationModePage.getInvitationModePage(browser);
	}

	public InvitationModePage clickOnRoomParentButton() {
		click(roomParentButtonLocator);
		return InvitationModePage.getInvitationModePage(browser);
	}

	public InvitationModePage clickOnclassAdminButton() {
		click(classAdminButtonLocator);
		return InvitationModePage.getInvitationModePage(browser);
	}

	public InvitationGroupPage clickOnGoBackButton() {
		click(backButtonLocator);
		return  InvitationGroupPage.getInvitationGroupPage(browser);
	}

	public static InvitationRolePage getInvitationRolePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			backButtonLocator 	= By.xpath("//div[@id='rolePicker']//a[@class='backButtonOnly']");
			parentButtonLocator		= By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleParent')]") ;
			teacherButtonLocator    = By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleTeacher')]") ;
			roomParentButtonLocator = By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleRoomParent')]") ;
			classAdminButtonLocator = By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleSchoolAdmin')]") ;
			return new AndroidInvitationRolePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			backButtonLocator 	= By.xpath("//div[@id='rolePicker']//a[@class='backButtonOnly']");
			parentButtonLocator		= By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleParent')]") ;
			teacherButtonLocator    = By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleTeacher')]") ;
			roomParentButtonLocator = By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleRoomParent')]") ;
			classAdminButtonLocator = By.xpath("//div[@id='rolePicker']//section[contains(@class,'roleSchoolAdmin')]") ;
			return new WebInvitationRolePage(browser);
		}
		return null;
	}
}