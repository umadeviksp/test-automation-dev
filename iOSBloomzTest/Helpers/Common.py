import unittest
from appium import webdriver
import time


class Common:
    def launchApp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'iOS'
        desired_caps['platformVersion'] = '8.1'
        desired_caps['deviceName'] = 'iPhone 5s'
        desired_caps['app'] = ('/Users/nancymallick/android/Bloomz.iOS/bin/iPhoneSimulator/Debug/BloomziOS.app')
        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)
