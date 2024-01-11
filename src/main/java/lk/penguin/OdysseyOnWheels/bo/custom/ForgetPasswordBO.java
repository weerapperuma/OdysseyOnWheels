package lk.penguin.OdysseyOnWheels.bo.custom;

import lk.penguin.OdysseyOnWheels.bo.SuperBO;

public interface ForgetPasswordBO extends SuperBO {
    String getOTP();

    boolean update(String passportId, String text);
}
