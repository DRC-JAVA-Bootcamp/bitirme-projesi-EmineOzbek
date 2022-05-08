package kodluyoruz.RentACarProject.dto.responseDtos;

import lombok.Data;

@Data
public class CorporateCustomerResponseDto {

	private int id;
	private String email;
	private String password;
	private String companyName;
	private String taxNumber;
	
}
