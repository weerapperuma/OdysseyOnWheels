package lk.penguin.rentalWheelzAI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierOrderDetail {
    private String orderId;
    private String supId;
    private BigDecimal amount;
}