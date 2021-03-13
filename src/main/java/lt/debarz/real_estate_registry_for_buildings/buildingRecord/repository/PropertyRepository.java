package lt.debarz.real_estate_registry_for_buildings.buildingRecord.repository;

import lt.debarz.real_estate_registry_for_buildings.buildingRecord.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long>{

}
