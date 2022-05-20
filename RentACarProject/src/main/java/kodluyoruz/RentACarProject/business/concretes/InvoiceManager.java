package kodluyoruz.RentACarProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodluyoruz.RentACarProject.business.abstracts.InvoiceService;
import kodluyoruz.RentACarProject.dto.requestDtos.InvoiceCorporateCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.requestDtos.InvoiceIndividualCustomerRequestDto;

import kodluyoruz.RentACarProject.dto.responseDtos.InvoiceResponseDto;
import kodluyoruz.RentACarProject.entity.CorporateCustomer;
import kodluyoruz.RentACarProject.entity.IndividualCustomer;
import kodluyoruz.RentACarProject.entity.Invoice;
import kodluyoruz.RentACarProject.repository.CorporateCustomerRepository;
import kodluyoruz.RentACarProject.repository.IndividualCustomerRepository;
import kodluyoruz.RentACarProject.repository.InvoiceCorporateCustomerRepository;
import kodluyoruz.RentACarProject.repository.InvoiceIndividualCustomerRepository;
import kodluyoruz.RentACarProject.repository.InvoiceRepository;

@Service
public class InvoiceManager implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private CorporateCustomerRepository corporateCustomerRepository;
	@Autowired
	private IndividualCustomerRepository individualCustomerRepository;
	@Autowired
	private InvoiceCorporateCustomerRepository invoiceCorporateCustomerRepository;
	@Autowired
	private InvoiceIndividualCustomerRepository invoiceIndividualCustomerRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Integer saveInvoiceCorporateCustomer(InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto) {
		Invoice invoiceCorporateCustomer = modelMapper.map(invoiceCorporateCustomerRequestDto, Invoice.class);
		invoiceCorporateCustomer = invoiceCorporateCustomerRepository.save(invoiceCorporateCustomer);
		return invoiceCorporateCustomer.getId();
	}

	@Override
	public Integer saveInvoiceIndividualCustomer(InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto) {
		Invoice invoiceIndividualCustomer = modelMapper.map(invoiceIndividualCustomerRequestDto, Invoice.class);
		invoiceIndividualCustomer = invoiceIndividualCustomerRepository.save(invoiceIndividualCustomer);
		return invoiceIndividualCustomer.getId();
	}

	@Override
	public List<InvoiceResponseDto> findAllInvoices() {
		Iterable<Invoice> invoiceList = invoiceRepository.findAll();

		List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
		for (Invoice invoice : invoiceList) {
			InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
			invoiceResponseDtos.add(invoiceResponseDto);
		}
		return invoiceResponseDtos;
	}

	@Override
	public List<InvoiceResponseDto> findAllInvoicesByCorporateCustomerId(Integer CorporateCustomerId) {
		CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(CorporateCustomerId).get();
		List<Invoice> invoiceList = invoiceRepository.findAllInvoicesByCorporateCustomerId(corporateCustomer);

		List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
		for (Invoice invoice : invoiceList) {
			InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
			invoiceResponseDtos.add(invoiceResponseDto);
		}
		return invoiceResponseDtos;
	}

	@Override
	public List<InvoiceResponseDto> findAllInvoicesByIndividualCustomerId(Integer IndividualCustomerId) {
		IndividualCustomer individualCustomer = individualCustomerRepository.findById(IndividualCustomerId).get();
		List<Invoice> invoiceList = invoiceRepository.findAllInvoicesByIndividualCustomerId(individualCustomer);

		List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
		for (Invoice invoice : invoiceList) {
			InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
			invoiceResponseDtos.add(invoiceResponseDto);
		}
		return invoiceResponseDtos;
	}

	@Override
	public boolean deleteInvoiceById(Integer invoiceId) {
		Invoice invoice = invoiceRepository.findById(invoiceId).get();
		invoiceRepository.delete(invoice);
		return true;
	}

}
