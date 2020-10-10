package dar.mar.rentcarapi.domain.car;

import dar.mar.rentcarapi.web.car.SearchParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findByParams(SearchParams searchParams) {
        return carRepository.findByParams(searchParams);
    }

    /*public void createCar(Car car) {
        carRepository.createCar(car);
    }*/
}
