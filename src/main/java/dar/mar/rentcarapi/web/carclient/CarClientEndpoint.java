package dar.mar.rentcarapi.web.carclient;

import dar.mar.rentcarapi.domain.carclient.CarClient;
import dar.mar.rentcarapi.domain.carclient.CarClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carclient")
@RequiredArgsConstructor
public class CarClientEndpoint {

    private final CarClientService carClientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createCarClient(@RequestBody CarClient carClient) {
        carClientService.create(carClient);
    }

    @PutMapping
    void updateCarClient(@RequestBody CarClient carClient) {
        carClientService.update(carClient);
    }

    @GetMapping
    List<CarClient> getAll() {
        return carClientService.getAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@RequestParam int id) {
        carClientService.delete(id);
    }

    @GetMapping("/{id}")
    CarClient getById(@PathVariable int id) {
        return carClientService.getOne(id);
    }
}
