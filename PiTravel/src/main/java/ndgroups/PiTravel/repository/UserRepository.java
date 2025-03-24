package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    List<User> findByUsername(String username);
    boolean existsByEmail(String email);
}