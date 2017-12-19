package com.net.bloomz.tests;

import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.appium.pagefactory.framework.browser.LocalBrowserBuilder;
import com.net.bloomz.appium.pagefactory.framework.browser.MobileBrowserBuilder;
import com.net.bloomz.appium.pagefactory.framework.browser.RemoteBrowserBuilder;
import com.net.bloomz.appium.pagefactory.framework.browser.mobile.MobileBrowser;
import com.net.bloomz.appium.pagefactory.framework.browser.mobile.MobilePlatformName;
import com.net.bloomz.appium.pagefactory.framework.browser.web.WebBrowser;
import com.net.bloomz.appium.pagefactory.framework.browser.web.WebBrowserType;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutType;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutsConfig;
import com.net.bloomz.appium.pagefactory.framework.exception.IWebDriverException;
import com.net.bloomz.utils.Config;

public class BaseTest {

	Browser<?> browser = null;
//	private static final String TESTDROID_USERNAME = "nitin@bloomz.net";
//	private static final String TESTDROID_PASSWORD = "bloomz999";

	private static final String TESTDROID_USERNAME = "my_parcel@yahoo.com";
	private static final String TESTDROID_PASSWORD = "gayathri0";

	public static final String USERNAME = "manik_mg";
	public static final String ACCESS_KEY = "9aa83bc8-a677-4589-9da8-cfe685438d7e";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

	public static final String androidProductionApp = "C:/Users/user/production/base.apk";
//	public static final String androidStagingApp = "C:/Users/user/staging/net.bloomz-Signed.apk";
//	public static final String androidStagingApp = "C:/Users/user/staging/net.bloomz.apk";
	public static final String androidStagingApp = "C:/Users/user/staging/net.bloomz-Android-1.apk";
	
	public static String baseTestUrl = null;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IWebDriverException, MalformedURLException {

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

	}

	private Browser<?> createBrowser(String platformName, String browserType, String environment, String urltype)
			throws IWebDriverException {
		TimeoutsConfig timeouts = TimeoutsConfig.builder().pageLoadTimoutSeconds(80).implicitWaitTimeoutMillis(80000)
				.build();

		logger.info("[{},{},{},{}]", platformName, browserType, environment, urltype);
		if (platformName.equals("Android")) {
			MobileBrowser browser = null;

			if (environment.equals("testdroid")) {
				browser = MobileBrowserBuilder.getAndroidBuilder("http://appium.testdroid.com/wd/hub")
						.withTimeoutsConfig(timeouts)
						.withVersion("1.0")
						.withPlatform("ANDROID")
						.withPlatformName(MobilePlatformName.ANDROID)
						.withPlatformVersion("5.0.1")
						.withDeviceName("Nvidia Shield Tablet")
						.withKey("testdroid_target", "android")
						.withKey("testdroid_username", TESTDROID_USERNAME)
						.withKey("testdroid_password", TESTDROID_PASSWORD)
						.withKey("testdroid_project", "AndroidBloomzTest")
						.withKey("testdroid_testrun", "Test Run on" + getTimeStamp())
						.withKey("testdroid_device", "Nvidia Shield Tablet")
						.withKey("env", "cloud")
						.withKey("testdroid_app", "latest")
						.withAppPackage("net.bloomz")
						.withAppActivity("md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity")
						.build();
				
				} else if  (environment.equals("testdroid1")) {
					browser = MobileBrowserBuilder.getAndroidBuilder("http://appium.testdroid.com/wd/hub")
							.withTimeoutsConfig(timeouts)
							.withVersion("1.0")
							.withPlatform("ANDROID")
							.withPlatformName(MobilePlatformName.ANDROID)
							.withPlatformVersion("5.0")
							.withDeviceName("LG Google Nexus 5 D820 5.0")
							.withKey("testdroid_target", "android")
							.withKey("testdroid_username", TESTDROID_USERNAME)
							.withKey("testdroid_password", TESTDROID_PASSWORD)
							.withKey("testdroid_project", "AndroidBloomzTest")
							.withKey("testdroid_testrun", "Test Run on" + getTimeStamp())
							.withKey("testdroid_device", "LG Google Nexus 5 D820 5.0")
							.withKey("env", "cloud")
							.withKey("testdroid_app", "latest")
//							.withApp("C:/Users/user/base.apk")
							.withAppPackage("net.bloomz")
							.withAutoLaunch(true)
							.build();

			} else if (environment.equals("local")) {

				browser = MobileBrowserBuilder.getAndroidBuilder("http://127.0.0.1:4723/wd/hub")
						.withTimeoutsConfig(timeouts)
						.withVersion("1.0")
						.withPlatform("ANDROID")
						.withPlatformName(MobilePlatformName.ANDROID)
						.withPlatformVersion("5.0")
						.withDeviceName("Moto G")
//						.withKey("env", "local")
						.withApp("/Users/manikandan/Desktop/BloomzApk/bloomz_16.apk")
						.withAppPackage("net.bloomz")
						.withAppActivity("md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity")
						.build();

			} else if (environment.equals("newlocal")) {

				browser = MobileBrowserBuilder.getAndroidBuilder("http://localhost:4723/wd/hub")
						.withAutomationName("UIAutomator2")
						.withTimeoutsConfig(timeouts)
						.withPlatformName(MobilePlatformName.ANDROID)
						.withPlatformVersion("6.0")
						.withDeviceName("Moto G2")
						.withApp(androidStagingApp)
						.withAutoLaunch(true)
						.withKey("noReset", "true")
						.withKey("newCommandTimeout", "10")
//						.withAppPackage("net.bloomz")
						.build();

			}
			else if (environment.equals("newlocal1")) {
				browser = MobileBrowserBuilder.getAndroidBuilder("http://localhost:4723/wd/hub")
						.withAutomationName("UIAutomator2")
						.withTimeoutsConfig(timeouts)
						.withVersion("1.0")
						.withPlatformName(MobilePlatformName.ANDROID)
						.withPlatformVersion("6.0")
						.withDeviceName("Moto G")
						.withApp(androidStagingApp)
						.withAutoLaunch(true)
	//					.withPlatform("ANDROID")
	//					.withKey("udid", "ZX1D6258HZ")
	//					.withKey("noReset", "true")
	//					.withAppPackage("net.bloomz")
	//					.withAppActivity("md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity")
						.build();

			}
			return browser;

		} else if (Boolean.parseBoolean(Config.getConfigData("platform.ios")) == true) {
			MobileBrowser browser = MobileBrowserBuilder.getIOSBuilder("http://0.0.0.0:4725/wd/hub")
					.withTimeoutsConfig(timeouts).withVersion("1.0").withPlatform("MAC")
					.withPlatformName(MobilePlatformName.IOS).withPlatformVersion("5.0").withDeviceName("Moto G")
					.withApp("/Users/Moolya21/Documents/Bloomz/base.apk").withAppPackage("net.bloomz")
					.withAppActivity("md50650226ac6f52b09d4ba74196a0cfcac.SplashActivity").build();
			return browser;

		} else if (platformName.equals("Web")) {
			WebBrowser browser;
			//String baseTestUrl ;
			
			if(urltype.equals("staging"))
			{
				baseTestUrl = Config.getConfigData("bloomz_base_test_url_staging");
			}
			else
			{
				baseTestUrl = Config.getConfigData("bloomz_base_test_url_feature");			
			}
			
			if (environment.equals("local")) {
				String chromeDriverLocation = Config.getConfigData("chrome_driver_location");
				
				System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

				if (browserType.equals(WebBrowserType.CHROME.toString())) {
					browser = LocalBrowserBuilder
							.getBuilder(WebBrowserType.CHROME, baseTestUrl)
							.withBrowserBinaryPath(chromeDriverLocation).build();
					((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());
					return browser;

				} else if (browserType.equals(WebBrowserType.SAFARI.toString())) {

					browser = LocalBrowserBuilder.getBuilder(WebBrowserType.SAFARI,
							baseTestUrl).build();
					((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());
					return browser;
				}
			} else if (environment.equals("cloud")) {
				browser = RemoteBrowserBuilder.getBuilder(WebBrowserType.valueOf(browserType),
						baseTestUrl, URL).build();
				((WebBrowser) browser).openPageByURL(browser.getBaseTestUrl());
				return browser;
			}

		}
		return null;
	}

	@Parameters({ "platformName", "browserType", "environment","urltype" })
	@BeforeMethod(alwaysRun = true)
	public void startMethod(Method method, String platformName, String browserType, String environment, String urltype)
			throws IWebDriverException {
				
		if(browser==null)
		{
			browser = createBrowser(platformName, browserType, environment,urltype);
		}
		
		logger.info("****************************************************************************************");

		logger.info("****************************************************************************************");

		logger.info("$$$$$$$$$$$$$$$$$$$$$          " + method.getName() + "          $$$$$$$$$$$$$$$$$$$$$$$$$");

		logger.info("****************************************************************************************");

		logger.info("****************************************************************************************");

	}

	@AfterMethod(alwaysRun = true)
	public void stopMethod(ITestResult result) {
		String string = browser.toString();
		if (string.contains("Android")) {
			((AndroidDriver) browser.getWebDriver()).resetApp();
		}
		if (browser != null) {
			browser.quit();
			browser = null ;
		}

		logger.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

		logger.info("X");

		logger.info("X");

		logger.info("X");

		logger.info("X");

	}

	public String getPlatform() {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("Android")) {
			System.out.println("Driver Instance : "
					+ browser.getDesiredCapabilities().getCapability("platformName").toString());
			return browser.getDesiredCapabilities().getCapability("platformName").toString();

		}
		return "";

	}

	public String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy-h-mm-ss-a");
		return sdf.format(date);
	}

	public boolean waitForAnElement(By locator) {
		WebElement waitOnExpectedCondition = browser.getActions().waitOnExpectedCondition(
				ExpectedConditions.visibilityOfElementLocated(locator), "Element is not visible",
				TimeoutType.FORTY_SECONDS);
		return waitOnExpectedCondition.isDisplayed();
	}
}
