package checkout;


import java_ecommerce.Customer;

public interface CheckOutService {

    boolean checkout(Customer customer, Double totalAmount);



}
