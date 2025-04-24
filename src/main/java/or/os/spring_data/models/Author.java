package or.os.spring_data.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Author {
    @Id
//    @GeneratedValue
//    private UUID id;
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}

