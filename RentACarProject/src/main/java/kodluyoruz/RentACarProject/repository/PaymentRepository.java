package kodluyoruz.RentACarProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
