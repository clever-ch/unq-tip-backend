package root.model;

import root.constants.PublicationStatus;
import root.constants.PublicationType;
import root.utilities.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
public class Publication extends Entity {

	@OneToOne(cascade=CascadeType.ALL)
    private Animal animal;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="USER_ID")
	@OneToOne(cascade=CascadeType.ALL)
    private User user;

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
    
    //@Column(nullable=false)	Agregar para que no sea null y adecuar creación publicacion. Esto se setea desde código no por pantalla
    //private Date creationDate;
    

    public boolean isValidPublication() {
        return !isEmptyAnimal()
                & !isEmptyUser()
                & hasAPublicationType()
                & hasAPublicationStatus()
                & hasValidLocation()
                & !isEmptyPublicationAddress()
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

    public boolean isEmptyPublicationAddress() {
        return this.publicationAddress == "" | this.publicationAddress == null;
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
