package kodluyoruz.RentACarProject.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "customers")
public class Customer extends User {

	@Override
	public String getRole() {
		String getRole = "customer";
		return getRole;
	}

	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;

}
