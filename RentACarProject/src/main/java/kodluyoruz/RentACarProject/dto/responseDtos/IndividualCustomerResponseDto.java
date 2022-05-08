package kodluyoruz.RentACarProject.dto.responseDtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IndividualCustomerResponseDto {

	private int id;
	private String email;
	private String password;
	private String nationalId;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

}
