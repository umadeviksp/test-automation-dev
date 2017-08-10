package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMyProfilePage;
import com.net.bloomz.pages.interfaces.MyProfilePageActions;
import com.net.bloomz.pages.web.WebMyProfilePage ;
import com.net.bloomz.pages.ProfileAddSpousePage;
import com.net.bloomz.pages.ProfileRemoveSpousePage;
import com.net.bloomz.pages.ProfileAddChildPage;
import com.net.bloomz.pages.EditMyProfilePage ;

public class MyProfilePage extends BasePage implements MyProfilePageActions {

	static By addSpouseButtonLocator = null;
	static By removeSpouseButtonLocator = null;
	static By addChildButtonLocator = null;
	static By editButtonLocator = null;
	static By goBackButtonLocator = null;

	public MyProfilePage(Browser<?> browser) {
		super(browser);

	}

	
	public ProfileAddSpousePage clickOnAddSpouseButton() {
		click(addSpouseButtonLocator);
		return ProfileAddSpousePage.getProfileAddSpousePage(browser);
	}
	public ProfileRemoveSpousePage clickOnRemoveSpouseButton() {
		click(removeSpouseButtonLocator);
		return ProfileRemoveSpousePage.getProfileRemoveSpousePage(browser);
	}
	public ProfileAddChildPage clickOnAddChildButton() {
		click(addChildButtonLocator);
		return ProfileAddChildPage.getProfileAddChildPage(browser);
	}

	public HomePage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return HomePage.getHomePage(browser) ;
	}
	public EditMyProfilePage clickOnEditButton() {
		click(editButtonLocator);
		return EditMyProfilePage.getEditMyProfilePage(browser);
	}

	public static MyProfilePage getMyProfilePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			addSpouseButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			removeSpouseButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			addChildButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			editButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidMyProfilePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			addSpouseButtonLocator 	= By.xpath("//data-displayname[text()= \"Spouse\"]");
			addChildButtonLocator = By.xpath("//data-displayname= \"Child\"");

			addSpouseButtonLocator 	= By.xpath("//*[@id=\"userProfileView_myFamilyListing\"]/a[1]/span");
			removeSpouseButtonLocator 	= By.className("spouseInvited");
			addChildButtonLocator = By.xpath("//*[@id=\"userProfileView_myFamilyListing\"]/a[2]/span");
			editButtonLocator 	= By.xpath("//a[text()= \"Edit\"]");
			goBackButtonLocator 	= By.className("backButtonOnly");
			return new WebMyProfilePage(browser);
		}
		return null;
	}
}