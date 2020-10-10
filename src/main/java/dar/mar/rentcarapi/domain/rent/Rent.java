package dar.mar.rentcarapi.domain.rent;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import dar.mar.rentcarapi.web.validator.Hour;
import dar.mar.rentcarapi.web.rent.model.UpdateRentRq;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Rent {

    private Integer id;
    private LocalDate rentDate;
    @Hour
    private int rentHour;
    private Integer rentPrice;
    private int carClient;
    private int car;

    public void updateRent(UpdateRentRq rq) {
        this.rentDate = rq.getRentDate();
        this.rentHour = rq.getRentHour();
    }
}
