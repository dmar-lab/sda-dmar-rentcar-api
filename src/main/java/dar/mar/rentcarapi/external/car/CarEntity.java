package dar.mar.rentcarapi.external.car;

import dar.mar.rentcarapi.external.rent.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mark;
    private String type;
    private LocalDate buildYear;
    private Integer distance;
    private String colour;

    @OneToMany(mappedBy = "car")
    private Set<RentEntity> rents;
}
