package checkout;

import balance.Balance;
import balance.CustomerBalance;
import java_ecommerce.Customer;
import java_ecommerce.StaticConstants;

import java.util.UUID;

public class CustomerBalanceCheckOutServiceImpl implements CheckOutService {



    public boolean checkout(Customer customer, Double totalAmount){
        CustomerBalance customerBalance = findCustomerBalance(customer.getId());
        double finalBalance = customerBalance.getBalance() - totalAmount;
        if (finalBalance > 0) {
            customerBalance.setBalance(finalBalance);
            return true;
        }
        return false;
    }

    private static CustomerBalance findCustomerBalance(UUID customerId){
        for (Balance customerBalance: StaticConstants.Customer_Balance_List) {
            if (customerBalance.getCustomerId(). toString().equals(customerId.toString())) {
                return (CustomerBalance) customerBalance;

            }
        }

        CustomerBalance customerBalance = new CustomerBalance(customerId,0d);
        StaticConstants.Customer_Balance_List.add(customerBalance);

        return customerBalance;
    }




}
