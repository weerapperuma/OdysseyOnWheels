package lk.penguin.OdysseyOnWheels.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTM {
    private String userId;
    private String userName;
    private String userNIC;
    private String userMobile;
    private String userEmail;
    private String userPassword;
}
