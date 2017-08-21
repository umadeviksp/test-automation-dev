package com.net.bloomz.pages.interfaces;

import org.openqa.selenium.By;

import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.NotificationsPage;
import com.net.bloomz.pages.NotificationsQuietHoursPage;

public interface NotificationsPageActions {
	// put method headers in here
	AccountSettingsPage clickOnGoBackButton() ;
	AccountSettingsPage clickOnSaveButton() ;

	NotificationsQuietHoursPage clickOnNotificationQuietHoursButton();

	NotificationsPage clickOnNotificationByEmailButton();
	NotificationsPage clickOnNotificationByPushForPhonesButton();

	NotificationsPage clickOnPostAndAnnouncementButton();
	NotificationsPage clickOnCommentsOnPostsButton();

	NotificationsPage clickOnInvitationsButton();
	NotificationsPage clickOnRemindersButton();
	NotificationsPage clickOnRSVPResponsesButton();
	NotificationsPage clickOnCommentsOnEventsButton();
	NotificationsPage clickOnMilestonePostsButton();
	NotificationsPage clickOnMissedMessagesButton();
                      
	NotificationsPage clickOnDailyDigestButton();
	NotificationsPage clickOnUnreadPostButton();
	NotificationsPage clickOnBehaviourUpdatesButton();
	NotificationsPage clickOnNewGroupMemebersButton();
	NotificationsPage clickOnNewConnectionsButton();
                      
	NotificationsPage clickOnVerificationsRequestsButton();
	NotificationsPage clickOnPostsAnnouncementButton();
	NotificationsPage clickOnEventsButton();
	NotificationsPage clickOnParentTeacherConfButton();
	NotificationsPage clickOnClassGroupInviteButton();
                      
	NotificationsPage clickOnTipsAndTricksButton();
	NotificationsPage clickOnNewsAndUpdatesButton();
}
