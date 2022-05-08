package kodluyoruz.RentACarProject.dto.requestDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IndividualCustomerRequestDto {

	private int id;
	private String email;
	private String password;
	private String nationalId;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

}
