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

import kodluyoruz.RentACarProject.business.abstracts.CarService;
import kodluyoruz.RentACarProject.dto.requestDtos.CarRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.CarResponseDto;

@RestController
@RequestMapping("/cars")
public class CarsController {

	@Autowired
	private CarService carService;

	@PostMapping("/saveCar")
	public ResponseEntity<Integer> saveCar(@RequestBody CarRequestDto carRequestDto) {
		Integer carId = carService.saveCar(carRequestDto);
		return new ResponseEntity<>(carId, HttpStatus.OK);
	}

	@GetMapping("/findAllCars")
	public ResponseEntity<List<CarResponseDto>> findAllCars() {
		List<CarResponseDto> carResponseDtos = carService.findAllCars();
		return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllCarsByBrandId")
	public ResponseEntity<List<CarResponseDto>> findAllCarsByBrandId(@RequestParam Integer brandId) {
		List<CarResponseDto> carResponseDtos = carService.findAllCarsByBrandId(brandId);
		return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllCarsByFuelTypeId")
	public ResponseEntity<List<CarResponseDto>> findAllCarsByFuelTypeId(@RequestParam Integer fuelTypeId) {
		List<CarResponseDto> carResponseDtos = carService.findAllCarsByFuelTypeId(fuelTypeId);
		return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCarById")
	public ResponseEntity<Boolean> deleteCarById(@RequestParam Integer carId) {
		boolean delete = carService.deleteCarById(carId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
