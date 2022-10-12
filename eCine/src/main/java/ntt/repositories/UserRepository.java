package ntt.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import ntt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
