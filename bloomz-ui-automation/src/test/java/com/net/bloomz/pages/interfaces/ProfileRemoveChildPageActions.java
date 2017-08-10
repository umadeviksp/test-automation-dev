package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.MyProfilePage;
//import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.ProfileRemoveChildPage;

public interface ProfileRemoveChildPageActions {

	MyProfilePage clickOnSaveButton();
	ProfileRemoveChildPage enterTextForChildName(String childName);
	MyProfilePage clickOnGoBackButton();
}
