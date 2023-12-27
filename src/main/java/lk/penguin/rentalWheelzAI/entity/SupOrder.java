package lk.penguin.rentalWheelzAI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupOrder {
    private String orderId;
    private LocalDate date;
    private BigDecimal amount1;
    private BigDecimal amount2;
    private BigDecimal totalAmount;
}
