package checkout;

import balance.Balance;
import balance.CustomerBalance;
import balance.GiftCardBalance;
import java_ecommerce.Customer;
import java_ecommerce.StaticConstants;

import java.util.UUID;

public class MixPaymentCheckoutServiceImpl implements CheckOutService {

    public boolean checkout(Customer customer, Double totalAmount){

        try{
            GiftCardBalance giftCardBalance = findGiftCardBalance(customer.getId());

            final double giftBalance = giftCardBalance.getBalance() - totalAmount;
            if (giftBalance > 0) {
                giftCardBalance.setBalance(giftBalance);
            }else{
                CustomerBalance customerBalance = findCustomerBalance(customer.getId());
                final  double mixBalance = giftCardBalance.getBalance() + customerBalance.getBalance() - totalAmount;
                if (mixBalance > 0) {
                    giftCardBalance.setBalance(0d);
                    customerBalance.setBalance(mixBalance);

                    return true;
                }

            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;

    }


    private static GiftCardBalance findGiftCardBalance(UUID customerId){
        for (Balance giftCardBalance : StaticConstants.GiftCard_Balance_List) {
            if (giftCardBalance.getCustomerId().toString().equals(customerId.toString())) {
                return (GiftCardBalance) giftCardBalance;
            }
        }

        GiftCardBalance giftCardBalance = new GiftCardBalance(customerId,0d);
        StaticConstants.GiftCard_Balance_List.add(giftCardBalance);

        return giftCardBalance;

    }

    private static CustomerBalance findCustomerBalance(UUID customerId) {
        for (Balance customerBalance : StaticConstants.Customer_Balance_List) {
            if (customerBalance.getCustomerId().toString().equals(customerId.toString())) {
                return (CustomerBalance) customerBalance;
            }
        }

        CustomerBalance customerBalance = new CustomerBalance(customerId,0d);
        StaticConstants.Customer_Balance_List.add(customerBalance);

        return customerBalance;

    }

}
