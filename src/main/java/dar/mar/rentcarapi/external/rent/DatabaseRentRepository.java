package dar.mar.rentcarapi.external.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import dar.mar.rentcarapi.domain.rent.Rent;
import dar.mar.rentcarapi.domain.rent.RentRepository;
import dar.mar.rentcarapi.external.car.JpaCarRepository;
import dar.mar.rentcarapi.external.carclient.JpaCarClientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseRentRepository implements RentRepository {

    private final JpaRentRepository rentRepository;
    private final JpaCarClientRepository carClientRepository;
    private final JpaCarRepository carRepository;

    @Override
    public void create(Rent rent) {
        RentEntity entity = RentEntity.builder()
                .rentDate(rent.getRentDate())
                .rentHour(rent.getRentHour())
                .car(carRepository.findById(rent.getCar())
                        .orElseThrow(() -> new IllegalStateException("Car not exists")))
                .carClient(carClientRepository.findById(rent.getCarClient())
                        .orElseThrow(() -> new IllegalStateException("Car client not exists")))
                .build();

        rentRepository.save(entity);
    }

    @Override
    public Optional<Rent> findById(int id) {
        return rentRepository.findById(id)
                .map(ent -> Rent.builder()
                        .id(ent.getId())
                        .car(ent.getCar().getId())
                        .carClient(ent.getCarClient().getId())
                        .rentPrice(ent.getRentPrice())
                        .rentHour(ent.getRentHour())
                        .build());
    }

    @Override
    @Transactional
    public void update(Rent rent) {
        RentEntity entity = rentRepository.findById(rent.getId())
                .orElseThrow(() -> new IllegalStateException("Rent not exists"));

        entity.changeRentTime(rent.getRentDate(), rent.getRentHour());

        //Zmiany zostaną zapisane automatycznie poprzez sprawdzenie mechanizmu Dirty-checking
        //czy nastapily jakies zmiany w encji.
        //Adnotacja Transactional !!
    }
}
