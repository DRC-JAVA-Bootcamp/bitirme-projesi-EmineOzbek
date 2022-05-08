package kodluyoruz.RentACarProject.dto.responseDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceCorporateCustomerResponseDto {

	private int id;
	private String email;
	private String companyName;
	private String taxNumber;
	private LocalDate invoiceDate;
	private int rentalId;
	private double totalPrice;

}
