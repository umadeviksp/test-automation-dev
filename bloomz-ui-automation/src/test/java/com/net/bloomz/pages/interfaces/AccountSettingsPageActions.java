package com.net.bloomz.pages.interfaces;

//import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.SignInPage;
import com.net.bloomz.pages.SignOutConfirmationPage;

public interface AccountSettingsPageActions {

	SignOutConfirmationPage clickOnSignOutButton();
	SignInPage clickOnMyProfileButton();
	SignInPage clickOnAccountSettingsButton();
	SignInPage clickOnGoBackButton();
}
