package java_ecommerce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cart {

    private Customer customer;
    private UUID discountId;
    private Map<Product,Integer> productMap;


    public Double calculateCartTotalAmount(){
        double totalAmount = 0;
        for (Product product : productMap.keySet()){
            totalAmount += product.getPrice() * productMap.get(product);

        }
        return totalAmount;
    }



}
