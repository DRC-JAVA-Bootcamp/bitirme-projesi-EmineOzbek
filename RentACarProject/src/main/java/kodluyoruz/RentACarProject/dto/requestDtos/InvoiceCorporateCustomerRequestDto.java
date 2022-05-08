package kodluyoruz.RentACarProject.dto.requestDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InvoiceCorporateCustomerRequestDto {

	private int id;
	private String email;
	private String companyName;
	private String taxNumber;
	private LocalDate invoiceDate;
	private int rentalId;
	private double totalPrice;

}
