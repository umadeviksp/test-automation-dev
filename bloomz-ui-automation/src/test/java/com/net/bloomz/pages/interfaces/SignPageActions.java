package com.net.bloomz.pages.interfaces;


public interface SignPageActions<T extends SignPageActions<T>> {
  T enterEmailIdOnTextBox(String emailId);

  T enterPasswordOnTextBox(String password);

  T clickOnSignInButton();
  
  T setEnviroment();
}
