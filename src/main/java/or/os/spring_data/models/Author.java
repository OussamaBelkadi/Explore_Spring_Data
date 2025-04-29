package or.os.spring_data.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper = true)
@NamedQuery(
        name = "Author.findAllByNamedQueries",
        query = "select a from Author a where a.age = :age"
)
public class Author extends BaseEntity{
//    @Id
//    @GeneratedValue
//    private UUID id;
//    @GeneratedValue(
//            strategy = GenerationType.TABLE,
//            generator = "author_tab"
//    )
//    @TableGenerator(
//            name = "author_tab",
//            table = "author_tab",
//            pkColumnName = "seq_name",
//            valueColumnName = "seq_count",
//            pkColumnValue = "author_seq",
//            allocationSize = 1
//    )
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )
//    private Integer id;

    @Column
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;
    @Column(updatable = false)
    private LocalDate createdAt;
    @Column(insertable = false)
    private LocalDate updatedAt;
    @ManyToMany(mappedBy = "authors")
    private Set<Course> courses;
}

