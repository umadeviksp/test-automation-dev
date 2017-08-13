package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.pages.SignInPage;

public interface SettingPageActions {

	SignInPage clickOnSignOutButton();
	MyProfilePage clickOnMyProfileButton();
	AccountSettingsPage clickOnAccountSettingsButton();
	HomePage clickOnCancelButton();
}