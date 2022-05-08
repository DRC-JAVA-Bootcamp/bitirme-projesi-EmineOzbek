package kodluyoruz.RentACarProject.dto.requestDtos;

import lombok.Data;

@Data
public class CarDamageRequestDto {

	private int id;
	private String description;
	private int carId;

}
