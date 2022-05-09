package kodluyoruz.RentACarProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.RentACarProject.business.abstracts.IndividualCustomerService;
import kodluyoruz.RentACarProject.dto.requestDtos.IndividualCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.IndividualCustomerResponseDto;

@RestController
@RequestMapping("/individualCustomers")
public class IndividualCustomersController {

	@Autowired
	private IndividualCustomerService individualCustomerService;

	@PostMapping("/saveIndividualCustomer")
	public ResponseEntity<Integer> saveIndividualCustomer(@RequestBody IndividualCustomerRequestDto individualCustomerRequestDto) {
		Integer individualCustomerId = individualCustomerService.saveIndividualCustomer(individualCustomerRequestDto);
		return new ResponseEntity<>(individualCustomerId, HttpStatus.OK);
	}

	@GetMapping("/findAllIndividualCustomers")
	public ResponseEntity<List<IndividualCustomerResponseDto>> findAllIndividualCustomers() {
		List<IndividualCustomerResponseDto> individualCustomerResponseDtos = individualCustomerService.findAllIndividualCustomers();
		return new ResponseEntity<>(individualCustomerResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllIndividualCustomersById")
	public ResponseEntity<List<IndividualCustomerResponseDto>> findAllIndividualCustomersById(@RequestParam Integer rentalId) {
		List<IndividualCustomerResponseDto> individualCustomerResponseDtos = individualCustomerService.findAllIndividualCustomersById(rentalId);
		return new ResponseEntity<>(individualCustomerResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteIndividualCustomerById")
	public ResponseEntity<Boolean> deleteIndividualCustomerById(@RequestParam Integer individualCustomerId) {
		boolean delete = individualCustomerService.deleteIndividualCustomerById(individualCustomerId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
