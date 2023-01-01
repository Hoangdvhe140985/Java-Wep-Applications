package utils;

import java.sql.Date;

public class Validator {
	private static final String REGEX_PHONE = "^[0]{1}[0-9]{9}$";
	public static boolean validateStringLength(String input) {
		return input.length() <= 50;
	}
	
	public static boolean validatePhone(String phone) {
		return phone.matches(REGEX_PHONE);
	}
	
	public static boolean validateFromDateAndToDate(Date fromDate, Date toDate) {
		return fromDate.before(toDate);
	}
	
	public static boolean isIntNumber(String numberStr) {
		boolean flag = true;
		if(numberStr.length() <= 20) {
			try {
				int number = Integer.parseInt(numberStr);
			} catch (Exception e) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}
}
