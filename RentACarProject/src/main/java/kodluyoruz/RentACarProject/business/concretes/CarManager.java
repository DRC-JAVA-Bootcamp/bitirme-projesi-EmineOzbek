package kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import kodluyoruz.RentACarProject.business.abstracts.CarService;
import kodluyoruz.RentACarProject.dto.requestDtos.CarRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.CarResponseDto;
import kodluyoruz.RentACarProject.entity.Brand;
import kodluyoruz.RentACarProject.entity.Car;
import kodluyoruz.RentACarProject.entity.FuelType;
import kodluyoruz.RentACarProject.repository.BrandRepository;
import kodluyoruz.RentACarProject.repository.CarRepository;
import kodluyoruz.RentACarProject.repository.FuelTypeRepository;

@Service
public class CarManager implements CarService {

	private CarRepository carRepository;
	private BrandRepository brandRepository;
	private FuelTypeRepository fuelTypeRepository;
	private ModelMapper modelMapper;

	@Override
	public Integer saveCar(CarRequestDto carRequestDto) {
		Car car = modelMapper.map(carRequestDto, Car.class);
		car = carRepository.save(car);
		return car.getId();
	}

	@Override
	public List<CarResponseDto> findAllCars() {
		Iterable<Car> carList = carRepository.findAll();

		List<CarResponseDto> carResponseDtos = new ArrayList<>();
		for (Car car : carList) {
			CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
			carResponseDtos.add(carResponseDto);
		}

		return carResponseDtos;
	}

	@Override
	public List<CarResponseDto> findAllCarsByBrandId(Integer brandId) {
		Brand brand = brandRepository.findById(brandId).get();
		List<Car> carList = carRepository.findAllCarsByBrandId(brand);

		List<CarResponseDto> carResponseDtos = new ArrayList<>();
		for (Car car : carList) {
			CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
			carResponseDtos.add(carResponseDto);
		}
		return carResponseDtos;
	}
	
	@Override
	public List<CarResponseDto> findAllCarsByFuelTypeId(Integer fuelTypeId) {
		FuelType fuelType = fuelTypeRepository.findById(fuelTypeId).get();
		List<Car> carList = carRepository.findAllCarsByFuelTypeId(fuelType);

		List<CarResponseDto> carResponseDtos = new ArrayList<>();
		for (Car car : carList) {
			CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
			carResponseDtos.add(carResponseDto);
		}
		return carResponseDtos;
	}

	@Override
	public boolean deleteCarById(Integer carId) {
		Car car = carRepository.findById(carId).get();
		carRepository.delete(car);
		return true;
	}

}
