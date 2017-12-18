package com.net.bloomz.pages.android;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.CreateEventInClassPage;
import com.net.bloomz.pages.interfaces.CreateEventInClassPageActions;

public class AndroidCreateEventInClassPage extends CreateEventInClassPage implements CreateEventInClassPageActions {

//	By inviteButtonLocator = By.id("net.bloomz:id/txtInvite") ;
	By okButtonLocator = By.xpath("//android.widget.Button[contains(@text,'OK')]") ;

	public AndroidCreateEventInClassPage(Browser<?> browser) {
		super(browser);

	}
	public CreateEventInClassPage clearStartDate() {
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	public CreateEventInClassPage clearStartTime() {
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	public CreateEventInClassPage clearEndDate() {
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	public CreateEventInClassPage clearEndTime() {
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	public CreateEventInClassPage clickRSVPButton() {
	//	swipe
		return super.clickRSVPButton() ;
	}
	
	public CreateEventInClassPage enterStartDate(Integer iYrs, Integer iMons, Integer iDay) {
//		sendText(startDateButtonLocator,addYearsMonthsDays(iYrs,iMons,iDay));
//		return super.enterStartDate(iYrs, iMons, iDay) ;
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}

	public CreateEventInClassPage enterStartTime(String sTime) {
//		sendText(startTimeButtonLocator,sTime);
//		sendkeyboardEvent(startTimeButtonLocator);
		click(okButtonLocator);
//		return super.enterStartTime(sTime) ;
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	public CreateEventInClassPage enterEndDate(Integer iYrs, Integer iMons, Integer iDay) {
//		sendText(endDateButtonLocator,addYearsMonthsDays(iYrs,iMons,iDay));
//		return super.enterEndDate(iYrs, iMons, iDay);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterEndTime(String sTime) {
//		sendText(endTimeButtonLocator,sTime);
//		sendkeyboardEvent(endTimeButtonLocator);
		click(okButtonLocator);
//		return super.enterEndTime(sTime);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}

/*	public CreateEventInClassPage clickInviteButton() {
		click(inviteButtonLocator);
		return super.clickInviteButton() ;
	}
*/
}
