package kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.RentACarProject.business.abstracts.CorporateCustomerService;
import kodluyoruz.RentACarProject.dto.requestDtos.CorporateCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.CorporateCustomerResponseDto;
import kodluyoruz.RentACarProject.entity.CorporateCustomer;
import kodluyoruz.RentACarProject.entity.Rental;
import kodluyoruz.RentACarProject.repository.CorporateCustomerRepository;
import kodluyoruz.RentACarProject.repository.RentalRepository;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {

	@Autowired
	private CorporateCustomerRepository corporateCustomerRepository;
	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Integer saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto) {
		CorporateCustomer corporateCustomer = modelMapper.map(corporateCustomerRequestDto, CorporateCustomer.class);
		corporateCustomer = corporateCustomerRepository.save(corporateCustomer);
		return corporateCustomer.getId();
	}

	@Override
	public List<CorporateCustomerResponseDto> findAllCorporateCustomers() {
		Iterable<CorporateCustomer> corporateCustomerList = corporateCustomerRepository.findAll();

		List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
		for (CorporateCustomer corporateCustomer : corporateCustomerList) {
			CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
			corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
		}
		return corporateCustomerResponseDtos;
	}

	@Override
	public List<CorporateCustomerResponseDto> findAllCorporateCustomersById(Integer rentalId) {
		Rental rental = rentalRepository.findById(rentalId).get();
		List<CorporateCustomer> corporateCustomerList = corporateCustomerRepository
				.findAllCorporateCustomersById(rental);

		List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
		for (CorporateCustomer corporateCustomer : corporateCustomerList) {
			CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
			corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
		}
		return corporateCustomerResponseDtos;
	}

	@Override
	public boolean deleteCorporateCustomerById(Integer corporateCustomerId) {
		CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(corporateCustomerId).get();
		corporateCustomerRepository.delete(corporateCustomer);
		return true;
	}

}
