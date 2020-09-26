package dar.mar.rentcarapi.external.carclient;

import lombok.RequiredArgsConstructor;
import dar.mar.rentcarapi.domain.carclient.CarClient;
import dar.mar.rentcarapi.domain.carclient.CarClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseCarClientRepository implements CarClientRepository {

    private final JpaCarClientRepository carClientRepository;

    @Override
    public void create(CarClient carClient) {
        CarClientEntity entity = CarClientEntity.builder()
                .name(carClient.getName())
                .surname(carClient.getSurname())
                .drivingLicenceNo(carClient.getDrivingLicenceNo())
                .nationality(carClient.getNationality())
                .creditCardNo(carClient.getCreditCardNo())
                .build();

        carClientRepository.save(entity);
    }

    @Override
    public void update(CarClient carClient) {
        carClientRepository.findById(carClient.getId())
                .ifPresent(ent -> {
                    ent.updateFromDomain(carClient);
                    carClientRepository.save(ent);
                });
    }

    @Override
    public void delete(int id) {
        carClientRepository.deleteById(id);
    }

    @Override
    public Optional<CarClient> getOne(int id) {
        return carClientRepository.findById(id)
                .map(mapToDomain());
    }

    @Override
    public List<CarClient> getAll() {
        return carClientRepository.findAll()
                .stream()
                .map(mapToDomain())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarClient> getByCreditCardNo(String creditCardNo) {
        return carClientRepository.findByCreditCardNo(creditCardNo)
                .map(mapToDomain());
    }

    private Function<CarClientEntity, CarClient> mapToDomain() {
        return ent -> new CarClient(ent.getId(), ent.getName(),
                ent.getSurname(), ent.getDrivingLicenceNo(),
                ent.getNationality(), ent.getCreditCardNo());
    }
}
