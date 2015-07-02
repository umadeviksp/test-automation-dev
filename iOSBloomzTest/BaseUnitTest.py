import unittest
from appium import webdriver
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoSuchElementException
import time

class BaseUnitTest(unittest.TestCase):
    def launchApp(self):
        desired_caps = {}
        desired_caps['platformName'] = 'iOS'
        desired_caps['platformVersion'] = '8.1'
        desired_caps['deviceName'] = 'iPhone 5s'
        desired_caps['app'] = ('/Users/nancymallick/android/Bloomz.iOS/bin/iPhoneSimulator/Debug/BloomziOS.app')
        self.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)
        self.driver.implicitly_wait(5)

    def is_element_present(self, how, what):
        try:
            self.driver.find_element(by=how, value=what)
        except NoSuchElementException:
            return False
        return True

    def signIn(self, userName, password):
        self.driver.find_element_by_name("Sign In").click()
        self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").send_keys(userName)
        self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").send_keys(password)
        self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]").click()
        time.sleep(4)

    def SignOut(self):
        self.driver.find_element_by_name("menulogo").click()
        self.clickElementByNameAndVisibility("setting")
        self.clickElementByNameAndVisibility("Sign Out")
        self.clickElementByNameAndVisibility("Sign Out")

    def WaitForAnimationToComplete(self):
        time.sleep(6)

    def clickElementByNameAndVisibility(self, name):
        elements = self.driver.find_elements_by_name(name)
        for element in elements:
            if element.is_displayed() and element.is_enabled():
                element.click()
                break

    def locateElement(self, name):
        elements = self.driver.find_elements_by_name(name)
        for element in elements:
            if element.is_displayed() or element.is_enabled():
                return element

