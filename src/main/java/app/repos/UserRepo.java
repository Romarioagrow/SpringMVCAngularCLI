package app.repos;

import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  User findByUserID(Long userID);

  User findByUsername(String username);

}
