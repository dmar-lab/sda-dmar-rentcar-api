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

    /* 
    public static CarClient builder(Integer id,
                                    String name,
                                    String surname,
                                    String drivingLicenceNo,
                                    String nationality,
                                    String creditCardNo)
    {
        if (name.matches("\\d")){
            throw new IllegalArgumentException("Your name cannot contain a number");
        }
        if (surname.matches("\\d")){
            throw new IllegalArgumentException("Your surname cannot contain a number");
        }
        if(!drivingLicenceNo.matches("^\\d{5}/\\d{2}/\\d{4}$")){
            throw new IllegalArgumentException("Your driving licence has invalid format");
        }
        if (nationality.matches("\\d")){
            throw new IllegalArgumentException("Your nationality cannot contain a number");
        }
        if (creditCardNo.matches("^[0-9\\s]{16,19}$")){
            throw  new IllegalArgumentException("Your credit card number is invalid");
        }
        return  new CarClient(id,name,surname,drivingLicenceNo,nationality,creditCardNo);
    } */
}
