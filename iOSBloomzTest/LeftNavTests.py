from BaseUnitTest import *

class LeftNavTests(BaseUnitTest):

    def setUp(self):
        self.launchApp()
        self.signIn("cc74@test.com", "bloomz999")

    def tearDown(self):
        self.SignOut()
        self.driver.quit()

    def testClassLaunch(self):
        self.driver.find_element_by_name("menulogo").click()
        self.driver.find_element_by_xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIAStaticText[1]").click()
        self.assertTrue(self.is_element_present(By.NAME, "Updates") or self.is_element_present(By.NAME, "Upcoming Events"))
        time.sleep(2)