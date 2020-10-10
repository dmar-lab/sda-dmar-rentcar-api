package dar.mar.rentcarapi.external.carclient;

import dar.mar.rentcarapi.domain.carclient.CarClient;
import dar.mar.rentcarapi.external.rent.RentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
// import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "car_clients")
public class CarClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    @Column(length = 20, unique = true)
    private String drivingLicenceNo;

    private String nationality;

    @Column(length = 16, unique = true)
    private String creditCardNo;

    @OneToMany(mappedBy = "carClient")
    private Set<RentEntity> rents;

    public void updateFromDomain(CarClient carClient) {
        this.name = carClient.getName();
        this.surname = carClient.getSurname();
        this.drivingLicenceNo = carClient.getDrivingLicenceNo();
        this.nationality = carClient.getNationality();
        this.creditCardNo = carClient.getCreditCardNo();
    }
}
