package root.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import root.model.Publication;


@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{

	@Query("select p from Publication p where p.publicationType = 0")
	List<Publication> findAllPublicationsFound();
	
	@Query("select p from Publication p where p.publicationType = 1")
	List<Publication> findAllPublicationsLost();
	
	@Query("select p from Publication p where p.publicationType = 1 and p.user.id = ?1")
	List<Publication> findAllPublicationsLostIdUser(Long idUser);
	
	@Query("select p from Publication p where p.publicationType = 0 and p.user.id = ?1")
	List<Publication> findAllPublicationsFoundByIdUser(Long idUser);
	
	@Query("select p from Publication p where p.user.id = null")
	Publication getLastPublicationCreated();
	
	@Transactional
	@Modifying
	@Query("update Publication p set p.user.id = ?1 where p.id = ?2")
	void updateUser(Long idUser, Long idPublicacion);
}
