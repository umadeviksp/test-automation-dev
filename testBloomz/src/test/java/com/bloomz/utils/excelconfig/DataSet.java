package com.bloomz.utils.excelconfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class DataSet.
 */
public class DataSet {

  /**
   * Gets the environment data.
   *
   * @param environmentSetting the environment setting
   * @return the environment data
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void getEnvironmentData(EnvironmentSetting environmentSetting, String filePath)
      throws IOException {

    // Build reader instance
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    try {

      br = new BufferedReader(new FileReader(filePath));
      while ((line = br.readLine()) != null) {
        // use comma as separator
        String[] country = line.split(cvsSplitBy);
        environmentSetting.setAppiumVersion(country[0].toString());
        environmentSetting.setPlatformVersion(country[1].toString());
        environmentSetting.setPlatformName(country[2].toString());
        environmentSetting.setDeviceName(country[3].toString());
        environmentSetting.setAppPath(country[4].toString());
        environmentSetting.setAppPackage(country[5].toString());
        environmentSetting.setAppActivity(country[6].toString());
        environmentSetting.setServerAddress(country[7].toString());
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  /**
   * Gets the user input data.
   *
   * @param userInputData the user input data
   * @return the user input data
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static void getUserInputData(UserInputData userInputData, String filePath)
      throws IOException {

    // Build reader instance
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    try {

      br = new BufferedReader(new FileReader(filePath));
      while ((line = br.readLine()) != null) {
        // use comma as separator
        String[] country = line.split(cvsSplitBy);
        userInputData.setEmailId(country[0].toString());
        userInputData.setPassword(country[1].toString());
        userInputData.setStagingUrl(country[2].toString());
        userInputData.setUserType1(country[3].toString());
        userInputData.setUserType2(country[4].toString());
        userInputData.setPasswordForUserOnBoard(country[5].toString());
        userInputData.setZipCode(country[6].toString());
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

}
