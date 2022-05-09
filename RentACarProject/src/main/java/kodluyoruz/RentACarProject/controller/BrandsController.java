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

import kodluyoruz.RentACarProject.business.abstracts.BrandService;
import kodluyoruz.RentACarProject.dto.requestDtos.BrandRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.BrandResponseDto;

@RestController
@RequestMapping("/brands")
public class BrandsController {

	@Autowired
	private BrandService brandService;

	@PostMapping("/saveBrand")
	public ResponseEntity<Integer> saveBrand(@RequestBody BrandRequestDto brandRequestDto) {
		Integer brandId = brandService.saveBrand(brandRequestDto);
		return new ResponseEntity<>(brandId, HttpStatus.OK);
	}

	@GetMapping("/findAllBrands")
	public ResponseEntity<List<BrandResponseDto>> findAllBrands() {
		List<BrandResponseDto> brandResponseDtos = brandService.findAllBrands();
		return new ResponseEntity<>(brandResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllBrandsById")
	public ResponseEntity<List<BrandResponseDto>> findAllBrandsById(@RequestParam Integer carId) {
		List<BrandResponseDto> brandResponseDtos = brandService.findAllBrandsById(carId);
		return new ResponseEntity<>(brandResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteBrandById")
	public ResponseEntity<Boolean> deleteBrandById(@RequestParam Integer brandId) {
		boolean delete = brandService.deleteBrandById(brandId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}

}
