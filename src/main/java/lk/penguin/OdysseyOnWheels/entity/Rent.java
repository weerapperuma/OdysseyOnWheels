package lk.penguin.OdysseyOnWheels.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rent {
    private String rentId;
    private String customerId;
    private String pickupLocation;
    private String dropOffLocation;
    private LocalDate rentStarting;
    private LocalDate rentEnding;
    private LocalDate orderDate;
}