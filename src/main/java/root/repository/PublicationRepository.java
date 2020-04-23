package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import root.model.Publication;


@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{

}
