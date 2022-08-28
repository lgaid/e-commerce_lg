package category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Category {

    private UUID id;
    private String name;



    public abstract LocalDateTime findDeliveryDueDate();

    public String generateCategoryCode(){
        return id.toString().substring(0,8).concat("-").concat(name.substring(0,2));
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }






}
