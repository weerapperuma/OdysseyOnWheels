package lk.penguin.OdysseyOnWheels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String vehicleId;
    private String vehicleType;
    private String VehicleName;
    private String perDay80Km;
    private String excessMileage;
}
