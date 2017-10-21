package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ExampleTemplatePageActions;
import com.net.bloomz.pages.interfaces.GroupPageActions;
import com.net.bloomz.pages.web.WebCreateAccountPage;
import com.net.bloomz.pages.web.WebExampleTemplatePage;
import com.net.bloomz.pages.web.WebGroupPage;

public class GroupPage extends BasePage implements GroupPageActions {
	
	static By createNewClassLocator;
	static By createNewBScoutsLocator;
	static By createNewGScoutsLocator;
	static By createNewSportsTeamLocator;
	static By createChildCareRoomLocator;
	
	public GroupPage(Browser<?> browser) {
		super(browser);
	}

	public static GroupPage getGroupPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			return null; // TO DO FIX THIS
			
		} else if (string.equals(".iOS")) {
			
		} else {
			createNewClassLocator = By.xpath("//*[@id=\"groupTypes\"]/div/div/div/section/div/div[1]/section[1]/div/h2/button/span[2]");
			createNewBScoutsLocator = By.xpath("//*[@id='groupTypes']//*[contains(text(),'Troop - Boy Scouts')]");
			createNewGScoutsLocator = By.xpath("//*[@id='groupTypes']//*[contains(text(),'Troop - Girl Scouts')]");
			createNewSportsTeamLocator = By.xpath("//*[@id='groupTypes']//*[contains(text(),'Sports Team')]");
			createChildCareRoomLocator = By.xpath("//*[@id='groupTypes']//*[contains(text(),'Childcare Room')]");
			return new WebGroupPage(browser);
		}
		return null;
	}
	
	
	public SignUpPage clickOnClassGroup() {
		click(createNewClassLocator);
		return SignUpPage.getSignUpPage(browser); 
	}
	
	public SignUpPage clickOnBoyScoutsGroup() {
		click(createNewBScoutsLocator);
		return SignUpPage.getSignUpPage(browser); 
	}
	
	public SignUpPage clickOnGirlScoutsGroup() {
		click(createNewGScoutsLocator);
		return SignUpPage.getSignUpPage(browser); 
	}
	
	public SignUpPage clickOnSportsTeamGroup() {
		click(createNewSportsTeamLocator);
		return SignUpPage.getSignUpPage(browser); 
	}

	public SignUpPage clickOnChildCareRoomGroup() {
		click(createChildCareRoomLocator);
		return SignUpPage.getSignUpPage(browser); 
	}
	
}