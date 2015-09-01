package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.CalendarTabPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.VolunteersTabPage;

public interface HomePageActions {

	HomePage clickOnBloomzIconForMobileApp();

	SettingPage clickOnSettingButton();

	CalendarTabPage clickOnMyCalendarTab();

	VolunteersTabPage clickOnVolunteersTab();

}
