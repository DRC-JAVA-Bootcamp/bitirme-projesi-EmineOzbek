package kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.Brand;
import kodluyoruz.RentACarProject.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

	List<Car> findAllCarsById(Brand brand);
}
