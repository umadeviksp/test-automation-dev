package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.SignInPage;


public interface LandingPageActions<T extends LandingPageActions<T>> {

  SignInPage clickOnSignInButton();

  T clickOnCreateAccountORIAmNew();
}
