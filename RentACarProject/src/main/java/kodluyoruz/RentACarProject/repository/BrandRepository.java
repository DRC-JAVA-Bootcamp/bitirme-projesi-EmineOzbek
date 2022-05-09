package kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.Brand;
import kodluyoruz.RentACarProject.entity.Car;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {

	List<Brand> findAllBrandsById(Car car); 
}
