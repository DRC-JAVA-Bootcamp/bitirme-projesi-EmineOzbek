package kodluyoruz.RentACarProject.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "rental_date")
	private LocalDate rentalDate;

	@Column(name = "return_date")
	private LocalDate returnDate;

	@Column(name = "rented_kilometer")
	private int rentedKilometer;

	@Column(name = "returned_kilometer")
	private int returnedKilometer;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@OneToOne
	@JoinColumn(name = "invoice", unique = true)
	private Invoice invoice;

	@OneToMany(mappedBy = "rental")
	private List<Payment> payments;

}
