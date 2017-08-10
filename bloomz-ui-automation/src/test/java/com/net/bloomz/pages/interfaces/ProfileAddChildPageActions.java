package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.MyProfilePage;
import com.net.bloomz.pages.ChildAddActivitiesPage;
import com.net.bloomz.pages.ChildAddSchoolPage;
import com.net.bloomz.pages.ProfileAddChildPage;

public interface ProfileAddChildPageActions {

	MyProfilePage clickOnSaveButton();
	ProfileAddChildPage enterTextForChildName(String childName);
	ProfileAddChildPage pickLabelColourPink() ;
	ProfileAddChildPage pickLabelColourOrange() ;
	ProfileAddChildPage pickLabelColourYellow() ;
	ProfileAddChildPage pickLabelColourGreen() ;
	ProfileAddChildPage pickLabelColourBlue() ;
	ProfileAddChildPage pickLabelColourPurple() ;
	ChildAddSchoolPage clickOnAddSchoolButton() ;
	ChildAddActivitiesPage clickOnAddActivitiesButton() ;
	MyProfilePage clickOnGoBackButton();
}
