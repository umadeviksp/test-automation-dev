package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidNotificationsPage;
import com.net.bloomz.pages.interfaces.NotificationsPageActions;
import com.net.bloomz.pages.web.WebNotificationsPage;

public class NotificationsPage extends BasePage implements NotificationsPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;

	static By notificationQuietHoursButtonLocator = null;

	static By notificationByEmailButtonLocator = null;
	static By notificationByPushForPhonesButtonLocator = null;

	static By postAndAnnouncementButtonLocator = null;
	static By commentsOnPostsButtonLocator = null;
	static By invitationsButtonLocator = null;
	static By remindersButtonLocator = null;
	static By RSVPResponsesButtonLocator = null;
	static By commentsOnEventsButtonLocator = null;
	static By milestonePostsButtonLocator = null;
	static By missedMessagesButtonLocator = null;

	static By dailyDigestButtonLocator = null;
	static By unreadPostButtonLocator = null;
	static By behaviourUpdatesButtonLocator = null;
	static By newGroupMemebersButtonLocator = null;
	static By newConnectionsButtonLocator = null;

	static By verificationsRequestsButtonLocator = null;
	static By postsAnnouncementButtonLocator = null;
	static By eventsButtonLocator = null;
	static By parentTeacherConfButtonLocator = null;
	static By classGroupInviteButtonLocator = null;

	static By tipsAndTricksButtonLocator = null;
	static By newsAndUpdatesButtonLocator = null;

	public NotificationsPage(Browser<?> browser) {
		super(browser);
	}


	public AccountSettingsPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public AccountSettingsPage clickOnSaveButton() {
		click(saveButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public NotificationsQuietHoursPage clickOnNotificationQuietHoursButton() {
		click(notificationQuietHoursButtonLocator);
		return NotificationsQuietHoursPage.getNotificationsQuietHoursPage(browser);
	}

	public NotificationsPage clickOnNotificationByEmailButton() {
		click(notificationByEmailButtonLocator);
		return this;
	}

	public NotificationsPage clickOnNotificationByPushForPhonesButton() {
		click(notificationByPushForPhonesButtonLocator);
		return this;
	}

	public NotificationsPage clickOnPostAndAnnouncementButton() {
		click(postAndAnnouncementButtonLocator);
		return this;
	}

	public NotificationsPage clickOnCommentsOnPostsButton() {
		click(commentsOnPostsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnInvitationsButton() {
		click(invitationsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnRemindersButton() {
		click(remindersButtonLocator);
		return this;
	}

	public NotificationsPage clickOnRSVPResponsesButton() {
		click(RSVPResponsesButtonLocator);
		return this;
	}

	public NotificationsPage clickOnCommentsOnEventsButton() {
		click(commentsOnEventsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnMilestonePostsButton() {
		click(milestonePostsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnMissedMessagesButton() {
		click(missedMessagesButtonLocator);
		return this;
	}

	public NotificationsPage clickOnDailyDigestButton() {
		click(dailyDigestButtonLocator);
		return this;
	}

	public NotificationsPage clickOnUnreadPostButton() {
		click(unreadPostButtonLocator);
		return this;
	}

	public NotificationsPage clickOnBehaviourUpdatesButton() {
		click(behaviourUpdatesButtonLocator);
		return this;
	}

	public NotificationsPage clickOnNewGroupMemebersButton() {
		click(newGroupMemebersButtonLocator);
		return this;
	}

	public NotificationsPage clickOnNewConnectionsButton() {
		click(newConnectionsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnVerificationsRequestsButton() {
		click(verificationsRequestsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnPostsAnnouncementButton() {
		click(postsAnnouncementButtonLocator);
		return this;
	}

	public NotificationsPage clickOnEventsButton() {
		click(eventsButtonLocator);
		return this;
	}

	public NotificationsPage clickOnParentTeacherConfButton() {
		click(parentTeacherConfButtonLocator);
		return this;
	}

	public NotificationsPage clickOnClassGroupInviteButton() {
		click(classGroupInviteButtonLocator);
		return this;
	}

	public NotificationsPage clickOnTipsAndTricksButton() {
		click(tipsAndTricksButtonLocator);
		return this;
	}

	public NotificationsPage clickOnNewsAndUpdatesButton() {
		click(newsAndUpdatesButtonLocator);
		return this;
	}

	public static NotificationsPage getNotificationsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidNotificationsPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			goBackButtonLocator	= By.xpath("//div[@id='notificationSettings']//a[contains(@class,'backButtonOnly')]");

			notificationQuietHoursButtonLocator= By.xpath("//div[@id='notificationSettings']//input[@id='notifybyemail']");

			notificationByEmailButtonLocator= By.xpath("//div[@id='notificationSettings']//input[@id='notifybyemail']");
			notificationByPushForPhonesButtonLocator =By.xpath("//div[@id='notificationSettings']//input[@id='notifybypush']");
			 
			postAndAnnouncementButtonLocator= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='postpost-announcements']");

			commentsOnPostsButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='postcomments']");
			
			invitationsButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='eventsinvitations']");
			remindersButtonLocator		= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='eventsreminders']");
			RSVPResponsesButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='eventsrsvp-responses']");
			commentsOnEventsButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='eventscomments']");
			
			milestonePostsButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='behaviormilestone-posts']");
			
			missedMessagesButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='messagesmissed-messages']");
			
			dailyDigestButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='periodicdigestdaily-digest']");
			unreadPostButtonLocator		= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='periodicdigestunread-post']");
			behaviourUpdatesButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='periodicdigestbehavior-updates']");
			newGroupMemebersButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='periodicdigestnew-group-members']");
			newConnectionsButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='periodicdigestnew-connections']");
			
			verificationsRequestsButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='adminnotificationsverification-requests']");
			
			postsAnnouncementButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='creationconfirmationpostsannouncements']");
			eventsButtonLocator			= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='creationconfirmationevents']");
			parentTeacherConfButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='creationconfirmationparent-teacher-conf']");
			classGroupInviteButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='creationconfirmationclassgroup-invites']");

			tipsAndTricksButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='aboutbloomztips-tricks']");
			newsAndUpdatesButtonLocator	= By.xpath("//div[@id='notificationSettings']//div[contains(@class,'switchControl')]//label[@for='aboutbloomznews-updates']");

			return new WebNotificationsPage(browser);
		}
		return null;
	}

}
