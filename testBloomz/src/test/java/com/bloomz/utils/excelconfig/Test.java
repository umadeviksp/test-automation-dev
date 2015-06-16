package com.bloomz.utils.excelconfig;

import com.bloomz.tests.BaseTest;

public class Test {

	public static void main(String[] args) {
		BaseTest date = new BaseTest();
		String currentTimeStamp = date.getCurrentTimeStamp();
		System.out.println(currentTimeStamp);
	}

}
