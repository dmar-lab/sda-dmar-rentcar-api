package dar.mar.rentcarapi.web.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SearchParams {
    private String mark;
    private String type;
    private LocalDate buildYear;
//    po tych nie wyszukujemy
//    private Integer distance;
//    private String colour;
}
