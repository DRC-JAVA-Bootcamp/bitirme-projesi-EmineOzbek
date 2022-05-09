package kodluyoruz.RentACarProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.FuelType;

@Repository
public interface FuelTypeRepository extends CrudRepository<FuelType, Integer> {

}
