package dar.mar.rentcarapi.domain.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Car {

    private Integer id;
    private String mark;
    private String type;
    private LocalDate buildYear;
    private Integer distance;
    private String colour;
}
