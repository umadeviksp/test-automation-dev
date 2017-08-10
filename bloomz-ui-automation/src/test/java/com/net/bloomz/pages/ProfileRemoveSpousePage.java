package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfileRemoveSpousePage ;
import com.net.bloomz.pages.interfaces.ProfileRemoveSpousePageActions;
import com.net.bloomz.pages.web.WebProfileRemoveSpousePage;

public class ProfileRemoveSpousePage extends BasePage implements ProfileRemoveSpousePageActions {

	static By yesButtonLocator = null;
	static By noButtonLocator = null;

	public ProfileRemoveSpousePage(Browser<?> browser) {
		super(browser);

	}

	
	public MyProfilePage clickOnYesButton() {
		click(yesButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public MyProfilePage clickOnNoButton() {
		click(noButtonLocator);
		return  MyProfilePage.getMyProfilePage(browser);
	}
	public static ProfileRemoveSpousePage getProfileRemoveSpousePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			yesButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			noButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidProfileRemoveSpousePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			yesButtonLocator 	= By.xpath("//span[contains(text(), \"Yes\")]");
			noButtonLocator 	= By.className("cancelBtn");
			return new WebProfileRemoveSpousePage(browser);
		}
		return null;
	}
}