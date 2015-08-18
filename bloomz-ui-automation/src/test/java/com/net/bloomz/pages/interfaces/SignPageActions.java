package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.HomePage;


public interface SignPageActions<T extends SignPageActions<T>> {
  T enterEmailIdOnTextBox(String emailId);

  T enterPasswordOnTextBox(String password);

  HomePage clickOnSignInButton();
  
  T setEnviroment();
}
