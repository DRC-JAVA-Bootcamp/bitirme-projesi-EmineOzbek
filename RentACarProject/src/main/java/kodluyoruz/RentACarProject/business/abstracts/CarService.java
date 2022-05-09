package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.requestDtos.CarRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.CarResponseDto;

public interface CarService {

	Integer saveCar(CarRequestDto carRequestDto);

	List<CarResponseDto> findAllCars();

	List<CarResponseDto> findAllCarsByBrandId(Integer brandId);

	List<CarResponseDto> findAllCarsByFuelTypeId(Integer fuelTypeId);

	boolean deleteCarById(Integer carId);

}
