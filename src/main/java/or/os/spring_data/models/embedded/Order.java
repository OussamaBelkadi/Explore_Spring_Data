package or.os.spring_data.models.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_order")
public class Order {
    @EmbeddedId
    private OrderId id;
    @Embedded
    private Address address;
    private String product;
    private int quantity;
    private double price;

    @PrePersist
    private void prePersist() {
        address.setCity("Safi");
        System.out.println("PrePersist: " + this);
    }
}
