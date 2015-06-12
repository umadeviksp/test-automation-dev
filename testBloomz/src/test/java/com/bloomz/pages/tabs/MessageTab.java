package com.bloomz.pages.tabs;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.BasePage;

public class MessageTab extends BasePage {
	By textEventLocator = By.id("net.bloomz:id/txtEventCalender");

	public MessageTab(AppiumDriver appiumDriver) {
		super(appiumDriver);
		Assert.assertTrue(getText(textEventLocator).trim().equals("Messages"),
				"Current tab is not messages tab");
	}

}
