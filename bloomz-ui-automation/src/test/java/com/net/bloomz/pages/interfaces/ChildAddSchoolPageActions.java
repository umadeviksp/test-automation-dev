package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.ChildAddSchoolPage;
//import com.net.bloomz.pages.ChildAddSchoolPage;
import com.net.bloomz.pages.ProfileAddChildPage;

public interface ChildAddSchoolPageActions {

	ProfileAddChildPage clickOnGoBackButton();
	ChildAddSchoolPage clickOnGoNextButton() ;
	ChildAddSchoolPage enterTextForSchoolName(String SchoolName) ;
}
