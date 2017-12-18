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
	static By deleteAccountButtonLocator = null;
	static By saveSignOutButtonLocator = null;
	public AccountSettingsPage(Browser<?> browser) {
		super(browser);

	}

	
	public SettingPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return SettingPage.getSettingPage(browser);
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

	public DeleteAccountPage clickOnDeleteAccountButton() {
		click(deleteAccountButtonLocator);
		return DeleteAccountPage.getDeleteAccountPage(browser);
	}

	public SignOutConfirmationPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignOutConfirmationPage.getSignOutConfirmationPage(browser);
	}

	public LandingPage clickOnSaveSignOutButton() {
		click(saveSignOutButtonLocator);
		return LandingPage.getLandingPage(browser);
	}
	public static AccountSettingsPage getAccountSettingsPage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			goBackButtonLocator 			= By.id("net.bloomz:id/backarrow");
			signOutButtonLocator 			= By.id("net.bloomz:id/txtSignOut");
			calendarSettingsButtonLocator 	= By.id("net.bloomz:id/txtCalendarSettings");
			notificationsButtonLocator 		= By.id("net.bloomz:id/txtNotification");
			profileSettingsButtonLocator 	= By.id("net.bloomz:id/txtProfileSettings");
			preferredLanguageButtonLocator 	= By.id("net.bloomz:id/txtPreferredLanguage");
			profileTimezoneButtonLocator 	= By.id("net.bloomz:id/txtPreferredTimeZone");
			changePasswordButtonLocator 	= By.id("net.bloomz:id/txtChangePassword");
			changeEmailAddressButtonLocator	= By.id("net.bloomz:id/txtChangeEmail");
			deleteAccountButtonLocator 		= By.id("net.bloomz:id/txtDeleteAccount");
			saveSignOutButtonLocator 		= By.xpath("saveSignOutButtonLocator");
			
			return new AndroidAccountSettingsPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			goBackButtonLocator 	= By.xpath("//div[@id='accountSettings']//a[contains(@class,'backButtonOnly')]");
			signOutButtonLocator 	= By.xpath("//label[contains(text(),'Sign Out')]");

			calendarSettingsButtonLocator 	= By.xpath("//label[contains(text(), 'Calendar Settings')]");
			notificationsButtonLocator = By.xpath("//label[contains(text(), 'Notifications')]");
			profileSettingsButtonLocator = By.xpath("//label[contains(text(), 'Profile Settings')]");
			preferredLanguageButtonLocator = By.xpath("//label[contains(text(), 'Preferred Language')]");
			profileTimezoneButtonLocator = By.xpath("//label[contains(text(), 'Profile Timezone')]");
			changePasswordButtonLocator = By.xpath("//label[contains(text(), 'Change Password')]");
			changeEmailAddressButtonLocator = By.xpath("//label[contains(text(), 'Change Email Address')]");
			deleteAccountButtonLocator = By.xpath("//*[@id='accountSettings']//*[contains(text(),'Delete Account')]");
			saveSignOutButtonLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains(text(),'Save & Sign Out')]");
			
			return new WebAccountSettingsPage(browser);
		}
		return null;
	}
}