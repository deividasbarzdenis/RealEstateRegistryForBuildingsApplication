package lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date year;

    private String description;

    private String street;
    private String houseNumber;
    private String city;
    private String region;
    private String zipCode;

    private Set<OwnerDto> owners = new HashSet<>();

    private Long area;

    private BigDecimal value;
    private BigDecimal valueWithTax;

    private String type;
}
