package dar.mar.rentcarapi.domain.car;

import dar.mar.rentcarapi.web.car.SearchParams;

import java.util.List;

public interface CarRepository {
//    void createCar(Car car);
    List<Car> findByParams(SearchParams searchParams);
}
