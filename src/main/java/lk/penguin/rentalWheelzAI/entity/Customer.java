package lk.penguin.rentalWheelzAI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
   private String customerNIC;
   private String customerName;
   private String customerCountry;
   private String customerEmail;
}
