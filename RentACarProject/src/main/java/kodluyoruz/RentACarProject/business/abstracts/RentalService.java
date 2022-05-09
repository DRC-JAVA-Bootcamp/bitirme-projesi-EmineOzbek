package kodluyoruz.RentACarProject.business.abstracts;

import java.util.List;

import kodluyoruz.RentACarProject.dto.requestDtos.RentalRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.RentalResponseDto;

public interface RentalService {

	Integer saveRental(RentalRequestDto rentalRequestDto);

	List<RentalResponseDto> findAllRentals();

	List<RentalResponseDto> findAllRentalsById(Integer carId);

	boolean deleteRentalById(Integer rentalId);

}
