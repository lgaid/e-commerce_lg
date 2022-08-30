package java_ecommerce;


import category.Category;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Product {

    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer remainingStock;
    private UUID categoryId;




    public String getCategoryName() throws Exception {

        for (Category category : StaticConstants.CATEGORY_LIST) {
            if (getCategoryId().toString().equals(category.getId().toString())) {
                return category.getName();
            }
        }

        throw new Exception("Category not found, " + getName());


    }


    public LocalDateTime getDeliveryDueDate() throws Exception {
        for (Category category : StaticConstants.CATEGORY_LIST) {
            if (getCategoryId().toString().equals(getCategoryId().toString())) {
                return category.findDeliveryDueDate();
            }
        }
        throw new Exception("Category not found");
    }


}
