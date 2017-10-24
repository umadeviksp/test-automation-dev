package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSettingPage;
import com.net.bloomz.pages.interfaces.GroupSettingPageActions;
import com.net.bloomz.pages.web.WebGroupSettingPage;

public class GroupSettingPage extends BasePage implements GroupSettingPageActions {

	static By editSettingsButtonLocator = null;
	static By emailEventHistoryButtonLocator = null;
	static By printThisPageButtonLocator = null;
	static By LeaveClassButtonLocator = null;
	static By DeleteClassButtonLocator = null;
	static By cancelButtonLocator = null;

	public GroupSettingPage(Browser<?> browser) {
		super(browser);

	}

	public SettingPage clickOnEditSettings() {
		click(editSettingsButtonLocator);
		return SettingPage.getSettingPage(browser);
	}

	public static GroupSettingPage getGroupSettingPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
//			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
//			myProfileButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
//			accountSettingsButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
//			cancelButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			//return new AndroidSettingPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			editSettingsButtonLocator 	= By.xpath("//span[contains(text(), \"Edit Settings\")]");
			emailEventHistoryButtonLocator 	= By.xpath("//span[contains(text(), \"Email Event History\")]");
			printThisPageButtonLocator = By.xpath("//span[contains(text(), \"Print this Page\")]");
			LeaveClassButtonLocator 	= By.xpath("//span[contains(text(), \"Leave Class\")]");
			DeleteClassButtonLocator = By.xpath("//span[contains(text(), \"Delete Class\")]");
			cancelButtonLocator = By.xpath("//span[contains(text(), \"Cancel\")]");
			
			return new WebGroupSettingPage(browser);
		}
		return null;
	}
}