package kodluyoruz.RentACarProject.dto.responseDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RentalResponseDto {

	private int id;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	private int rentedKilometer;
	private int returnedKilometer;
	private int customerId;
	private int carId;
	private int brandId;
	private int invoiceId;

}
