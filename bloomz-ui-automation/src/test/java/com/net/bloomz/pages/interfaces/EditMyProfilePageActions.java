package com.net.bloomz.pages.interfaces;

//import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.SignInPage;
import com.net.bloomz.pages.SignOutConfirmationPage;
import com.net.bloomz.pages.ProfilePicOptionsPage ;
import com.net.bloomz.pages.MyProfilePage ;

public interface EditMyProfilePageActions {

	SignOutConfirmationPage clickOnSignOutButton();
	ProfilePicOptionsPage clickOnChoosePhotoButton();
	SignInPage clickOnAccountSettingsButton();
	MyProfilePage clickOnGoBackButton();
}
