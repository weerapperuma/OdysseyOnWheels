package lk.penguin.OdysseyOnWheels.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    private String vehicleId;
    private String vehicleType;
    private String VehicleName;
    private String perDay80Km;
    private String excessMileage;
    private Integer status;
}
