package kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.RentACarProject.business.abstracts.CustomerService;
import kodluyoruz.RentACarProject.dto.responseDtos.CustomerResponseDto;
import kodluyoruz.RentACarProject.entity.Customer;
import kodluyoruz.RentACarProject.repository.CustomerRepository;

@Service
public class CustomerManager implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CustomerResponseDto> findAllCustomers() {
		Iterable<Customer> customerList = customerRepository.findAll();

		List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
		for (Customer customer : customerList) {
			CustomerResponseDto customerResponseDto = modelMapper.map(customer, CustomerResponseDto.class);
			customerResponseDtos.add(customerResponseDto);
		}
		return customerResponseDtos;
	}

}
