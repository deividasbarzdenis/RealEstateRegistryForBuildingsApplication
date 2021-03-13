package lt.debarz.real_estate_registry_for_buildings.buildingRecord.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String houseNumber;
    private String city;
    private String region;
    private String zipCode;

    @OneToOne
    private  Property property;
}
