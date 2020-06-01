package modelDTO;

import root.DTO.PersonDTO;

public class PersonDTOFactory {

	public static PersonDTO anyPersonDTO()
	{
		return new PersonDTO();
	}
	
    public static PersonDTO createPersonComplete(String aName, String aSurname, String aTelephone, String aAddress, String aLocation){
    	PersonDTO aAccount = new PersonDTO();
        aAccount.Name = aName;
        aAccount.SurName = aSurname;
        aAccount.Telephone = aTelephone;
        aAccount.Address = aAddress;
        aAccount.Location = aLocation;

        return aAccount;
    }
}
