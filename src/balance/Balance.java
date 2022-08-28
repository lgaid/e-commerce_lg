package balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Balance {

    private UUID customerId;
    private Double balance;

    public abstract Double addBalance(Double additionalBalance);





}
