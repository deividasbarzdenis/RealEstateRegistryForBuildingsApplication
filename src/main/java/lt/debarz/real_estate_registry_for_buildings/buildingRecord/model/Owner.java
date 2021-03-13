package lt.debarz.real_estate_registry_for_buildings.buildingRecord.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;

    @ManyToOne
    private Property property;

}
