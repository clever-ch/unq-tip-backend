package root.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import root.model.Care;
import root.model.Service;
import root.model.Transit;
import root.model.Transport;

@Repository
public interface PrestacionRepository extends JpaRepository<Service, Long>{

	@Query("select c from Care c")
	List<Care> findAllCareServices();
	
	@Query("select t from Transit t")
	List<Transit> findAllTransitServices();
	
	@Query("select t from Transport t")
	List<Transport> findAllTransportServices();
}
