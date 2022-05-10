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

import kodluyoruz.RentACarProject.business.concretes.BrandManager;
import kodluyoruz.RentACarProject.dto.requestDtos.BrandRequestDto;
import kodluyoruz.RentACarProject.entity.Brand;
import kodluyoruz.RentACarProject.repository.BrandRepository;

@ExtendWith(MockitoExtension.class)
public class BrandCoordinatorUnitTest {

	@InjectMocks
	BrandManager brandManager;

	@Mock
	BrandRepository brandRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void saveBrandTest() {
		BrandRequestDto brandRequestDto = mock(BrandRequestDto.class);
		brandRequestDto.setName("testName");

		Brand brandMock = mock(Brand.class);
		brandMock.setId(1);
		when(modelMapper.map(brandRequestDto, Brand.class)).thenReturn(brandMock);
		when(brandRepository.save(brandMock)).thenReturn(brandMock);
		Integer brandSaveSuccess = brandManager.saveBrand(brandRequestDto);

		Assertions.assertEquals("Brand saved.", brandSaveSuccess);
	}

	@Test
	void deleteBrandByIdTest() {
		Brand brandMock = mock(Brand.class);
		brandMock.setId(1);

		when(brandRepository.findById(brandMock.getId())).thenReturn(Optional.of(brandMock));
		boolean delete = brandManager.deleteBrandById(brandMock.getId());

		Assertions.assertEquals("Brand deleted.", delete);
	}

}
