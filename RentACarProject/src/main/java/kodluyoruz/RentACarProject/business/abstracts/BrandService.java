package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.requestDtos.BrandRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.BrandResponseDto;

public interface BrandService {

	Integer saveBrand(BrandRequestDto brandRequestDto);

	List<BrandResponseDto> findAllBrands();

	List<BrandResponseDto> findAllBrandsById(Integer carId);

	boolean deleteBrandById(Integer brandId);

}
