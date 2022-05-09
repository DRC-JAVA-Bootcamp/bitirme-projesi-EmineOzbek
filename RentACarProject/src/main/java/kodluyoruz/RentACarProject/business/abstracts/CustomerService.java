package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.responseDtos.CustomerResponseDto;

public interface CustomerService {

	List<CustomerResponseDto> findAllCustomers();

}
