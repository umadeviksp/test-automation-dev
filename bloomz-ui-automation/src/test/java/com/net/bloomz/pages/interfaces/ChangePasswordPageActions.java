package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.ChangePasswordPage;

public interface ChangePasswordPageActions {
	// put method headers in here
	AccountSettingsPage clickOnGoBackButton() ;
	AccountSettingsPage clickOnSaveButton() ;
	ChangePasswordPage enterOldPassword(String oldPassword) ;
	ChangePasswordPage enterNewPassword(String oldPassword) ;
	ChangePasswordPage clickShowHidePassword() ;
	ChangePasswordPage verifyShowHidePassword() ;
}