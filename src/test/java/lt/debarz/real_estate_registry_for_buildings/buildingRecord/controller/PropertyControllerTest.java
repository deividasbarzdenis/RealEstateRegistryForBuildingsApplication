package lt.debarz.real_estate_registry_for_buildings.buildingRecord.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto.PropertyDto;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.model.Property;
import lt.debarz.real_estate_registry_for_buildings.buildingRecord.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
class PropertyControllerTest {

    @InjectMocks
    PropertyController propertyController;

    @Mock
    PropertyRepository propertyRepository;

    @Test
    public void addProperty(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(propertyRepository.addProperty(any(Property.class))).thenReturn(true);
    }
    @Test
    void getAllProperties() {
        //given
        Property property = new Property();
        //when

    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void getProperty() {
    }

    @Test
    void deleteProperty() {
    }

    @Test
    void updateProperty() {
    }
}