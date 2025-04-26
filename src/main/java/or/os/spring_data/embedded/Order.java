package or.os.spring_data.embedded;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {
    @EmbeddedId
    private OrderId id;
    private String product;
    private int quantity;
    private double price;
}
