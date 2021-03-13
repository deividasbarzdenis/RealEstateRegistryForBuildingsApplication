package lt.debarz.real_estate_registry_for_buildings.buildingRecord.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id) {
        super("Property with id: " + id + " not found!");
    }
}
