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
            strategy = GenerationType.TABLE,
            generator = "author_tab"
    )
    @TableGenerator(
            name = "author_tab",
            table = "author_tab",
            pkColumnName = "seq_name",
            valueColumnName = "seq_count",
            pkColumnValue = "author_seq",
            allocationSize = 1
    )
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
}

