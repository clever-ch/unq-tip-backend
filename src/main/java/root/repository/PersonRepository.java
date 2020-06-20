package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import root.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Transactional
	@Modifying
	@Query("update Person p set p.address = ?1, p.location = ?2, p.name = ?3, p.surName = ?4, p.telephone = ?5 where p.id = ?6")
	void updatePersonWithParameters(String address, String location, String name, String surName, String telephone, long idPerson);
}
