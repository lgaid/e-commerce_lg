package java_ecommerce;


import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer remainingStock;
    private UUID categoryId;






}
