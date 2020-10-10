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
@RequestMapping("/car")  // "/api/car"
@RequiredArgsConstructor
public class CarEndpoint {

    private final CarService carService;

    /*@PostMapping
    ResponseEntity createCar(@RequestBody @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errMsgs = bindingResult.getAllErrors().stream()
                    .map(err -> err.getDefaultMessage())
                    .collect(Collectors.toList());

            return ResponseEntity.status(400).body(errMsgs);
        } else {
            carService.createCar(car);
            return ResponseEntity.status(201).build();
        }
    }*/

    @PostMapping("/search")
    List<Car> searchByParams(@RequestBody SearchParams searchParams) {
        return carService.findByParams(searchParams);
    }
}
