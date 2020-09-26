package dar.mar.rentcarapi.domain.carclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarClient {
    private Integer id;
    private String name;
    private String surname;
    private String drivingLicenceNo;
    private String nationality;
    private String creditCardNo;
}
