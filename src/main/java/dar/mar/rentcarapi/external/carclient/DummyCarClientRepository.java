package dar.mar.rentcarapi.external.carclient;

import dar.mar.rentcarapi.domain.carclient.CarClient;
import dar.mar.rentcarapi.domain.carclient.CarClientRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DummyCarClientRepository implements CarClientRepository {

    private List<CarClient> carClients = new ArrayList<>();
    private int index = 0;

    @Override
    public void create(CarClient carClient) {
        carClient.setId(++index);
        carClients.add(carClient);
    }

    @Override
    public void update(CarClient carClient) {
        carClients.removeIf(cli -> cli.getId().equals(carClient.getId()));
        carClients.add(carClient);
    }

    @Override
    public void delete(int id) {
        carClients.removeIf(cli -> cli.getId().equals(id));
    }

    @Override
    public Optional<CarClient> getOne(int id) {
        return carClients.stream()
                .filter(cli -> cli.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<CarClient> getAll() {
        return carClients;
    }

    @Override
    public Optional<CarClient> getByCreditCardNo(String creditCardNo) {
        return carClients.stream()
                .filter(cli->cli.getCreditCardNo().equals(creditCardNo))
                .findFirst();
    }
}
