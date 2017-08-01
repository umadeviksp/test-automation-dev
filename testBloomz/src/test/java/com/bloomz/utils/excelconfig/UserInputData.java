package com.bloomz.utils.excelconfig;

public class UserInputData {

  String emailId;
  String password;
  String stagingUrl;
  String userType1;
  String userType2;
  String passwordForUserOnBoard;
  String zipCode;

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserType1() {
    return userType1;
  }

  public void setUserType1(String userType1) {
    this.userType1 = userType1;
  }

  public String getUserType2() {
    return userType2;
  }

  public void setUserType2(String userType2) {
    this.userType2 = userType2;
  }

  public String getStagingUrl() {
    return stagingUrl;
  }

  public void setStagingUrl(String stagingUrl) {
    this.stagingUrl = stagingUrl;
  }

  public String getPasswordForUserOnBoard() {
    return passwordForUserOnBoard;
  }

  public void setPasswordForUserOnBoard(String passwordForUserOnBoard) {
    this.passwordForUserOnBoard = passwordForUserOnBoard;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
}
