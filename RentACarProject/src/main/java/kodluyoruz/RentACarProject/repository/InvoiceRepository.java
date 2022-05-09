package kodluyoruz.RentACarProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kodluyoruz.RentACarProject.entity.CorporateCustomer;
import kodluyoruz.RentACarProject.entity.IndividualCustomer;
import kodluyoruz.RentACarProject.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

	List<Invoice> findAllInvoicesByCorporateCustomerId(CorporateCustomer corporateCustomer);
	
	List<Invoice> findAllInvoicesByIndividualCustomerId(IndividualCustomer individualCustomer);

}
