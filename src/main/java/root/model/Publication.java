package root.model;
import root.constants.PublicationStatus;
import root.constants.PublicationType;
import root.utilities.Entity;
import javax.persistence.Column;

@javax.persistence.Entity
public class Publication extends Entity {

    @Column(nullable=false)
    private Animal animal;

    @Column(nullable=false)
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

    public boolean isValidPublication() {
        return !isEmptyAnimal()
                & hasUser()
                & hasAType()
                & hasAStatus()
                & hasValidLocation()
                & hasValidAddress()
                & !isEmptySpecification();
    }

    public boolean isEmptyAnimal() {
        return this.animal == null;
    }

    public boolean hasUser() {
        return this.user != null;
    }

    public boolean hasAType(){
        return this.type != null;
    }

    public boolean hasAStatus(){
        return this.status != null;
    }

    public boolean hasValidLocation() {
        return this.location != "" | this.location != null;
    }

    public boolean hasValidAddress() {
        return this.address != "" | this.address != null;
    }

    public boolean isEmptySpecification() {
        return this.specification == "";
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

}
