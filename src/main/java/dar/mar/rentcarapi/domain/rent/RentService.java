package dar.mar.rentcarapi.domain.rent;
// wykorzystuje metody interfejsu RentRepository w swoich metodach
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import dar.mar.rentcarapi.web.rent.model.UpdateRentRq;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;

    public void scheduleRent(Rent rent) {
        //tu sprawdzamy czy samochod nie jest juz wypozyczony

        rentRepository.create(rent); // create() jest w external.rent.DatabaseRentRepository
    }

    public void updateRent(UpdateRentRq rq) {
        // findById() jest w external.rent.DatabaseRentRepository
        Optional<Rent> rent = rentRepository.findById(rq.getId());

        rent.ifPresent(existingRent -> {
            existingRent.updateRent(rq);
            // update() jest w external.rent.DatabaseRentRepository
            rentRepository.update(existingRent);
        });
    }
}
