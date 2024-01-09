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
    
}
