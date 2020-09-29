package dar.mar.rentcarapi.external.car;

import dar.mar.rentcarapi.web.car.SearchParams;

import java.util.List;

public interface CustomCarRepository {
    List<CarEntity> findWithSearchParams(SearchParams searchParams);
}
