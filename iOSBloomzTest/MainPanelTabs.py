from BaseUnitTest import *

class MainPanelTabs(BaseUnitTest):

    def setUp(self):
        self.launchApp()
        self.signIn("cc74@test.com", "bloomz999")

    def tearDown(self):
        self.SignOut()
        self.driver.quit()

    def testHomeTab(self):
        self.driver.find_element_by_xpath(" //UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton[1]").click()
        self.WaitForAnimationToComplete()
        self.assertTrue(self.is_element_present(By.XPATH, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]") or self.is_element_present(By.NAME, "Upcoming Events"))


    def testCalendarTab(self):
        self.driver.find_element_by_name("My Calendar").click()
        self.WaitForAnimationToComplete()
        self.assertTrue(self.driver.find_element_by_name("Today").is_displayed() or self.driver.find_element_by_name("Invitations").is_displayed())


    def testMessageTab(self):
        self.driver.find_element_by_name("Messages").click()
        self.WaitForAnimationToComplete()
        #assert working for teacher account only rite now
        self.assertTrue(self.driver.find_element_by_name("Get in touch instantly!").is_displayed())


    def testVolunteerTab(self):
        self.driver.find_element_by_name("Volunteer").click()
        self.WaitForAnimationToComplete()
        self.assertTrue(self.driver.find_element_by_name("Volunteer Asks").is_displayed())


    def testContactsTab(self):
        self.driver.find_element_by_name("My Contacts").click()
        self.WaitForAnimationToComplete()
        self.assertTrue(self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]").is_displayed())


    def testSwitchBetweenTabs(self):
        self.testCalendarTab()
        self.testMessageTab()
        self.testVolunteerTab()
        self.testHomeTab()
        self.testContactsTab()


    def testScrollInExistingPost(self):
        self.assertTrue(self.is_element_present(By.NAME, "Updates") or self.is_element_present(By.NAME, "Upcoming Events"))
        self.assertTrue(self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]").is_displayed())
        time.sleep(2)
        el = self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[5]")
        self.driver.execute_script("mobile: scrollTo", {"element": el.id})
        time.sleep(2)

    def testScrollInCalendarFeed(self):
        self.driver.find_element_by_name("My Calendar").click()
        self.WaitForAnimationToComplete()
        self.assertTrue(self.driver.find_element_by_name("Today").is_displayed() or self.driver.find_element_by_name("Invitations").is_displayed())
        time.sleep(2)
        el = self.driver.find_element_by_xpath(" //UIAApplication[1]/UIAWindow[1]/UIATableView[3]/UIATableGroup[9]")
        self.driver.execute_script("mobile: scrollTo", {"element": el.id})
        time.sleep(2)