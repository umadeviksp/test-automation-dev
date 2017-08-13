package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.SignInPage;
import com.net.bloomz.pages.CreateAccountPage;
import com.net.bloomz.pages.StudentSignInPage;

public interface LandingPageActions {

	SignInPage clickOnSignInButton();
	CreateAccountPage clickOnCreateAccount();
	StudentSignInPage clickOnStudentButton() ;
}