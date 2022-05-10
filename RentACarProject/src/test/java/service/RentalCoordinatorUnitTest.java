package service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import kodluyoruz.RentACarProject.business.concretes.RentalManager;
import kodluyoruz.RentACarProject.dto.requestDtos.RentalRequestDto;
import kodluyoruz.RentACarProject.entity.Rental;
import kodluyoruz.RentACarProject.repository.RentalRepository;

@ExtendWith(MockitoExtension.class)
public class RentalCoordinatorUnitTest {

	@InjectMocks
	RentalManager rentalManager;

	@Mock
	RentalRepository rentalRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void saveRentalTest() {
		RentalRequestDto rentalRequestDto = mock(RentalRequestDto.class);
		rentalRequestDto.setId(2);

		Rental rentalMock = mock(Rental.class);
		rentalMock.setId(1);
		when(modelMapper.map(rentalRequestDto, Rental.class)).thenReturn(rentalMock);
		when(rentalRepository.save(rentalMock)).thenReturn(rentalMock);
		Integer rentalSaveSuccess = rentalManager.saveRental(rentalRequestDto);

		Assertions.assertEquals("Rental saved.", rentalSaveSuccess);
	}

	@Test
	void deleteRentalByIdTest() {
		Rental rentalMock = mock(Rental.class);
		rentalMock.setId(1);

		when(rentalRepository.findById(rentalMock.getId())).thenReturn(Optional.of(rentalMock));
		boolean delete = rentalManager.deleteRentalById(rentalMock.getId());

		Assertions.assertEquals("Rental deleted.", delete);
	}
}
