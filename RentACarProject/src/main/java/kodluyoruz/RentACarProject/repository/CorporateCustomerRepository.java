package kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.CorporateCustomer;
import kodluyoruz.RentACarProject.entity.Rental;

@Repository
public interface CorporateCustomerRepository extends CrudRepository<CorporateCustomer, Integer> {

	List<CorporateCustomer> findAllCorporateCustomersById(Rental rental);
}
