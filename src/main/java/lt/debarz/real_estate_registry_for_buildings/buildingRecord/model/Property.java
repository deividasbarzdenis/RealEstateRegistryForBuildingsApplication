package lt.debarz.real_estate_registry_for_buildings.buildingRecord.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property")
    private Set<Owner> owners = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Size size;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private MarketValue value;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PropertyType type;

    public void setAddress(Address address) {
        if (address != null) {
            this.address = address;
            address.setProperty(this);
        }
    }
    public Property addOwner(Owner owner){
        owner.setProperty(this);
        this.owners.add(owner);
        return this;
    }

    public void addSize(Size size) {
        if (size != null) {
            this.size = size;
        }
    }
    public void addValue(MarketValue value) {
        if (value != null) {
            this.value = value;
        }
    }
    public void addType(PropertyType type) {
        if (type != null) {
            this.type = type;
        }
    }
}
