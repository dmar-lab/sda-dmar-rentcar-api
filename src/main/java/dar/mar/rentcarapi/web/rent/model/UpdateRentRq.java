package dar.mar.rentcarapi.web.rent.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
public class UpdateRentRq {

    private int id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate rentDate;
    private int rentHour;
}
