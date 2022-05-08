package kodluyoruz.RentACarProject.dto.requestDtos;

import lombok.Data;

@Data
public class CorporateCustomerRequestDto {

	private int id;
	private String email;
	private String password;
	private String companyName;
	private String taxNumber;

}
