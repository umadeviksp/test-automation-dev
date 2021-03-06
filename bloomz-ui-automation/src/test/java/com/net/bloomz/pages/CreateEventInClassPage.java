package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCreateEventInClassPage;
import com.net.bloomz.pages.interfaces.CreateEventInClassPageActions;
import com.net.bloomz.pages.web.WebCreateEventInClassPage;

public class CreateEventInClassPage extends BasePage implements CreateEventInClassPageActions {
	
	static By titleBoxLocator;
	static By locationBoxLocator;
	static By notesBoxLocator;
	static By startDateBoxLocator;
	static By startDateButtonLocator;
	static By endDateBoxLocator;
	static By endDateButtonLocator;
	static By inviteButtonLocator;
	static By inviteAllButtonLocator;
	static By doneButtonLocator;
	static By rsvpButtonLocator;
	static By saveButtonLocator;
	static By calendarListLocator;
	static By calendarPersonalLocator;
	static By backButtonLocator;
	static By startTimeButtonLocator;
	static By calendarLocator;
	static By endTimeButtonLocator;
	static By endsLabelLocator;
	static By myContactsInviteLocator;
	static By toFirstContactInviteLocator;
	static By toFirstClassInviteLocator;
	static By classesInviteLocator;
	static By successEventMessageLocator;
	static By sendButtonLocator;
	static By editNotifyYesButtonLocator;
	static By allDayLocator;
	static By toSelectAllClassesInviteLocator;
	static By reminderSelectionLocator;
	static By fifteenminsReminderLocator;
	static By doneReminderButtonLocator;
	static By okButtonLocator;
	static By upcomingEventsLocator;
	static By eventButtonLocator;
	static By eventDropdownLocator;
	static By notifyAllMembersLocator;
	static By doNotNotifyAllMembersLocator;
	static By signatureButtonLocator;
	static By selectSignatureLocator;
	static By searchTextLocator;
	static By selectAllLocator;

	public CreateEventInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateEventInClassPage enterTitle(String title) {
		sendText(titleBoxLocator, title);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterLocation(String location) {
		sendText(locationBoxLocator, location);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterNotes(String notes) {
		sendText(notesBoxLocator, notes);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnCalendarList() {
		click(calendarListLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnCalendarPersonalList() {
		click(calendarPersonalLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnBackButton() {
		click(backButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickStartDateBox() {
		click(startDateBoxLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickStartDate() {
		click(startDateButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clearStartDate() {
		clearTextBox(startDateButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterStartDate(Integer iYrs, Integer iMons, Integer iDay) {
		sendText(startDateButtonLocator,addYearsMonthsDays(iYrs,iMons,iDay));
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickStartTime() {
		click(startTimeButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clearStartTime() {
		clearTextBox(startTimeButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterStartTime(String sTime) {
		sendText(startTimeButtonLocator,sTime);
		sendkeyboardEvent(startTimeButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickEndLabel() {
		click(endsLabelLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickEndDate() {
		click(endDateButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clearEndDate() {
		clearTextBox(endDateButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterEndDate(Integer iYrs, Integer iMons, Integer iDay) {
		sendText(endDateButtonLocator,addYearsMonthsDays(iYrs,iMons,iDay));
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickEndTime() {
		click(endTimeButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clearEndTime() {
		clearTextBox(endTimeButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterEndTime(String sTime) {
		sendText(endTimeButtonLocator,sTime);
		sendkeyboardEvent(endTimeButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickCloseCalendar() {
		click(calendarLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	
	public CreateEventInClassPage clickEndDateBox() {
		click(endDateBoxLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	

	public CreateEventInClassPage clickInviteButton() {
		click(inviteButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickInviteAllButton() {
		click(inviteAllButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickDoneButton() {
		click(doneButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickRSVPButton() {
		click(rsvpButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickSaveButton() {
		click(saveButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickNotifyAllMembersButton() {
		click(notifyAllMembersLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickDoNotNotifyAllMembersButton() {
		click(doNotNotifyAllMembersLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickSendButton() {
		click(sendButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	

	public CreateEventInClassPage clickOnEditNotifyYes() {
		click(editNotifyYesButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnMyContactsButton() {
		click(myContactsInviteLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage selectFirstContact() {
		click(toFirstContactInviteLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnMyClassesButton() {
		click(classesInviteLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage selectFirstClass() {
		click(toFirstClassInviteLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}

	public CreateEventInClassPage selectAllClasses() {
		click(toSelectAllClassesInviteLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnAllDayButton() {
		click(allDayLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnReminderButton() {
		click(reminderSelectionLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage selectFifteenMinsReminder() {
		click(fifteenminsReminderLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnDoneReminderButton() {
		click(doneReminderButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickOnOKButton() {
		click(okButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public ClassPage thenVerifyThatEventWasSuccessful(String sText) {
		System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return ClassPage.getClassPage(browser);
	}

	public HomePage clickOnUpcomingEventSection() {
		click(upcomingEventsLocator);
		return HomePage.getHomePage(browser);
	}
	
	public CreateEventInClassPage createNewEvent() {
		click(eventButtonLocator);
		click(eventDropdownLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage pickSignature() {
		click(signatureButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage selectSignature() {
		click(selectSignatureLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	
	public CreateEventInClassPage enterSearchText(String sEmailID) {
		click(searchTextLocator);
		sendText(searchTextLocator,sEmailID);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	
	public CreateEventInClassPage clickSelectAll() {
		click(selectAllLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public static CreateEventInClassPage getCreateEventInClassPage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			titleBoxLocator 		= By.id("net.bloomz:id/editeventdetails") ;
			locationBoxLocator 		= By.id("net.bloomz:id/editlocation") ;
			notesBoxLocator 		= By.id("net.bloomz:id/editnotes") ;
			startDateBoxLocator 	= By.id("net.bloomz:id/txtstartdate") ;
			startDateButtonLocator 	= By.id("net.bloomz:id/txtstartdate") ;
			endDateBoxLocator 		= By.id("net.bloomz:id/txtenddate") ;
			endDateButtonLocator 	= By.id("net.bloomz:id/txtenddate") ;
			inviteButtonLocator 	= By.id("net.bloomz:id/txtInvite") ;
			inviteAllButtonLocator 	= By.id("net.bloomz:id/imgGroupIcon") ;
			doneButtonLocator 		= By.id("net.bloomz:id/DoneBtn1") ;
			rsvpButtonLocator 		= By.id("net.bloomz:id/txtRSPV") ;
			saveButtonLocator 		= By.id("net.bloomz:id/BtnSave") ;

			startTimeButtonLocator = By.id("net.bloomz:id/txtstarttime") ;
			endTimeButtonLocator = By.id("net.bloomz:id/txtendtime") ;

			eventButtonLocator 		= By.id("net.bloomz:id/btnStart");
			eventDropdownLocator 	= By.xpath("//android.widget.TextView[contains(@text,'Event')]") ;
			
			reminderSelectionLocator 	= By.id("net.bloomz:id/txtaleartheader");
			fifteenminsReminderLocator 	= By.id("net.bloomz:id/radio15M");
			doneReminderButtonLocator 	= By.id("net.bloomz:id/btnDone");
			
			calendarLocator = By.xpath("//android.widget.Button[contains(@text,'OK')]") ;

			okButtonLocator = By.xpath("//android.widget.Button[contains(@text,'OK')]") ;
			

			return new AndroidCreateEventInClassPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			titleBoxLocator = By.xpath("//*[@id=\"addEvent_eventTitle\"]");
			locationBoxLocator = By.xpath("//*[@id=\"addEvent_eventLocation\"]");
			notesBoxLocator = By.xpath("//*[@id=\"addEvent_eventNotes\"]");
			startDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106645\"]");
			//startDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[6]/td[2]");
			startDateButtonLocator = By.xpath("//div[@id='addUpdateEvent']//label[text()='Starts']//input[@class='datePicker']");
			startTimeButtonLocator = By.xpath("//div[@id='addUpdateEvent']//label[text()='Starts']//div[@date='startDateTimeInput']//div[@class='timePicker']//input");
			endDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501619009735\"]");
			//endDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[8]/td[2]/a");
			endDateButtonLocator = By.xpath("//div[@id='addUpdateEvent']//label[text()='Ends']//input[@class='datePicker']");
			endTimeButtonLocator = By.xpath("//div[@id='addUpdateEvent']//label[text()='Ends']//div[@date='endDateTimeInput']//div[@class='timePicker']//input[@type='text']");
			//inviteButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[1]/label/a");
			inviteButtonLocator = By.xpath("//div[@id='addUpdateEvent']//label[text()='Invite']//a[@class='linkControl drillDown']");
			inviteAllButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[1]/section/div/button");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			rsvpButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[2]/div/label");
			saveButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			calendarListLocator = By.xpath("//*[@id=\"addEvent_calendarSwitcher\"]/section/label/a");
			allDayLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form[1]/div/div/section[4]/section[1]/div/label");
			eventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			//eventDropdownLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[9]");
			eventDropdownLocator = By.xpath("//*[@id='orgHome']//div[@class='menuOptWrapper']//div[@class='clipping']//ul//li[@data-abbr='+ Event']");
			
			calendarPersonalLocator = By.xpath("//*[@id=\"calendarPicker\"]/div/div/div/section/section/div/section[1]/div/h2/button/span");
			backButtonLocator = By.id("calendarPicker_profileBack");
			calendarLocator = By.xpath("//*[@id=\"CalendarControl\"]/a");
			//endsLabelLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form[1]/div/div/section[4]/section[3]/ul/li/label/div/div/a");
			endsLabelLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form[1]/div/div/section[4]/section[4]/ul/li/label/div");
			myContactsInviteLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/div/ul/li[1]/a");
			toFirstContactInviteLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[2]/section[1]/div/button");
			toFirstClassInviteLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/section[1]/div/button[1]");
			classesInviteLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/div/ul/li[2]/a");
			toSelectAllClassesInviteLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div/span");
			successEventMessageLocator = By.id("toast");
			sendButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			editNotifyYesButtonLocator = By.xpath("//*[@id=\"contentDiv\"]/form/div/ul/li[2]/button");
			
			//reminderSelectionLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form[1]/div/div/section[5]/section[3]/label\"/a");
			reminderSelectionLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form[1]/div/div/section[5]/section[3]");
			fifteenminsReminderLocator = By.xpath("//*[@id=\"setAlert\"]/div/div[1]/section/section/div/span[4]/div[1]");
			doneReminderButtonLocator = By.xpath("//*[@id=\"setAlert\"]/div/nav/a[2]");
			okButtonLocator = By.xpath("//*[@id=\"actionSheet_optionsDiv\"]/button[1]/span");
			upcomingEventsLocator = By.xpath("//section[@ng-repeat='day in eventsCollection.collection']/section[@id='posts_calendarEventsSection']/article/div");
			notifyAllMembersLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains (text(),'Notify All Members')]");
			doNotNotifyAllMembersLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//*[contains (text(),'Notify Members')]");
			signatureButtonLocator = By.xpath("//*[@id='addUpdateEvent']//*[@ng-click='openSignaturePicker()']");
			selectSignatureLocator = By.xpath("//*[@id='calendarPicker']//button[@class='addToMsg']");
			searchTextLocator = By.xpath("//*[@id='recipientPicker']//*[@class='recipients']");
			selectAllLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[3]/label/span");

	
			
			return new WebCreateEventInClassPage(browser);
		}
		return null;
	}

}
