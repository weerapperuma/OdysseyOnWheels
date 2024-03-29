package lk.penguin.OdysseyOnWheels.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String userId;
    private String userName;
    private String userNIC;
    private int userMobile;
    private String  userEmail;
    private String userPassword;
}
