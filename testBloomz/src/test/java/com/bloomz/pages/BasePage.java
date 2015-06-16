package com.bloomz.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// TODO: Auto-generated Javadoc
/**
 * The Class BasePage.
 */
public abstract class BasePage {

	protected AppiumDriver appiumDriver;
	WebDriverWait driverWait;

	/**
	 * Instantiates a new base page.
	 *
	 * @param appiumDriver
	 *            the appium driver
	 */
	public BasePage(AppiumDriver appiumDriver) {
		this.appiumDriver = appiumDriver;
	}

	/**
	 * Send text.
	 *
	 * @param locator
	 *            the locator
	 * @param text
	 *            the text
	 * @return the base page
	 */
	public BasePage sendText(By locator, String text) {
		waitForElement(locator);
		click(locator);
		appiumDriver.findElement(locator).clear();
		appiumDriver.findElement(locator).sendKeys(new String[] { text });
		return this;

	}

	/**
	 * Click.
	 *
	 * @param locator
	 *            the locator
	 * @return the base page
	 */
	public BasePage click(By locator) {
		waitForElement(locator);
		appiumDriver.findElement(locator).click();
		return this;
	}

	/**
	 * Send return.
	 *
	 * @param locator
	 *            the locator
	 * @return the base page
	 */
	public BasePage sendReturn(By locator) {
		appiumDriver.findElement(locator).sendKeys(Keys.ENTER);
		return this;

	}

	/**
	 * Click back.
	 *
	 * @return the base page
	 */
	public BasePage clickBack() {
		appiumDriver.navigate().back();
		return this;

	}

	/**
	 * Gets the text.
	 *
	 * @param locator
	 *            the locator
	 * @return the text
	 */
	public String getText(By locator) {
		waitForElement(locator);
		return appiumDriver.findElement(locator).getText();

	}

	/**
	 * Wait for element.
	 *
	 * @param locator
	 *            the locator
	 * @return the web element
	 */
	public WebElement waitForElement(By locator) {
		driverWait = new WebDriverWait(appiumDriver, 40);
		return driverWait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
	}

	/**
	 * Swipe right.
	 *
	 * @param id
	 *            the id
	 * @param offset
	 *            the offset
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeRight(String id, int offset, int duration) {
		MobileElement element1 = (MobileElement) appiumDriver
				.findElementById(id);
		int offset1 = 1;
		Point p1 = element1.getCenter();
		Point location1 = element1.getLocation();
		Dimension size1 = element1.getSize();
		appiumDriver.swipe(location1.getX() + offset1 + offset, p1.getY(),
				location1.getX() + size1.getWidth() - offset1, p1.getY(),
				duration);
		return this;
	}

	/**
	 * Swipe left.
	 *
	 * @param id
	 *            the id
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeLeft(String id, int duration) {
		MobileElement element = (MobileElement) appiumDriver
				.findElementById(id);
		int offset = 1;
		Point p = element.getCenter();
		Point location = element.getLocation();
		Dimension size = element.getSize();
		appiumDriver.swipe(location.getX() + size.getWidth() - offset,
				p.getY(), location.getX() + offset, p.getY(), 1000);
		return this;
	}

	/**
	 * Swipe up.
	 *
	 * @param id
	 *            the id
	 * @param offsetFromStartBorder
	 *            the offset from start border
	 * @param offsetFromEndBorder
	 *            the offset from end border
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeUp(String id, int offsetFromStartBorder,
			int offsetFromEndBorder, int duration) {
		MobileElement element = (MobileElement) appiumDriver
				.findElementById(id);
		element.swipe(SwipeElementDirection.UP, offsetFromStartBorder,
				offsetFromEndBorder, duration);
		return this;
	}

	/**
	 * Swipe down.
	 *
	 * @param id
	 *            the id
	 * @param offsetFromStartBorder
	 *            the offset from start border
	 * @param offsetFromEndBorder
	 *            the offset from end border
	 * @param duration
	 *            the duration
	 * @return the base page
	 */
	public BasePage swipeDown(String id, int offsetFromStartBorder,
			int offsetFromEndBorder, int duration) {
		waitForElement(By.id(id));
		MobileElement element = (MobileElement) appiumDriver
				.findElementById(id);
		element.swipe(SwipeElementDirection.DOWN, offsetFromStartBorder,
				offsetFromEndBorder, duration);
		return this;
	}

	/**
	 * Gets the list contents.
	 *
	 * @param locator
	 *            the locator
	 * @return the list contents
	 */
	public ArrayList<String> getListContents(By locator) {
		java.util.List<WebElement> findElements = appiumDriver
				.findElements(locator);
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.clear();
		Iterator<WebElement> iterator = findElements.iterator();
		while (iterator.hasNext()) {
			WebElement next = iterator.next();
			arrayList.add(next.getText().toString());

		}
		return arrayList;

	}

	/**
	 * Scroll to.
	 *
	 * @param locator
	 *            the locator
	 * @param text
	 *            the text
	 * @param direction
	 *            the direction
	 * @return the base page
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	@Deprecated
	protected BasePage scrollTo(By locator, String text, String direction)
			throws InterruptedException {

		WebElement element = appiumDriver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		java.util.HashMap<String, String> scrollObject = new java.util.HashMap<String, String>();
		scrollObject.put("direction", direction);
		scrollObject.put("text", text);
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scrollTo", scrollObject);
		return this;
	}

	public WebElement getWebElement(By locator) {
		return appiumDriver.findElement(locator);

	}

}
