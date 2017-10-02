package com.net.bloomz.pages.interfaces;

import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.InvitationPersonalConnectionPage;
import com.net.bloomz.pages.HomePage;

public interface InvitationPersonalConnectionPageActions {

	HomePage clickOnInviteButton();
	InvitationGroupPage clickOnGoBackButton();
	InvitationPersonalConnectionPage enterEmailInTextBox(String emailAddress) ;
}
