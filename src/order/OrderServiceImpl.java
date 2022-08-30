package order;

import checkout.CheckOutService;
import checkout.CustomerBalanceCheckOutServiceImpl;
import checkout.MixPaymentCheckoutServiceImpl;
import discount.Discount;
import java_ecommerce.Cart;


import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

import static java_ecommerce.StaticConstants.DISCOUNT_LIST;
import static java_ecommerce.StaticConstants.ORDER_LIST;

public class OrderServiceImpl implements OrderService {


    @Override
    public String placeOrder(Cart cart) {
        double amountAfterDiscount = cart.calculateCartTotalAmount();

        if (cart.getDiscountId() != null) {
            try {
                Discount discount = findDiscountById(cart.getDiscountId());
                amountAfterDiscount = discount.calculateCartAmountAfterDiscountApplied(amountAfterDiscount);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("What payment option would you like to use, Type 1 : Customer Balance, Type 2: Mix (gift card + customer balance )");
        int paymentType = scanner.nextInt();
        boolean checkOutResult = false;

        switch (paymentType) {

            case 1:
                CheckOutService customerBalanceCheckOutService = new CustomerBalanceCheckOutServiceImpl();
                checkOutResult = customerBalanceCheckOutService.checkout(cart.getCustomer(), amountAfterDiscount);

                break;

            case 2:
                CheckOutService mixPaymentCheckoutService = new MixPaymentCheckoutServiceImpl();
                checkOutResult = mixPaymentCheckoutService.checkout(cart.getCustomer(), amountAfterDiscount);

                break;


        }


        if (checkOutResult) {
            Order order = new Order(UUID.randomUUID(), LocalDateTime.now(),
                    cart.calculateCartTotalAmount(), amountAfterDiscount,
                    cart.calculateCartTotalAmount() - amountAfterDiscount,
                    cart.getCustomer().getId(), "Placed", cart.getProductMap().keySet());
            ORDER_LIST.add(order);
            return "Order has been placed successfully";
        } else {

            return "Insufficient Balance. Please add more funds to your payment method and try again";
        }

    }


    private Discount findDiscountById(UUID discountId) throws Exception {

        for (Discount discount : DISCOUNT_LIST) {
            if (discount.getId().toString().equals(discountId.toString())) {
                return discount;
            }

        }

        throw new Exception("Discount not found");

    }



}
