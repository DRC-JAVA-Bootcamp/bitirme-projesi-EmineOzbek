package kodluyoruz.RentACarProject.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String model;

	@Column(name = "model_year")
	private int modelYear;

	@Column
	private int kilometer;

	@Column
	private String description;

	@Column(name = "daily_price")
	private double dailyPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@OneToMany(mappedBy = "car")
	private List<Rental> rentals;

	@ManyToOne
	@JoinColumn(name = "fuelType_id")
	private FuelType fuelType;

	@OneToMany(mappedBy = "car")
	private List<CarDamage> carDamages;

}
