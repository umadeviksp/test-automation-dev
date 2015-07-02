from BaseUnitTest import *

class SignInTests(BaseUnitTest):
    #with open('Signin.txt', 'r') as inf:
        #data_dict= eval(inf.read())

    def setUp(self):
        self.launchApp()

    def tearDown(self):
        self.driver.quit()


    def testIsAppLaunched(self):
        self.assertTrue(self.is_element_present(By.NAME, "Sign In"))


    def testSignInSuccess(self):
        self.signIn("cc74@test.com", "bloomz999")
        self.assertTrue(self.is_element_present(By.XPATH, "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]"))
        self.SignOut()

    def testSignInUserNameEmpty(self):
        self.signIn("", "bloomz999")
        self.assertTrue(self.is_element_present(By.NAME, "All fields are mandatory."))

    def testSignInPasswordEmpty(self):
        self.signIn("cc74@test.com", "")
        self.assertTrue(self.is_element_present(By.NAME, "All fields are mandatory."))

    def testSignInInvalidPassword(self):
        self.signIn("cc74@test.com", "invalid")
        self.assertTrue(self.is_element_present(By.NAME, "Login Failed"))

    def testAppbackgroundAndForeground(self):
        self.signIn("cc74@test.com", "bloomz999")
        self.assertTrue(self.is_element_present(By.NAME, "Updates"))
        self.WaitForAnimationToComplete()
        self.driver.background_app(4)
        # self.driver.find_element_by_name("Settings").click()
        # time.sleep(2)
        # self.driver.launch_app()
