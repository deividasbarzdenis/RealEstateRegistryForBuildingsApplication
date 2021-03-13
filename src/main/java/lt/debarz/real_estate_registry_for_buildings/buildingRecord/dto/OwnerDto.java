package lt.debarz.real_estate_registry_for_buildings.buildingRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {

    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;

}
