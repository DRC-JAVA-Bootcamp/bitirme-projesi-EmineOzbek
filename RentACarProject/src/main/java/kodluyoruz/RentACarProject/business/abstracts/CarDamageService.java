package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.requestDtos.CarDamageRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.CarDamageResponseDto;

public interface CarDamageService {

	Integer saveCarDamage(CarDamageRequestDto carDamageRequestDto);

	List<CarDamageResponseDto> findAllCarDamages();

	List<CarDamageResponseDto> findAllCarDamagesById(Integer carId);

	boolean deleteCarDamageById(Integer carDamageId);

}
