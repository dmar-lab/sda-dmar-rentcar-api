package dar.mar.rentcarapi.external.rent;

import dar.mar.rentcarapi.external.car.CarEntity;
import dar.mar.rentcarapi.external.carclient.CarClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "rents")
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate rentDate;
    private int rentHour;
    private Integer rentPrice;
//    private Integer carId;    te pola powodowaly duplikacje
//    private Integer carClientId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "car_client_id")
    private CarClientEntity carClient;

    public void changeRentTime(LocalDate date, int rentHour) {
        this.rentDate = date;
        this.rentHour = rentHour;
    }
}
