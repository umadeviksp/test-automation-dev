package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.SignInPage;
import com.net.bloomz.pages.StudentSignInPage;

public interface StudentSignInPageActions {

	SignInPage clickOnSignInButton();
	SignInPage clickOnGoBackButton();
	StudentSignInPage enterStudentCode(String studentCode) ;
}
