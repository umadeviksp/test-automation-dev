package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.CalendarSettingsImportCalendarPage;
import com.net.bloomz.pages.CalendarSettingsPage;

public interface CalendarSettingsImportCalendarPageActions {
	// put method headers in here
	CalendarSettingsPage clickOnGoBackButton() ;
	CalendarSettingsImportCalendarPage clickOnSaveButton() ;
	CalendarSettingsImportCalendarPage enterCalendarName(String calendarName) ;
	CalendarSettingsImportCalendarPage enterCalendarURL(String calendarURL) ;
	CalendarSettingsImportCalendarPage clickShareWithSpouseButton() ;
	
}