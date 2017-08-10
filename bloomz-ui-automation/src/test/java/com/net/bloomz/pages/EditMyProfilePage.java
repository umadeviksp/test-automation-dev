package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidEditMyProfilePage ;
import com.net.bloomz.pages.interfaces.EditMyProfilePageActions;
import com.net.bloomz.pages.web.WebEditMyProfilePage ;
import com.net.bloomz.pages.SignOutConfirmationPage;
import com.net.bloomz.pages.ProfilePicOptionsPage ;

public class EditMyProfilePage extends BasePage implements EditMyProfilePageActions {

	static By signOutButtonLocator = null;
	static By choosePhotoButtonLocator = null;
	static By accountSettingsButtonLocator = null;
	static By cancelButtonLocator = null;

	public EditMyProfilePage(Browser<?> browser) {
		super(browser);

	}

	
	public SignOutConfirmationPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignOutConfirmationPage.getSignOutConfirmationPage(browser);
	}

	public ProfilePicOptionsPage clickOnChoosePhotoButton() {
		click(choosePhotoButtonLocator);
		return ProfilePicOptionsPage.getProfilePicOptionsPage(browser);
	}
	public SignInPage clickOnAccountSettingsButton() {
		click(accountSettingsButtonLocator);
		return SignInPage.getSignInPage(browser);
	}
	public MyProfilePage clickOnGoBackButton() {
		click(cancelButtonLocator);
		return MyProfilePage.getMyProfilePage(browser) ;
	}
	public static EditMyProfilePage getEditMyProfilePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			choosePhotoButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			cancelButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			accountSettingsButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			return new AndroidEditMyProfilePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			choosePhotoButtonLocator	= By.className("choosePhotoOptions");
			cancelButtonLocator 	= By.className("backButtonOnly");
			signOutButtonLocator 	= By.xpath("//label[contains(text(), \"Sign Out\")]");
			accountSettingsButtonLocator = By.xpath("//span[contains(text(), \"Account Settings\")]");
			return new WebEditMyProfilePage(browser);
		}
		return null;
	}
}