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

import kodluyoruz.RentACarProject.business.concretes.InvoiceManager;
import kodluyoruz.RentACarProject.dto.requestDtos.InvoiceCorporateCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.requestDtos.InvoiceIndividualCustomerRequestDto;
import kodluyoruz.RentACarProject.entity.Invoice;
import kodluyoruz.RentACarProject.repository.InvoiceRepository;

@ExtendWith(MockitoExtension.class)
public class InvoiceCoordinatorUnitTest {

	@InjectMocks
	InvoiceManager invoiceManager;

	@Mock
	InvoiceRepository invoiceRepository;

	@Mock
	ModelMapper modelMapper;

	@Test
	void saveInvoiceCorporateCustomerSaveTest() {
		InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto = mock(
				InvoiceCorporateCustomerRequestDto.class);
		invoiceCorporateCustomerRequestDto.setId(2);

		Invoice invoiceMock = mock(Invoice.class);
		invoiceMock.setId(1);
		when(modelMapper.map(invoiceCorporateCustomerRequestDto, Invoice.class)).thenReturn(invoiceMock);
		when(invoiceRepository.save(invoiceMock)).thenReturn(invoiceMock);
		Integer invoiceCorporateCustomerSaveSuccess = invoiceManager
				.saveInvoiceCorporateCustomer(invoiceCorporateCustomerRequestDto);

		Assertions.assertEquals("Invoice saved for corporate customer.", invoiceCorporateCustomerSaveSuccess);
	}

	@Test
	void saveInvoiceIndividualCustomerSaveTest() {
		InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto = mock(
				InvoiceIndividualCustomerRequestDto.class);
		invoiceIndividualCustomerRequestDto.setId(2);

		Invoice invoiceMock = mock(Invoice.class);
		invoiceMock.setId(1);
		when(modelMapper.map(invoiceIndividualCustomerRequestDto, Invoice.class)).thenReturn(invoiceMock);
		when(invoiceRepository.save(invoiceMock)).thenReturn(invoiceMock);
		Integer invoiceIndividualCustomerSaveSuccess = invoiceManager
				.saveInvoiceIndividualCustomer(invoiceIndividualCustomerRequestDto);

		Assertions.assertEquals("Invoice saved for individual customer.", invoiceIndividualCustomerSaveSuccess);
	}

	@Test
	void deleteInvoiceByIdTest() {
		Invoice invoiceMock = mock(Invoice.class);
		invoiceMock.setId(1);

		when(invoiceRepository.findById(invoiceMock.getId())).thenReturn(Optional.of(invoiceMock));
		boolean delete = invoiceManager.deleteInvoiceById(invoiceMock.getId());

		Assertions.assertEquals("Invoice deleted.", delete);
	}
}
