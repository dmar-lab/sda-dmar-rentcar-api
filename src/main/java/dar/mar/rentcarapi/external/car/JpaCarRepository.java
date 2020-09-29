package dar.mar.rentcarapi.external.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCarRepository extends
        JpaRepository<CarEntity, Integer>,
        CustomCarRepository {
    // tu zapytania dla bazy
}
