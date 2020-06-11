package factories;

import root.constants.AnimalType;
import root.constants.PublicationStatus;
import root.constants.PublicationType;
import root.model.Animal;
import root.model.Person;
import root.model.Publication;
import root.model.User;


public class PublicationFactory {

    public static Publication anyPublication(){
        return new Publication();
    }

    public static Publication createCompletePublication(Animal animal, User user, String location, PublicationType type,
                                                        PublicationStatus status, String address, String specification){
        Publication newPublication = new Publication();
        newPublication.setAnimal(animal);
        newPublication.setUser(user);
        newPublication.setLocation(location);
        newPublication.setPublicationType(type);
        newPublication.setPublicationStatus(status);
        newPublication.setPublicationAddress(address);
        newPublication.setPublicationDescription(specification);
        return newPublication;
   }

   public static Publication createPublicationWithAnimal(Animal animal){
       Publication newPublication = new Publication();
       newPublication.setAnimal(animal);
       return newPublication;
    }

    public static Publication createPublicationWithUser(User user){
        Publication newPublication = new Publication();
        newPublication.setUser(user);
        return newPublication;
    }

    public static Publication createPublicationWithType(PublicationType type){
        Publication newPublication = new Publication();
        newPublication.setPublicationType(type);
        return newPublication;
    }

    public static Publication createPublicationWithLocation(String location){
        Publication newPublication = new Publication();
        newPublication.setLocation(location);
        return newPublication;
    }

    public static Publication createPublicationWithStatus(PublicationStatus status){
        Publication newPublication = new Publication();
        newPublication.setPublicationStatus(status);
        return newPublication;
    }

    public static Publication createPublicationWithAddress(String address){
        Publication newPublication = new Publication();
        newPublication.setPublicationAddress(address);
        return newPublication;
    }

    public static Publication createPublicationWithSpecification(String specification){
        Publication newPublication = new Publication();
        newPublication.setPublicationDescription(specification);
        return newPublication;
    }

    public static Publication createFullPublicationWithType(PublicationType type) {
    	
    	Animal animal = AnimalFactory.createCompleteAnimal(AnimalType.BIRD, "", "", "", "");
    	Person person = PersonFactory.createPersonComplete("", "", "", "", "");
    	User user = UserFactory.createACompleteUser("", "", "", person);

    	Publication newPublication = new Publication();
        newPublication.setPublicationType(type);
        newPublication.setAnimal(animal);
        newPublication.setUser(user);
        
        return newPublication;
    }
}
