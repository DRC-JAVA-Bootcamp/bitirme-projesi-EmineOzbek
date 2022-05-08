package kodluyoruz.RentACarProject.dto.requestDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RentalRequestDto {

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
