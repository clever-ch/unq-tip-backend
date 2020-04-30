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
    private String publicationAddress;

    @Column(nullable=false)
    private String publicationDescription;

    @Column(nullable=false)
    @ElementCollection
    private List<String> photos;

    @Column(nullable=false)
    @ElementCollection
    private List<String> photos;

    public boolean isValidPublication() {
        return !isEmptyAnimal()
                & !isEmptyUser()
                & hasAPublicationType()
                & hasAPublicationStatus()
                & hasValidLocation()
                & hasValidPublicationAddress()
                & !isEmptyPublicationDescription();
    }

    public boolean isEmptyAnimal() {
        return this.animal == null;
    }

    public boolean isEmptyUser() {
        return this.user == null;
    }

    public boolean hasAPublicationType(){
        return this.publicationType != null;
    }

    public boolean hasAPublicationStatus(){
        return this.publicationStatus != null;
    }

    public boolean hasValidLocation() {
        return this.location != "" | this.location != null;
    }

    public boolean hasValidPublicationAddress() {
        return this.publicationAddress != "" | this.publicationAddress != null;
    }

    public boolean isEmptyPublicationDescription() {
        return this.publicationDescription == "";
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

    public String getPublicationAddress() {
        return publicationAddress;

    }

    public void setPublicationAddress(String address) {
        this.publicationAddress = address;
    }

    public String getPublicationDescription() {
        return publicationDescription;
    }

    public void setPublicationDescription(String publicationDescription) {
        this.publicationDescription = publicationDescription;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
