package discount;

import java.util.UUID;

public class AmountBasedDiscount extends Discount {


    private Double discountAmount;

    public AmountBasedDiscount(UUID id, String discountName, Double thresholdAmount, Double discountAmount) {
        super(id, discountName, thresholdAmount);
        this.discountAmount = discountAmount;
    }

    @Override
    public Double calculateCartAmountAfterDiscountApplied(Double amount) {
        return amount - discountAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }



}
