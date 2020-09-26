package dar.mar.rentcarapi.external.carclient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCarClientRepository extends JpaRepository<CarClientEntity, Integer> {

    // select * from car_clients where credit_card_no = ?
    Optional<CarClientEntity> findByCreditCardNo(String creditCardNo);
}
