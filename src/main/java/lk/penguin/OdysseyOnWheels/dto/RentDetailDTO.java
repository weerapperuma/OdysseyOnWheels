package lk.penguin.OdysseyOnWheels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDetailDTO {
    private String primaryID;
    private String rentId;
    private String vehicleId;
    private Double rentFee;
    private Double excessMileageCost;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private LocalDate orderDate;
}
