package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.CalendarTabPage;
import com.net.bloomz.pages.ContactsTabPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SettingPage;

public interface HomePageActions {

	HomePage clickOnBloomzIconForMobileApp();

	SettingPage clickOnSettingButton();

	CalendarTabPage clickOnMyCalendarTab();
	
	ContactsTabPage clickOnMyContactsTab();

}
