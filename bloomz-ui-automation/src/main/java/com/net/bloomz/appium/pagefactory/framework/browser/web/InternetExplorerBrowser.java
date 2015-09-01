package com.net.bloomz.appium.pagefactory.framework.browser.web;

import java.util.Optional;
import java.util.logging.Level;

import javax.annotation.Nullable;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.net.bloomz.appium.pagefactory.framework.actions.InternetExplorerActions;
import com.net.bloomz.appium.pagefactory.framework.config.TimeoutsConfig;
import com.net.bloomz.appium.pagefactory.framework.exception.IWebDriverException;

public class InternetExplorerBrowser extends WebBrowser {
	public InternetExplorerBrowser(String baseTestUrl, TimeoutsConfig timeouts, Optional<String> driverPath,
			Optional<String> browserBinaryPath, Optional<String> browserVersion, Optional<String> browserLocale,
			Optional<Integer> startWindowWidth, Optional<Integer> startWindowHeight, Optional<Level> browserLogLevel,
			Optional<String> browserLogFile, Optional<Platform> platform) {
		super(baseTestUrl, timeouts, driverPath, browserBinaryPath, browserVersion, browserLocale, startWindowWidth,
				startWindowHeight, browserLogLevel, browserLogFile, platform);
	}

	private static String convertJavaLogLevelToIeLogLevel(String javaLogLevel) {
		if ("WARN".equals(javaLogLevel)) {
			javaLogLevel = "WARNING";
		}
		Level javaLevel = Level.parse(javaLogLevel);
		if (Level.ALL.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.TRACE.toString();
		} else if (Level.CONFIG.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.TRACE.toString();
		} else if (Level.FINE.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.DEBUG.toString();
		} else if (Level.FINER.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.TRACE.toString();
		} else if (Level.FINEST.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.TRACE.toString();
		} else if (Level.INFO.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.INFO.toString();
		} else if (Level.OFF.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.FATAL.toString();
		} else if (Level.SEVERE.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.ERROR.toString();
		} else if (Level.WARNING.equals(javaLevel)) {
			return InternetExplorerDriverLogLevel.WARN.toString();
		}
		return InternetExplorerDriverLogLevel.INFO.toString();
	}

	@Override
	public WebBrowserType getBrowserType() {
		return WebBrowserType.IE;
	}

	@Override
	public DesiredCapabilities getDesiredCapabilities() {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();

		setCommonWebBrowserCapabilities(desiredCapabilities);

		desiredCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

		Level logLevel = getLogLevel();
		desiredCapabilities.setCapability(InternetExplorerDriver.LOG_LEVEL,
				convertJavaLogLevelToIeLogLevel(logLevel.toString()));

		Optional<String> browserLogFile = getBrowserLogFile();
		if (browserLogFile.isPresent() && !browserLogFile.get().isEmpty()) {
			desiredCapabilities.setCapability(InternetExplorerDriver.LOG_FILE, browserLogFile.get());
		}

		return desiredCapabilities;
	}

	@Override
	public InternetExplorerActions getActions() {
		return new InternetExplorerActions(this);
	}

	@Override
	protected WebDriver createWebDriver() throws IWebDriverException {
		return new InternetExplorerDriver(getDesiredCapabilities());
	}

	@Nullable
	public LogEntries getBrowserLogEntries() {
		return null; // Can't get Console logs for Internet Explorer, at least
						// not remotely.
	}
}
