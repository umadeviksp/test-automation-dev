package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.pages.ProfileAddSpousePage;

public interface ProfileAddSpousePageActions {

	ProfileAddSpousePage enterTextForSpouseEmail(String spouseEmail);
	MyProfilePage clickOnaddContactButton() ;
	MyProfilePage clickOnDoneButton();
	MyProfilePage clickOnGoBackButton();
}
