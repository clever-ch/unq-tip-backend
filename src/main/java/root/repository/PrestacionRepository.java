package root.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	Transit findTransitServiceByIdService(Long idService);
	
	@Query("select t from Transport t where t.id = ?1")
	Transport findTransportServiceByIdService(Long idService);
	
	@Query("select c from Care c where c.id = ?1")
	Care findCareServiceByIdService(Long idService);
	
	@Query("select t from Transit t where t.user.id = null")
	Transit getLastTransitServiceCreated();
	
	@Transactional
	@Modifying
	@Query("update Transit t set t.user.id = ?1 where t.id = ?2")
	void updateIdUserInTransitService(Long idUser, Long idTransit);
	
	@Query("select t from Transport t where t.user.id = null")
	Transport getLastTransportServiceCreated();
	
	@Transactional
	@Modifying
	@Query("update Transport t set t.user.id = ?1 where t.id = ?2")
	void updateIdUserInTransportService(Long idUser, Long idTransport);
	
	@Query("select c from Care c where c.user.id = null")
	Care getLastCareServiceCreated();
	
	@Transactional
	@Modifying
	@Query("update Care c set c.user.id = ?1 where c.id = ?2")
	void updateIdUserInCareService(Long idUser, Long idCare);
}
