package dar.mar.rentcarapi.domain.rent;

import java.util.Optional;

public interface RentRepository {

    void create(Rent rent);

    Optional<Rent> findById(int id);

    void update(Rent rent);
}
