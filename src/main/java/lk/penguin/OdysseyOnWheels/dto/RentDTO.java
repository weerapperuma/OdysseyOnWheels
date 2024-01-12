package lk.penguin.OdysseyOnWheels.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDTO {
    private String rentId;
    private String customerId;
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDate rentStarting;
    private LocalDate rentEnding;
    private LocalDate orderDate;
}
