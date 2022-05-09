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

import kodluyoruz.RentACarProject.business.abstracts.RentalService;
import kodluyoruz.RentACarProject.dto.requestDtos.RentalRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.RentalResponseDto;

@RestController
@RequestMapping("/rentals")
public class RentalsController {

	@Autowired
	private RentalService rentalService;

	@PostMapping("/saveRental")
	public ResponseEntity<Integer> saveRental(@RequestBody RentalRequestDto rentalRequestDto) {
		Integer rentalId = rentalService.saveRental(rentalRequestDto);
		return new ResponseEntity<>(rentalId, HttpStatus.OK);
	}

	@GetMapping("/findAllRentals")
	public ResponseEntity<List<RentalResponseDto>> findAllRentals() {
		List<RentalResponseDto> rentalResponseDtos = rentalService.findAllRentals();
		return new ResponseEntity<>(rentalResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllRentalsById")
	public ResponseEntity<List<RentalResponseDto>> findAllRentalsById(@RequestParam Integer carId) {
		List<RentalResponseDto> rentalResponseDtos = rentalService.findAllRentalsById(carId);
		return new ResponseEntity<>(rentalResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteRentalById")
	public ResponseEntity<Boolean> deleteRentalById(@RequestParam Integer rentalId) {
		boolean delete = rentalService.deleteRentalById(rentalId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
