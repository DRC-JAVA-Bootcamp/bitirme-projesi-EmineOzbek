package kodluyoruz.RentACarProject.dto.responseDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceIndividualCustomerResponseDto {

	private int id;
	private String email;
	private String nationalId;
	private String firstName;
	private String lastName;
	private LocalDate invoiceDate;
	private int rentalId;
	private double totalPrice;

}
