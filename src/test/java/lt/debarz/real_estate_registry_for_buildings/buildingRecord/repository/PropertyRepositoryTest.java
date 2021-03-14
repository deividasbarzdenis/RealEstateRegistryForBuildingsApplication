package lt.debarz.real_estate_registry_for_buildings.buildingRecord.repository;

import lt.debarz.real_estate_registry_for_buildings.buildingRecord.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PropertyRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    public void findIfRepositoryIsEmpty(){
        Iterable<Property> properties = propertyRepository.findAll();
        assertThat(properties).isEmpty();
    }

    @Test
    public void findAllProperties(){
        Property property = new Property();
        em.persist(property);
        Property property1 = new Property();
        em.persist(property1);
        Property property2 = new Property();
        em.persist(property2);

        Iterable<Property> properties = propertyRepository.findAll();
        assertThat(properties).hasSize(3).contains(property, property1, property2);
    }

    @Test
    public void findPropertyById(){
        Property property = new Property();
        em.persist(property);
        Property property1 = new Property();
        em.persist(property1);
        Property property2 = new Property();
        em.persist(property2);

        Property foundProperty = propertyRepository.findById(property1.getId()).get();

        assertThat(foundProperty).isEqualTo(property1);
    }

    @Test
    public void updatePropertyById(){
        Property property = new Property();
        property.setDescription("First");
        em.persist(property);
        Property property1 = new Property();
        property1.setDescription("Second");
        em.persist(property1);
        Property property2 = new Property();
        property2.setDescription("Third");
        em.persist(property2);

        Property updatedProperty = new Property();
        updatedProperty.setDescription("Updated");

        Property findProperty = propertyRepository.findById(property2.getId()).get();
        findProperty.setDescription(updatedProperty.getDescription());
        propertyRepository.save(findProperty);

        Property checkProperty = propertyRepository.findById(property2.getId()).get();

        assertThat(checkProperty.getId()).isEqualTo(property2.getId());
        assertThat(checkProperty.getDescription()).isEqualTo(property2.getDescription());
    }

    @Test
    public void deletePropertyById(){
        Property property = new Property();
        em.persist(property);
        Property property1 = new Property();
        em.persist(property1);
        Property property2 = new Property();
        em.persist(property2);

        propertyRepository.deleteById(property2.getId());

        Iterable<Property> properties = propertyRepository.findAll();
        assertThat(properties).hasSize(2).contains(property, property1);
    }
    @Test
    public void deleteAllProperties(){
        Property property = new Property();
        em.persist(property);
        Property property1 = new Property();
        em.persist(property1);
        Property property2 = new Property();
        em.persist(property2);

        propertyRepository.deleteAll();
        assertThat(propertyRepository.findAll().isEmpty());
    }
    @Test
    public void storeProperty(){
        Property property = new Property();
        property.setYear(new GregorianCalendar(1985, Calendar.JANUARY, 1).getTime());
        property.setDescription("Old house in country");
        Address address = new Address();
        address.setCity("Plugiskes");
        address.setStreet("Plugo");
        address.setHouseNumber("7");
        address.setRegion("Plunges county");
        address.setZipCode("Lt-77754");
        property.setAddress(address);
        Owner owner = new Owner();
        owner.setUsername("petras2000");
        owner.setName("Petras");
        owner.setLastname("Petrauskas");
        owner.setEmail("petras2000@email.com");
        owner.setPhone("869900111");
        property.addOwner(owner);
        Size size = new Size();
        size.setArea(130L);
        property.setSize(size);
        MarketValue value = new MarketValue();
        value.setValue(new BigDecimal(120000));
        property.addValue(value);
        PropertyType type = new PropertyType();
        type.setType("house");
        property.addType(type);

        propertyRepository.save(property);

        assertThat(property).hasFieldOrPropertyWithValue("description", "Old house in country");
        assertThat(property).hasFieldOrPropertyWithValue("year", new GregorianCalendar(1985, Calendar.JANUARY, 1).getTime());
        assertThat(property).hasFieldOrPropertyWithValue("owners", property.getOwners());
    }


}