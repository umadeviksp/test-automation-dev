package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SignUpPage;

public interface SignUpPageActions {

	SignUpPage enterFirstName(String fName);

	SignUpPage enterLastName(String lName);

	SignUpPage enterEmailId(String emailId);

	SignUpPage enterPassword(String password);

	HomePage clickOnSignUpButton();

}
