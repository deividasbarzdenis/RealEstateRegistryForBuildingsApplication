package lt.debarz.real_estate_registry_for_buildings.buildingRecord.service;

import lombok.AllArgsConstructor;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto.PropertyDto;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.exception.EntityNotFoundException;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.mapper.PropertyMapper;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.model.Property;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.repository.PropertyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    //getAllProperties
    public List<PropertyDto> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(propertyMapper::convertPropertyToDTO)
                .collect(Collectors.toList());
    }
    //addProperty or create Property
    public PropertyDto createProperty(PropertyDto propertyDto){
        Property property = propertyMapper.convertPropertyDTOToEntity(propertyDto);
        Property saveProperty = propertyRepository.save(property);
        propertyDto.setId(saveProperty.getId());
        return propertyDto;
    }
    //getPropertyById
    public PropertyDto getPropertyById(long id) {
        Property property = getById(id);
        return propertyMapper.convertPropertyToDTO(property);
    }
    //deleteProperty
    public void deleteProperty(long id) {
        if(!propertyRepository.existsById(id)){
            throw new EntityNotFoundException(id);
        }
        propertyRepository.deleteById(id);
    }
    //updateProperty
    public PropertyDto updateProperty(PropertyDto propertyDto) {
        Long id = propertyDto.getId();
        if(id == null){
            throw new EntityNotFoundException(id);
        }
        Property property = getById(id);
        BeanUtils.copyProperties(propertyDto, property);//Todo pakeisti --?
        propertyRepository.save(property);
        return propertyDto;
    }
    //private getById method
    private Property getById(long id) {
        return propertyRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

}
