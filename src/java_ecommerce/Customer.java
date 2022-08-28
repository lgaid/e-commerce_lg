package java_ecommerce;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class Customer {

    private UUID id;

    private String userName;

    private  String email;

    private List<Address> address;


    public Customer(UUID id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }



}
