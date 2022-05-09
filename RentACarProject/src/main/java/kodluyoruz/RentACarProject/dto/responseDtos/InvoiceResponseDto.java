package kodluyoruz.RentACarProject.dto.responseDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceResponseDto {

	private int id;
	private String email;
	private LocalDate invoiceDate;
	private int rentalId;
	private double totalPrice;
}
