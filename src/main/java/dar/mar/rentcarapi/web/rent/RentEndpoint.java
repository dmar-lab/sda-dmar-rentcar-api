package dar.mar.rentcarapi.web.rent;

import dar.mar.rentcarapi.domain.rent.Rent;
import dar.mar.rentcarapi.domain.rent.RentService;
import dar.mar.rentcarapi.web.rent.model.UpdateRentRq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentEndpoint {

    private final RentService rentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void scheduleRent(@RequestBody Rent rent) {
        rentService.scheduleRent(rent);
    }

    @PutMapping
    void updateRent(@RequestBody UpdateRentRq rq) {
        rentService.updateRent(rq);
    }
}
