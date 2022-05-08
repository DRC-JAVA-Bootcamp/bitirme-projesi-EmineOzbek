package kodluyoruz.RentACarProject.dto.requestDtos;

import lombok.Data;

@Data
public class CarRequestDto {

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
