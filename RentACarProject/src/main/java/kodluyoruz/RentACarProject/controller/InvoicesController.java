package kodluyoruz.RentACarProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodluyoruz.RentACarProject.business.abstracts.InvoiceService;
import kodluyoruz.RentACarProject.dto.requestDtos.InvoiceCorporateCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.requestDtos.InvoiceIndividualCustomerRequestDto;
import kodluyoruz.RentACarProject.dto.responseDtos.InvoiceResponseDto;

@RestController
@RequestMapping("/Invoices")
public class InvoicesController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping("/saveInvoiceCorporateCustomer")
	public ResponseEntity<Integer> saveInvoiceCorporateCustomer(@RequestBody InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto) {
		Integer invoiceId = invoiceService.saveInvoiceCorporateCustomer(invoiceCorporateCustomerRequestDto);
		return new ResponseEntity<>(invoiceId, HttpStatus.OK);
	}

	@PostMapping("/saveInvoiceIndividualCustomer")
	public ResponseEntity<Integer> saveInvoiceIndividualCustomer(@RequestBody InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto) {
		Integer invoiceId = invoiceService.saveInvoiceIndividualCustomer(invoiceIndividualCustomerRequestDto);
		return new ResponseEntity<>(invoiceId, HttpStatus.OK);
	}

	@GetMapping("/findAllInvoices")
	public ResponseEntity<List<InvoiceResponseDto>> findAllInvoices() {
		List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.findAllInvoices();
		return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllInvoicesByCorporateCustomerId")
	public ResponseEntity<List<InvoiceResponseDto>> findAllInvoicesByCorporateCustomerId(@RequestParam Integer corporateCustomerId) {
		List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.findAllInvoicesByCorporateCustomerId(corporateCustomerId);
		return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
	}

	@GetMapping("/findAllInvoicesByIndividualCustomerId")
	public ResponseEntity<List<InvoiceResponseDto>> findAllInvoicesByIndividualCustomerId(@RequestParam Integer individualCustomerId) {
		List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.findAllInvoicesByIndividualCustomerId(individualCustomerId);
		return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
	}

	@DeleteMapping("/deleteInvoiceById")
	public ResponseEntity<Boolean> deleteInvoiceById(@RequestParam Integer invoiceId) {
		boolean delete = invoiceService.deleteInvoiceById(invoiceId);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
