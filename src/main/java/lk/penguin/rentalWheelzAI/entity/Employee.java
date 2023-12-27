package lk.penguin.rentalWheelzAI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private String employeeId;
    private String employeeName;
    private String empEmail;
    private String empNIC;
    private String empPosition;
    private String empAddress;
    private String empContact;
}
