package com.net.bloomz.pages.interfaces;

//import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.ProfileRemoveSpousePage;
import com.net.bloomz.pages.ProfileAddSpousePage;
import com.net.bloomz.pages.ProfileAddChildPage;
import com.net.bloomz.pages.EditMyProfilePage ;

public interface MyProfilePageActions {

	ProfileAddSpousePage clickOnAddSpouseButton();
	ProfileRemoveSpousePage clickOnRemoveSpouseButton();
	ProfileAddChildPage clickOnAddChildButton() ;
	EditMyProfilePage clickOnEditButton();
	HomePage clickOnGoBackButton();
}
