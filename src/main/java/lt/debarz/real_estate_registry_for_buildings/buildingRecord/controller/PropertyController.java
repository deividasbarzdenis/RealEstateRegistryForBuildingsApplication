package lt.debarz.real_estate_registry_for_buildings.buildingRecord.controller;

import lombok.AllArgsConstructor;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto.PropertyDto;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    //getAllProperties
    @GetMapping
    public List<PropertyDto> getAllProperties() {
        return propertyService.getAllProperties();
    }
    //addProperty to DB
    @PostMapping
    public ResponseEntity<PropertyDto> addProperty(@RequestBody @Valid PropertyDto propertyDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(propertyService.createProperty(propertyDto));
    }
    //getProperty
    @GetMapping("/{id}")
    public PropertyDto getProperty(@PathVariable long id){
        return propertyService.getPropertyById(id);
    }
    //deleteProperty
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProperty(@PathVariable long id){
        propertyService.deleteProperty(id);
    }
    //UpdateProperty
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PropertyDto updateProperty(@RequestBody @Valid PropertyDto propertyDto) {
        return propertyService.updateProperty(propertyDto);
    }

}
