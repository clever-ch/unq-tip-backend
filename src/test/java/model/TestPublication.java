package model;

import model.factories.AnimalFactory;
import model.factories.PublicationFactory;
import model.factories.UserFactory;
import org.junit.Test;
import root.constants.PublicationStatus;
import root.constants.PublicationType;
import root.model.Animal;
import root.model.Publication;
import root.model.User;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestPublication {

    @Test
    public void testIsValidPublication() {

        Animal aAnimal = AnimalFactory.anyAnimal();
        User aUser = UserFactory.anyUser();

        Publication aPublication = PublicationFactory.createCompletePublication(aAnimal, aUser, "Quilmes", PublicationType.LOST,
                PublicationStatus.ACTIVE, "Mitre", "Esto es un especificacion");

        assertTrue(aPublication.isValidPublication());
    }
    
    @Test
    public void testNotIsEmptyAnimal() {
        Animal aAnimal = AnimalFactory.anyAnimal();

        Publication aPublication = PublicationFactory.createPublicationWithAnimal(aAnimal);
        assertFalse(aPublication.isEmptyAnimal());
    }

    @Test
    public void testNotIsEmptyUser() {
        User aUser = UserFactory.anyUser();

        Publication aPublication = PublicationFactory.createPublicationWithUser(aUser);

        assertFalse(aPublication.isEmptyUser());
    }
    
    @Test
    public void testHasValidLocation() {
        Publication aPublication = PublicationFactory.createPublicationWithLocation("Quilmes");

        assertTrue(aPublication.hasValidLocation());
    }
    
    @Test
    public void testHasAType(){
        Publication aPublication = PublicationFactory.createPublicationWithType(PublicationType.LOST);

        assertTrue((aPublication.hasAPublicationType()));
    }

    @Test
    public void testHasAStatusActive(){
        Publication aPublication = PublicationFactory.createPublicationWithStatus(PublicationStatus.ACTIVE);

        assertTrue(aPublication.hasAPublicationStatus() && aPublication.getPublicationStatus() == PublicationStatus.ACTIVE);
    }

    @Test
    public void testHasAStatusInactive(){
        Publication aPublication = PublicationFactory.createPublicationWithStatus(PublicationStatus.INACTIVE);

        assertTrue(aPublication.hasAPublicationStatus() && aPublication.getPublicationStatus() == PublicationStatus.INACTIVE);
    }

    @Test
    public void hasValidAddress(){
        Publication aPublication = PublicationFactory.createPublicationWithAddress("Mitre");

        assertTrue(aPublication.hasValidAddress());
    }

    @Test
    public void testIsNotEmptyEspecification(){
        Publication aPublication = PublicationFactory.createPublicationWithSpecification("Esto es una especificacion");

        assertFalse(aPublication.isEmptySpecification());
    }
}
