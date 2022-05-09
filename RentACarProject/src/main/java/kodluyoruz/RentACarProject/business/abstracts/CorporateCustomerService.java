package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.requestDtos.CorporateCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.CorporateCustomerResponseDto;

public interface CorporateCustomerService {

	Integer saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto);

	List<CorporateCustomerResponseDto> findAllCorporateCustomers();

	List<CorporateCustomerResponseDto> findAllCorporateCustomersById(Integer rentalId);

	boolean deleteCorporateCustomerById(Integer corporateCustomerId);

}
