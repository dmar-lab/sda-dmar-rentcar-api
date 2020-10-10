package dar.mar.rentcarapi.external.rent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRentRepository extends JpaRepository<RentEntity, Integer> {
}
