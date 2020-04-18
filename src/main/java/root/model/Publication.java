package root.model;

import root.constants.PublicationStatus;
import root.constants.PublicationType;
import root.utilities.Entity;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;

import java.util.List;

@javax.persistence.Entity
public class Publication extends Entity {

	@OneToOne
    private Animal animal;

	@OneToOne
    private User user;

    @Column(nullable=false)
    private String location;

    @Column(nullable=false)
    private PublicationType publicationType;

    @Column(nullable=false)
    private PublicationStatus publicationStatus;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String specification;

    @Column(nullable=false)
    @ElementCollection
    private List<String> photos;

    public boolean isValidPublication() {
        return !isEmptyAnimal()
                & !isEmptyUser()
                & hasAPublicationType()
                & hasAPublicationStatus()
                & hasValidLocation()
                & hasValidAddress()
                & !isEmptySpecification();
    }

    private boolean isEmptyAnimal() {
        return this.animal != null;
    }

    private boolean isEmptyUser() {
        return this.user != null;
    }

    private boolean hasAPublicationType(){
        return this.publicationType != null;
    }

    private boolean hasAPublicationStatus(){
        return this.publicationStatus != null;
    }

    private boolean hasValidLocation() {
        return this.location != "" | this.location != null;
    }

    private boolean hasValidAddress() {
        return this.address != "" | this.address != null;
    }

    private boolean isEmptySpecification() {
        return this.specification != "";
    }


    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType type) {
        this.publicationType = type;
    }

    public PublicationStatus getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(PublicationStatus status) {
        this.publicationStatus = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
