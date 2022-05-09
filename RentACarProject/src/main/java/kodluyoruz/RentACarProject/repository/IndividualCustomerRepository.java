package kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.IndividualCustomer;
import kodluyoruz.RentACarProject.entity.Rental;

@Repository
public interface IndividualCustomerRepository extends CrudRepository<IndividualCustomer, Integer> {

	List<IndividualCustomer> findAllIndividualCustomersById(Rental rental);
}
