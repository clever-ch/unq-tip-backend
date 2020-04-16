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
    private PublicationType type;

    @Column(nullable=false)
    private PublicationStatus status;

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
                & hasAType()
                & hasAStatus()
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

    private boolean hasAType(){
        return this.type != null;
    }

    private boolean hasAStatus(){
        return this.status != null;
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

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }

    public PublicationStatus getStatus() {
        return status;
    }

    public void setStatus(PublicationStatus status) {
        this.status = status;
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
