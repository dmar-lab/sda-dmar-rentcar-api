package dar.mar.rentcarapi.external.car;

import dar.mar.rentcarapi.domain.car.Car;
import dar.mar.rentcarapi.domain.car.CarRepository;
import dar.mar.rentcarapi.web.car.SearchParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseCarRepository implements CarRepository {

    private final JpaCarRepository jpaCarRepository;

    @Override
    public List<Car> findByParams(SearchParams searchParams) {
        return jpaCarRepository.findWithSearchParams(searchParams)
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    private Function<CarEntity, Car> mapToDomain() {
        return ent -> Car.builder()
                .id(ent.getId())
                .mark(ent.getMark())
                .type(ent.getType())
                .buildYear(ent.getBuildYear())
                .distance(ent.getDistance())
                .colour(ent.getColour())
                .build();
    }
}
