package lt.debarz.real_estate_registry_for_buildings.buildingRecord.mapper;

import lombok.AllArgsConstructor;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto.OwnerDto;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto.PropertyDto;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.model.*;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.util.RealEstateTax;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PropertyMapper {


    public PropertyDto convertPropertyToDTO(Property property) {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setId(property.getId());
        propertyDto.setYear(property.getYear());
        propertyDto.setDescription(property.getDescription());
        propertyDto.setStreet(property.getAddress().getStreet());
        propertyDto.setHouseNumber(property.getAddress().getHouseNumber());
        propertyDto.setCity(property.getAddress().getCity());
        propertyDto.setRegion(property.getAddress().getRegion());
        propertyDto.setZipCode(property.getAddress().getZipCode());
        propertyDto.setOwners(property.getOwners().stream()
                .map(this::getOwnerDto).collect(Collectors.toSet()));
        propertyDto.setArea(property.getSize().getArea());
        propertyDto.setValue(property.getValue().getValue());
        propertyDto.setValueWithTax(property.getValue().getValueWithTax());
        propertyDto.setType(property.getType().getType());
        return propertyDto;
    }

    public Property convertPropertyDTOToEntity(PropertyDto propertyDto) {
        Property property = new Property();
        property.setYear(propertyDto.getYear());
        property.setDescription(propertyDto.getDescription());
        property.setAddress(addAddress(propertyDto));
        property.setOwners(propertyDto.getOwners().stream()
                .map(own -> getOwner(property, own))
                .collect(Collectors.toSet()));
        property.addSize(addSize(propertyDto));
        property.addValue(addMarketValue(propertyDto));
        property.addType(addPropertyType(propertyDto));
        return property;
    }

    private PropertyType addPropertyType(PropertyDto propertyDto) {
        PropertyType type = new PropertyType();
        type.setType(propertyDto.getType());
        return type;
    }

    private MarketValue addMarketValue(PropertyDto propertyDto) {
        RealEstateTax tax = new RealEstateTax();
        MarketValue value = new MarketValue();
        value.setValue(propertyDto.getValue());
        value.setValueWithTax(tax.calculateTaxFromValue(propertyDto.getValue()));
        return value;
    }

    private Size addSize(PropertyDto propertyDto) {
        Size size = new Size();
        size.setArea(propertyDto.getArea());
        return size;
    }

    private Owner getOwner(Property property, OwnerDto own) {
        Owner owner = new Owner();
        owner.setUsername(own.getUsername());
        owner.setName(own.getName());
        owner.setLastname(own.getLastname());
        owner.setEmail(own.getEmail());
        owner.setPhone(own.getPhone());
        property.addOwner(owner);
        return owner;
    }

    private Address addAddress(PropertyDto propertyDto) {
        Address address = new Address();
        address.setStreet(propertyDto.getStreet());
        address.setHouseNumber(propertyDto.getHouseNumber());
        address.setCity(propertyDto.getCity());
        address.setRegion(propertyDto.getRegion());
        address.setZipCode(propertyDto.getZipCode());
        return address;
    }

    private OwnerDto getOwnerDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setUsername(owner.getUsername());
        ownerDto.setName(owner.getName());
        ownerDto.setLastname(owner.getLastname());
        ownerDto.setEmail(owner.getEmail());
        ownerDto.setPhone(owner.getPhone());
        return ownerDto;
    }

}
