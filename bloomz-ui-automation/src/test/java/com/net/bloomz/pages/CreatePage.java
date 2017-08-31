package com.net.bloomz.pages;

import org.openqa.selenium.By;
import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreatePageActions;
import com.net.bloomz.pages.web.WebCreatePage;

//Uma created for create page - all options under Create button
public class CreatePage extends BasePage implements CreatePageActions {
	
	static By createButtonLocator;
	static By yearEndVideoLocator;
	static By createPostButtonLocator;
	static By studentWorkLocator;
	static By awardsLocator;
	static By announcementLocator;
	static By alertLocator;
	static By eventLocator;
	static By volunteerLocator;
	static By parentTeacherLocator;

	public CreatePage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePage clickOnYearEndButton() {
		click(yearEndVideoLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public CreatePostInClassPage clickOnCreatePostButton() {
		click(createPostButtonLocator);
		return CreatePostInClassPage.getCreatePostInClassPage(browser);
	}
	
	public CreatePage clickOnStudentWorkButton() {
		click(studentWorkLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public CreatePage clickOnAwardsButton() {
		click(awardsLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public CreatePage clickOnAnnouncementButton() {
		click(announcementLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public CreatePage clickOnAlertButton() {
		click(alertLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public CreateEventInClassPage clickOnEventItemButton() {
		click(eventLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreatePage clickOnVolunteerButton() {
		click(volunteerLocator);
		return CreatePage.getCreatePage(browser);
	}
	
	public CreatePage clickOnParentTeacherButton() {
		click(parentTeacherLocator);
		return CreatePage.getCreatePage(browser);
	}
	

	public static CreatePage getCreatePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			createButtonLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[2]");
			yearEndVideoLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[1]/div");
			createPostButtonLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[2]/span");
			studentWorkLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[3]/div");
			awardsLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[4]/div");
			announcementLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[5]/div");
			alertLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[6]/div");
			eventLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[7]/div");
			volunteerLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[8]/div");
			parentTeacherLocator = By.xpath("//*[@id=\"posts\"]/div[3]/div[1]/div[3]/div/ul/li[9]");
									
			return new WebCreatePage(browser);
		}
		return null;
	}

}