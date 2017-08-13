package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.ChangeEmailAddressPage;

public interface ChangeEmailAddressPageActions {
	// put method headers in here
	
	AccountSettingsPage clickOnGoBackButton() ;
	AccountSettingsPage clickOnSaveButton() ;
	ChangeEmailAddressPage enterNewEmailAddress(String newEmailAddress) ;
	ChangeEmailAddressPage enterPassword(String password) ;
	ChangeEmailAddressPage clickShowHidePassword() ;
	
}