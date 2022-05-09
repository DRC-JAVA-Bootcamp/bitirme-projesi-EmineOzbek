package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.requestDtos.IndividualCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.IndividualCustomerResponseDto;

public interface IndividualCustomerService {

	Integer saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

	List<IndividualCustomerResponseDto> findAllIndividualCustomers();

	List<IndividualCustomerResponseDto> findAllIndividualCustomersById(Integer rentalId);

	boolean deleteIndividualCustomerById(Integer individualCustomerId);
}
