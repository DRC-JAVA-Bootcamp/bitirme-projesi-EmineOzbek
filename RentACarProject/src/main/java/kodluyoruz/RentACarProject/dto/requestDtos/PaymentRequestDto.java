package kodluyoruz.RentACarProject.dto.requestDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentRequestDto {

	private int id;
	private double totalPrice;
	private LocalDate paymetDate;
	private int rentalId;

}
