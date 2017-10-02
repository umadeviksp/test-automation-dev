package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidInvitationModePage ;
import com.net.bloomz.pages.interfaces.InvitationModePageActions;
import com.net.bloomz.pages.web.WebInvitationModePage;

public class InvitationModePage extends BasePage implements InvitationModePageActions {

	static By backButtonLocator = null;
	static By manualEntryButtonLocator = null;
	static By eMailAppButtonLocator = null;
	static By bulkImportButtonLocator = null;
	static By classAccessCodeButtonLocator = null;

	public InvitationModePage(Browser<?> browser) {
		super(browser);

	}

	public InvitationRolePage clickOnGoBackButton() {
		click(backButtonLocator);
		return  InvitationRolePage.getInvitationRolePage(browser);
	}

	public MyProfilePage clickOnManualEntryButton() {
		click(manualEntryButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public MyProfilePage clickOnEMailAppButton() {
		click(eMailAppButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public MyProfilePage clickOnBulkImportButton() {
		click(bulkImportButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}
	
	public ClassAccessCodePage clickOnClassAccessCodeButton() {
		click(classAccessCodeButtonLocator);
		return ClassAccessCodePage.getClassAccessCodePage(browser);
	}
	
	public static InvitationModePage getInvitationModePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			backButtonLocator = By.xpath("//div[@id='inviteMethods']//a[contains(@class,'backButton')]");
			manualEntryButtonLocator 	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteManual')]");;
			eMailAppButtonLocator	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteEmail')]");;
			bulkImportButtonLocator	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteBulk')]");;
			classAccessCodeButtonLocator	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteAccessCode')]");;
			return new AndroidInvitationModePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			backButtonLocator = By.xpath("//div[@id='inviteMethods']//a[contains(@class,'backButton')]");
			manualEntryButtonLocator 	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteManual')]");;
			eMailAppButtonLocator	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteEmail')]");;
			bulkImportButtonLocator	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteBulk')]");;
			classAccessCodeButtonLocator	= By.xpath("//div[@id='inviteMethods']//section[contains(@class,'inviteAccessCode')]");;
			return new WebInvitationModePage(browser);
		}
		return null;
	}
}