package com.net.bloomz.appium.pagefactory.framework.browser.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.appium.pagefactory.framework.browser.web.WebBrowserType;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutsConfig;
import com.net.bloomz.appium.pagefactory.framework.exception.IWebDriverException;
import com.net.bloomz.appium.pagefactory.framework.pages.BaseTopLevelPage;
import com.net.bloomz.appium.pagefactory.framework.pages.TopLevelPage;

/**
 * Mobile Browser - Extends Selenium's Appium Driver functionality Working on
 * Android and iOS Supports pages
 */
public abstract class MobileBrowser extends Browser<AppiumDriver> {
	private static Logger logger = LoggerFactory.getLogger(MobileBrowser.class);

	protected String browserName;
	protected String platform;
	protected String platformName;
	protected String platformVersion;
	protected String deviceName;
	protected String newCommandTimeout;
	protected String automationName;
	protected String version;
	protected boolean autoLaunch;
	protected String app;
	protected Map<String, String> optionalValues;

	protected MobileBrowser(String baseTestUrl, TimeoutsConfig timeoutsConfig, String browserName, String platform,
			String platformName, String platformVersion, String deviceName, String newCommandTimeout,
			String automationName, String version, boolean autoLaunch, String app, Map<String, String> optionalValues)
			throws IWebDriverException {
		super(baseTestUrl, timeoutsConfig);
		this.browserName = browserName;
		this.platform = platform;
		this.platformName = platformName;
		this.platformVersion = platformVersion;
		this.deviceName = deviceName;
		this.newCommandTimeout = newCommandTimeout;
		this.automationName = automationName;
		this.version = version;
		this.autoLaunch = autoLaunch;
		this.app = app;
		this.optionalValues = optionalValues;
	}

	public void initializeBrowser() throws IWebDriverException {
		this.webDriver = createWebDriver();
		this.webDriver.manage().timeouts().implicitlyWait(getImplicitWaitTimeoutMillis(), TimeUnit.MILLISECONDS);
	}

	public int getScreenWidth() {
		return this.webDriver.manage().window().getSize().getWidth();
	}

	public int getScreenHeight() {
		return this.webDriver.manage().window().getSize().getHeight();
	}

	protected abstract AppiumDriver createWebDriver() throws IWebDriverException;

	protected void printCapabilities(DesiredCapabilities desiredCapabilities) {
		logger.info("Loading capabilities..");
		for (Map.Entry<String, ?> desiredCapability : desiredCapabilities.asMap().entrySet()) {
			logger.info(desiredCapability.getKey() + "  -  " + desiredCapability.getValue());
		}
	}

	/**
	 * Refresh the current page, without giving back a newly initialized Page
	 * object.
	 */
	@Override
	public void refreshPage() {
		runLeavePageHook();
		BaseTopLevelPage currentPage = PAGE_UTILS.loadCurrentPage(BaseTopLevelPage.class, webDriver, this.getActions());
		currentPage.refreshPage();
		if (optionalCachedPage.isPresent()) {
			TopLevelPage cachedPage = optionalCachedPage.get().getCachedPage();
			cachedPage.refreshElements();
		}
	}

	/**
	 * @param pageClass
	 *            - the class of the expected Page after refreshing.
	 * @param <T>
	 *            - class that extends TopLevelPage class
	 * @return - a page of the requested class
	 */
	@Override
	public <T extends TopLevelPage> T refreshPage(Class<T> pageClass) {
		runLeavePageHook();
		invalidateCachedPage();
		T page = loadTopLevelPage(pageClass);
		page.refreshPage();
		page = loadTopLevelPage(pageClass);
		setCachedPage(page);
		return page;
	}

	@Override
	public WebBrowserType getBrowserType() {
		return WebBrowserType.MOBILE;
	}

	public String getPlatformName() {
		return platformName;
	}

	public String getPlatform() {
		return platform;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getApp() {
		return app;
	}

	// **********~~~~~~~~~~~~~ Mobile Actions ~~~~~~~~~~~~~~~*************

	public void rotateLandscape() {
		webDriver.rotate(ScreenOrientation.LANDSCAPE);
	}

	public void rotatePortrait() {
		webDriver.rotate(ScreenOrientation.PORTRAIT);
	}

	/**
	 * Swipe from the right to left for a second
	 */
	public void swipeLeft() {
		TouchAction action = new TouchAction(webDriver);
		action.press(getScreenWidth() - 5, getScreenHeight() / 2).moveTo(5, getScreenHeight() / 2).release().perform();
//		webDriver.swipe(getScreenWidth() - 5, getScreenHeight() / 2, 5, getScreenHeight() / 2, 1000);
	}

	/**
	 * Swipe from the left to right for a second
	 */
	public void swipeRight() {
		TouchAction action = new TouchAction(webDriver);
		action.press(5, getScreenHeight() / 2).moveTo(getScreenWidth() - 5, getScreenHeight() / 2).release().perform();
//		webDriver.swipe(5, getScreenHeight() / 2, getScreenWidth() - 5, getScreenHeight() / 2, 1000);
	}

	/**
	 * Swipe from the top to bottom for a second
	 */
	public void dragDown() {
		int midScreen = getScreenWidth() / 2;
		TouchAction action = new TouchAction(webDriver);
		action.press(midScreen, 250).moveTo(midScreen, getScreenHeight() - 250).release().perform();
//		webDriver.swipe(midScreen, 250, midScreen, getScreenHeight() - 250, 1500);
	}

	/**
	 * Swipe from the down to up for a second
	 */
	public void dragUp() {
		int midScreen = webDriver.manage().window().getSize().getWidth() / 2;
		TouchAction action = new TouchAction(webDriver);
		action.press(midScreen, getScreenHeight() - 250).moveTo(midScreen, 250).release().perform();
//		webDriver.swipe(midScreen, getScreenHeight() - 250, midScreen, 250, 2500);
	}

	/**
	 * Swipe from the top to bottom for 2.5 seconds
	 *
	 * @param yStart
	 *            - 0 is the upper side of the smart-phone
	 * @param yEnd
	 *            - the end coordinate of the drag function
	 */
	public void drag(int yStart, int yEnd) {
		int midScreen = getScreenWidth() / 2;
		TouchAction action = new TouchAction(webDriver);
		action.press(midScreen, yStart).moveTo(midScreen, yEnd).release().perform();
//		webDriver.swipe(midScreen, yStart, midScreen, yEnd, 2500);
	}

	public void drag(int yStart, int yEnd, int duration) {
		int midScreen = getScreenWidth() / 2;
		TouchAction action = new TouchAction(webDriver);
		action.press(midScreen, yStart).moveTo(midScreen, yEnd).release().perform();
//		webDriver.swipe(midScreen, yStart, midScreen, yEnd, duration);
	}

	/**
	 * @param startX
	 *            - 0 is the left side of the smart-phone
	 * @param endX
	 *            - end coordinate of the right/left movement
	 * @param startY
	 *            - 0 is the upper side of the smart-phone
	 * @param endY
	 *            - end coordinate of the up/down movement
	 * @param duration
	 *            - in milliseconds
	 */
	public void swipe(int startX, int endX, int startY, int endY, int duration) {
		TouchAction action = new TouchAction(webDriver);
		action.press(startX, startY).moveTo(endX, endY).release().perform();
//		webDriver.swipe(startX, startY, endX, endY, duration);
	}

	public void putApplicationToBackground(int duration) {
		webDriver.runAppInBackground(Duration.ofSeconds(duration));
	}
/*
	public void lockMobile(int duration) {
		webDriver.lockScreen(duration); //Deprecated
	}
*/
	public void tap(int fingersNum, WebElement webElement, int duration) {
		TouchAction action = new TouchAction(webDriver);
		action.tap(webElement);
//		webDriver.tap(fingersNum, webElement, duration);
	}

	public void tap(int fingersNum, int xLocation, int yLocation, int duration) {
		TouchAction action = new TouchAction(webDriver);
		action.tap(xLocation, yLocation);
//		webDriver.tap(fingersNum, xLocation, yLocation, duration);
	}

	public void initApp() {
		webDriver.closeApp();
		webDriver.launchApp();
	}

	public abstract void scrollToTop();
}
