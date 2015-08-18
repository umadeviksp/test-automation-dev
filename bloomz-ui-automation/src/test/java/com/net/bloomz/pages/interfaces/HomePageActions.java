package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.SettingPage;




public interface HomePageActions<T extends HomePageActions<T>> {

  T clickOnBloomzIconForMobileApp();

  SettingPage clickOnSettingButton();

}
