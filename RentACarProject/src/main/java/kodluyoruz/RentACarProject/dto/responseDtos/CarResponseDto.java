package kodluyoruz.RentACarProject.dto.responseDtos;

import lombok.Data;

@Data
public class CarResponseDto {

	private int id;
	private String model;
	private int modelYear;
	private int kilometer;
	private String description;
	private double dailyPrice;
	private String imageUrl;
	private int brandId;
	private int fuelTypeId;
	private int carDamageId;

}
