package dar.mar.rentcarapi.external.car;

import dar.mar.rentcarapi.web.car.SearchParams;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomCarRepositoryImpl implements CustomCarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CarEntity> findWithSearchParams(SearchParams searchParams) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarEntity> query = cb.createQuery(CarEntity.class);
        Root<CarEntity> root = query.from(CarEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if (searchParams.getMark() != null) {
            predicates.add(cb.equal(root.get("mark"), searchParams.getMark()));
        }
        if (searchParams.getType() != null) {
            predicates.add(cb.equal(root.get("type"), searchParams.getType()));
        }
        // wyszukuje po podanym roku
        if (searchParams.getBuildYear() != null) {
            predicates.add(cb.greaterThan(root.get("buildYear"), searchParams.getBuildYear()));
        }
        //... ew kolejne warunki

        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
