package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.CalendarSettingsImportCalendarPage;

public interface CalendarSettingsPageActions {
	// put method headers in here
	AccountSettingsPage clickOnGoBackButton() ;
	AccountSettingsPage clickOnSaveButton() ;
	CalendarSettingsImportCalendarPage clickOnAddCalendarButton() ;
	CalendarSettingsImportCalendarPage clickOnImportCalendarButton() ;
	CalendarSettingsImportCalendarPage clickOnExistingCalendarButton() ;
}