package com.net.bloomz.pages.interfaces;


public interface LandingPageActions<T extends LandingPageActions<T>> {

  T clickOnSignInButton();

  T clickOnCreateAccountORIAmNew();
}
