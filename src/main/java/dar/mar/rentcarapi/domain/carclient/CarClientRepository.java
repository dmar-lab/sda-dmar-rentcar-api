package dar.mar.rentcarapi.domain.carclient;

import java.util.List;
import java.util.Optional;

public interface CarClientRepository {

    void create(CarClient carClient);

    void update(CarClient carClient);

    void delete(int id);

    Optional<CarClient> getOne(int id);

    List<CarClient> getAll();

    Optional<CarClient> getByCreditCardNo(String creditCardNo);
}
