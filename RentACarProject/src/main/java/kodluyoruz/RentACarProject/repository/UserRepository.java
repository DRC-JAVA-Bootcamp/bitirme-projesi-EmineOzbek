package kodluyoruz.RentACarProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kodluyoruz.RentACarProject.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
