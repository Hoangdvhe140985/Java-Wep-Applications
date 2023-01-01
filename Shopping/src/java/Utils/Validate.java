/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author hoang
 */
public class Validate {

    private static final String REGEX_PHONE = "^[0]{1}[0-9]{9}$";

    public static boolean validateStringLength(String input) {
        return input.length() <= 50;
    }

    public static boolean validatePhone(String phone) {
        return phone.matches(REGEX_PHONE);
    }

    public static boolean isIntNumber(String numberStr) {
        boolean flag = true;
        if (numberStr.length() <= 20) {
            try {
                int number = Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }
    
    
}
