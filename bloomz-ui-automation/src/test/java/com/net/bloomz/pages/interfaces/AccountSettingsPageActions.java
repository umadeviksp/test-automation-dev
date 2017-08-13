package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.CalendarSettingsPage;
import com.net.bloomz.pages.NotificationsPage;
import com.net.bloomz.pages.ProfileSettingsPage;
import com.net.bloomz.pages.PreferredLanguagePage;
import com.net.bloomz.pages.ProfileTimezonePage;
import com.net.bloomz.pages.ChangePasswordPage;
import com.net.bloomz.pages.ChangeEmailAddressPage;
import com.net.bloomz.pages.SignOutConfirmationPage;

public interface AccountSettingsPageActions {

	HomePage clickOnGoBackButton();
	CalendarSettingsPage clickOnCalendarSettingsButton() ;
	NotificationsPage clickOnNotificationsButton() ;
	ProfileSettingsPage clickOnProfileSettingsButton() ;
	PreferredLanguagePage clickOnPreferredLanguageButton();
	ProfileTimezonePage clickOnProfileTimezoneButton()  ;
	ChangePasswordPage clickOnChangePasswordButton() ;
	ChangeEmailAddressPage clickOnChangeEmailAddressButton() ;
	SignOutConfirmationPage clickOnSignOutButton();




}
