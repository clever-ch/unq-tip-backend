package root.transformers;

import root.DTO.PersonDTO;
import root.model.Person;
import root.model.Publication;

public class PersonTransformer {

	public static Person ConvertPersonDTOToPerson(PersonDTO personDTO) {
		Person person = new Person();
		person.setAddress(personDTO.Address);
		person.setLocation(personDTO.Location);
		person.setName(personDTO.Name);
		person.setSurName(personDTO.SurName);
		person.setTelephone(personDTO.Telephone);
		
		return person;
	}
	
	public static PersonDTO GetPersonDTOByPublication(Publication publication)
	{
		PersonDTO personDTO = new PersonDTO();
		
		personDTO.Name = publication.getUser().getPerson().getName();
		personDTO.SurName = publication.getUser().getPerson().getSurName();
		personDTO.Telephone = publication.getUser().getPerson().getTelephone();
		personDTO.Address = publication.getUser().getPerson().getAddress();
		personDTO.Location = publication.getUser().getPerson().getLocation();
		
		return personDTO;
	}
	
	public static PersonDTO ConvertPersonToPersonDTO(Person pers) {
		
		PersonDTO personDTO = new PersonDTO();
		
		personDTO.Address = pers.getAddress();
		personDTO.Location = pers.getLocation();
		personDTO.Name = pers.getName();
		personDTO.SurName = pers.getSurName();
		personDTO.Telephone = pers.getTelephone();
		
		return personDTO;
	}
}
