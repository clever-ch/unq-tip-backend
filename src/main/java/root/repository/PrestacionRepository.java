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

	@Query("select c from Care c where c.serviceStatus = 1")
	List<Care> findAllCareServices();
	
	@Query("select t from Transit t where t.serviceStatus = 1")
	List<Transit> findAllTransitServices();
	
	@Query("select t from Transport t where t.serviceStatus = 1")
	List<Transport> findAllTransportServices();
	
	@Query("select c from Care c where c.user.id = ?1")
	List<Care> findAllCareServicesByIdUser(Long idUser);
	
	@Query("select t from Transit t where t.user.id = ?1")
	List<Transit> findAllTransitServicesByIdUser(Long idUser);
	
	@Query("select t from Transport t where t.user.id = ?1")
	List<Transport> findAllTransportServicesByIdUser(Long idUser);
	
	@Query("select t from Transit t where t.id = ?1")
	Transit getTransitServiceById(Long idService);
	
	@Query("select t from Transport t where t.id = ?1")
	Transport getTransportServiceById(Long idService);
	
	@Query("select c from Care c where c.id = ?1")
	Care getCareServiceById(Long idService);
}
