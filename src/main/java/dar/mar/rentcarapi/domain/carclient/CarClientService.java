package dar.mar.rentcarapi.domain.carclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarClientService {

    private final CarClientRepository ccRepository;

    public void create(CarClient carClient) {
        ccRepository.getByCreditCardNo(carClient.getCreditCardNo())
                .ifPresent(cli ->
                {throw new IllegalStateException("Client with the same creditCardNo already exists");
                });

        ccRepository.create(carClient);
    }

    public void update(CarClient carClient) {
        ccRepository.getByCreditCardNo(carClient.getCreditCardNo())
                .filter(cli -> !cli.getId().equals(carClient.getId()))
                .ifPresent(cli ->
                {throw new IllegalStateException("Client with the same creditCardNo already exists");});

        ccRepository.update(carClient);
    }

    public CarClient getOne(int id) {
        return ccRepository.getOne(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with given id not exists"));
    }

    public List<CarClient> getAll() {
        return ccRepository.getAll();
    }

    public void delete(int id) {
        ccRepository.delete(id);
    }
}
