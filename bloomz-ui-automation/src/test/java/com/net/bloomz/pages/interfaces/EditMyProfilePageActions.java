package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.ProfilePicOptionsPage ;
import com.net.bloomz.pages.EditMyProfilePage;
import com.net.bloomz.pages.MyProfilePage ;

public interface EditMyProfilePageActions {

	ProfilePicOptionsPage clickOnChoosePhotoButton();
	MyProfilePage clickOnGoBackButton();
	MyProfilePage clickOnSaveButton() ;
	EditMyProfilePage enterFirstName(String firstName) ;
	EditMyProfilePage enterLastName(String lastName) ;
	EditMyProfilePage selectMaleGenderButton() ;
	EditMyProfilePage selectFemaleGenderButton() ;
	
}
