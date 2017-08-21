package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.CalendarTabPage;
import com.net.bloomz.pages.ContactsTabPage;
import com.net.bloomz.pages.CreatePage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.CreateMessagePage;

public interface HomePageActions {

	HomePage clickOnBloomzIconForMobileApp();

	SettingPage clickOnSettingButton();

	CalendarTabPage clickOnMyCalendarTab();
	
	ContactsTabPage clickOnMyContactsTab();
	
	CreateMessagePage clickOnMyMessageButton();
	
	CreatePage clickCreateButton();
	
	CreateMessagePage clickOnFirstMessageInTray();

}
