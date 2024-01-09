package lk.penguin.OdysseyOnWheels.util;

import javafx.scene.control.Alert;

import java.util.regex.Pattern;

public class REGEXUtil {
    public static boolean validateEmail(String inputEmail){
        boolean isEmpEmailValidated=Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$").matcher(inputEmail).matches();
        if(isEmpEmailValidated){
            return true;
        }
        return false;
    }
    public static boolean validateAddress(String adddress){
        boolean isAddressValidated=Pattern.compile("^[a-zA-Z, ]{1,100}$").matcher(adddress).matches();
        if(isAddressValidated){
            return true;
        }
        return false;
    }
    public static boolean validateContact(String contact){
        boolean isContactValidated=Pattern.compile("^[0-9]{1,}$").matcher(contact).matches();
        if(isContactValidated){
            return true;
        }
        return false;
    }



}
