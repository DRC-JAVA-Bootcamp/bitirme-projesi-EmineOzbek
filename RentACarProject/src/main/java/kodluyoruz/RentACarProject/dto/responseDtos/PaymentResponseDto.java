package kodluyoruz.RentACarProject.dto.responseDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentResponseDto {

	private int id;
	private double totalPrice;
	private LocalDate paymetDate;
	private int rentalId;

}
