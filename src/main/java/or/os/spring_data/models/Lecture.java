package or.os.spring_data.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {

    private String title;


    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section sections;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

}
