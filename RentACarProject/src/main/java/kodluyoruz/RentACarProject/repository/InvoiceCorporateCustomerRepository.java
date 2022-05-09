package kodluyoruz.RentACarProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.Invoice;

@Repository
public interface InvoiceCorporateCustomerRepository extends CrudRepository<Invoice, Integer> {

}
