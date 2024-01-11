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
    private Double perDay80Km;
    private Double excessMileage;
    private Integer status;
}
