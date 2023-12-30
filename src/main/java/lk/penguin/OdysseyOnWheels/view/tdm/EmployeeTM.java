package lk.penguin.OdysseyOnWheels.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeTM {
    private String employeeId;
    private String employeeName;
    private String empEmail;
    private String empNIC;
    private String empPosition;
    private String empAddress;
    private String empContact;
}