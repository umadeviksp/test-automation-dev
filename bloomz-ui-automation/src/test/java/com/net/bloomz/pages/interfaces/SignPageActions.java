package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SignInPage;

public interface SignPageActions {
	SignInPage enterEmailIdOnTextBox(String emailId);

	SignInPage enterPasswordOnTextBox(String password);

	HomePage clickOnSignInButton();

	SignInPage setEnviroment();
}
