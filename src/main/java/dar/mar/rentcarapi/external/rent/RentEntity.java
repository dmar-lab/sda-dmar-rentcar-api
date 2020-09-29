package dar.mar.rentcarapi.external.rent;

import dar.mar.rentcarapi.external.car.CarEntity;
import dar.mar.rentcarapi.external.carclient.CarClientEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "rents")
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentNo;
    private LocalDate rentDate;
    private LocalTime rentHour; // pozor!
    private Integer rentPrice;
//    private Integer carId;    te pola powodowaly duplikacje
//    private Integer carClientId;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "car_client_id")
    private CarClientEntity carClient;
}
