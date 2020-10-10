package dar.mar.rentcarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Jesli chcemy zmienic pakiet bazowy dla naszej appki Springowej
//@ComponentScan(basePackages = "pl.sda")
public class RentcarApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentcarApiApplication.class, args);
    }

}
// zwykle merguje ten ktoremu ten branch jest potrzebny
