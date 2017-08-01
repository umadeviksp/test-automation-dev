package com.bloomz.utils.excelconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

  /**
   * Gets the cell text.
   *
   * @param sheetAt the sheet at
   * @param row the row
   * @param cell the cell
   * @return the cell text
   */
  public static String getCellText(XSSFSheet sheetAt, int row, int cell) {

    return sheetAt.getRow(row).getCell(cell).getStringCellValue();
  }

  /**
   * Gets the cell link.
   *
   * @param sheetAt the sheet at
   * @param row the row
   * @param cell the cell
   * @return the cell link
   */
  public static String getCellLink(XSSFSheet sheetAt, int row, int cell) {

    return String.valueOf(sheetAt.getRow(row).getCell(cell).getHyperlink());
  }

  /**
   * Gets the cell num.
   *
   * @param sheetAt the sheet at
   * @param row the row
   * @param cell the cell
   * @return the cell num
   */
  public static String getCellNum(XSSFSheet sheetAt, int row, int cell) {

    return String.valueOf(sheetAt.getRow(row).getCell(cell).getNumericCellValue());
  }

  /**
   * Gets the environment.
   *
   * @param environmentSetting the environment setting
   * @return the environment
   */
  public static void getEnvironment(EnvironmentSetting environmentSetting) {
    try {
      FileInputStream file =
          new FileInputStream(new File(
              "/Users/Moolya21/Desktop/Bloomz/testBloomz/src/test/resources/DataSheet.xlsx"));

      XSSFWorkbook workbook = new XSSFWorkbook(file);
      XSSFSheet sheetAt = workbook.getSheetAt(0);
      if (getCellText(sheetAt, 0, 1).equals("YES")) {
        environmentSetting.setAppiumVersion(getCellNum(sheetAt, 1, 1));
        environmentSetting.setPlatformName(getCellText(sheetAt, 2, 1));
        environmentSetting.setPlatformVersion(getCellNum(sheetAt, 3, 1));
        environmentSetting.setDeviceName(getCellText(sheetAt, 4, 1));
        environmentSetting.setAppPath(getCellText(sheetAt, 5, 1));
        environmentSetting.setAppPackage(getCellText(sheetAt, 6, 1));
        environmentSetting.setAppActivity(getCellText(sheetAt, 7, 1));
        environmentSetting.setServerAddress(getCellText(sheetAt, 8, 1));

      } else if (getCellText(sheetAt, 10, 1).equals("YES")) {
        environmentSetting.setAppiumVersion(getCellNum(sheetAt, 11, 1));
        environmentSetting.setPlatformName(getCellText(sheetAt, 12, 1));
        environmentSetting.setPlatformVersion(getCellNum(sheetAt, 13, 1));
        environmentSetting.setDeviceName(getCellText(sheetAt, 14, 1));
        environmentSetting.setAppPath(getCellText(sheetAt, 15, 1));
        environmentSetting.setAppPackage(getCellText(sheetAt, 16, 1));
        environmentSetting.setAppActivity(getCellText(sheetAt, 17, 1));
        environmentSetting.setServerAddress(getCellText(sheetAt, 18, 1));
      }
      workbook.close();
      file.close();

    } catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
