package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import root.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.userName = ?1 and u.password = ?2")
	  User findByUserNameAndPassword(String userName, String password);
	
	@Query("select u from User u where u.userName = ?1 and u.userGuid = ?2")
	  User findUserByUserNameAndUserGuid(String userName, String userGuid);
	
	@Query("select u from User u where u.userGuid = ?1")
	  User findUserByUserGuid(String userGuid);

	@Transactional
	@Modifying
	@Query("update User u set u.person.id = ?1 where u.id = ?2")
	void updateIdPersonInUser(Long idPerson, Long idUser);
}
