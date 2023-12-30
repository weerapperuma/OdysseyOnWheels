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
    private BigDecimal rentFirstAmount;
    private BigDecimal rentSecondAmount;
    private BigDecimal rentTotalAmount;
    private LocalDate rentStarting;
    private LocalDate rentEnding;
}
