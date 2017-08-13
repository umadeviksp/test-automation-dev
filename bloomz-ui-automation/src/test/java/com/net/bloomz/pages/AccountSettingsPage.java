package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.AccountSettingsPageActions;
import com.net.bloomz.pages.android.AndroidAccountSettingsPage;
import com.net.bloomz.pages.web.WebAccountSettingsPage;

public class AccountSettingsPage extends HomePage implements AccountSettingsPageActions {

	static By goBackButtonLocator = null;

	static By calendarSettingsButtonLocator = null;
	static By notificationsButtonLocator = null;

	static By profileSettingsButtonLocator = null;
	static By preferredLanguageButtonLocator = null;
	static By profileTimezoneButtonLocator = null;
	static By changePasswordButtonLocator = null;
	static By changeEmailAddressButtonLocator = null;

	static By signOutButtonLocator = null;

	public AccountSettingsPage(Browser<?> browser) {
		super(browser);

	}

	
	public HomePage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return HomePage.getHomePage(browser);
	}

	public CalendarSettingsPage clickOnCalendarSettingsButton() {
		click(calendarSettingsButtonLocator);
		return CalendarSettingsPage.getCalendarSettingsPage(browser);
	}
	public NotificationsPage clickOnNotificationsButton() {
		click(notificationsButtonLocator);
		return NotificationsPage.getNotificationsPage(browser);
	}
	public ProfileSettingsPage clickOnProfileSettingsButton() {
		click(profileSettingsButtonLocator);
		return ProfileSettingsPage.getProfileSettingsPage(browser);
	}
	public PreferredLanguagePage clickOnPreferredLanguageButton() {
		click(preferredLanguageButtonLocator);
		return PreferredLanguagePage.getPreferredLanguagePage(browser);
	}
	public ProfileTimezonePage clickOnProfileTimezoneButton() {
		click(profileTimezoneButtonLocator);
		return ProfileTimezonePage.getProfileTimezonePage(browser);
	}
	public ChangePasswordPage clickOnChangePasswordButton() {
		click(changePasswordButtonLocator);
		return ChangePasswordPage.getChangePasswordPage(browser);
	}
	public ChangeEmailAddressPage clickOnChangeEmailAddressButton() {
		click(changeEmailAddressButtonLocator);
		return ChangeEmailAddressPage.getChangeEmailAddressPage(browser);
	}


	public SignOutConfirmationPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignOutConfirmationPage.getSignOutConfirmationPage(browser);
	}


	public static AccountSettingsPage getAccountSettingsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			calendarSettingsButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			notificationsButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			profileSettingsButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			preferredLanguageButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			profileTimezoneButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			changePasswordButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			changeEmailAddressButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			return new AndroidAccountSettingsPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			goBackButtonLocator 	= By.xpath("//span[contains(text(), \"Cancel\")]");
			signOutButtonLocator 	= By.xpath("//label[contains(text(), \"Sign Out\")]");

			calendarSettingsButtonLocator 	= By.xpath("//label[contains(text(), \"Calendar Settings\")]");
			notificationsButtonLocator = By.xpath("//label[contains(text(), \"Notifications\")]");
			profileSettingsButtonLocator = By.xpath("//label[contains(text(), \"Profile Settings\")]");
			preferredLanguageButtonLocator = By.xpath("//label[contains(text(), \"Preferred Language\")]");
			profileTimezoneButtonLocator = By.xpath("//label[contains(text(), \"Profile Timezone\")]");
			changePasswordButtonLocator = By.xpath("//label[contains(text(), \"Change Password\")]");
			changeEmailAddressButtonLocator = By.xpath("//label[contains(text(), \"Change Email Address\")]");
			
			return new WebAccountSettingsPage(browser);
		}
		return null;
	}
}