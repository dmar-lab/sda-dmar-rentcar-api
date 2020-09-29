package dar.mar.rentcarapi.web.car;

import dar.mar.rentcarapi.domain.car.Car;
import dar.mar.rentcarapi.domain.car.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarEndpoint {

    private final CarService service;

    @PostMapping("/search")
    List<Car> searchByParams(@RequestBody SearchParams searchParams) {
        return service.findByParams(searchParams);
    }
}
