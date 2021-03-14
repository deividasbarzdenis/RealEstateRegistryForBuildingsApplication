package lt.debarz.real_estate_registry_for_buildings.buildingRecord.util;

import java.math.BigDecimal;

public interface TaxConstants {
    BigDecimal VALUE_MIN = new BigDecimal(150_000);
    BigDecimal VALUE_MIDDLE = new BigDecimal(300_000);
    BigDecimal VALUE_MAX = new BigDecimal(500_000);
    Double PRECENT_VALUE_MIN = 0.005;
    Double PRECENT_VALUE_MIDDLE = 0.01;
    Double PRECENT_VALUE_MAX = 0.02;

    BigDecimal calculateTaxFromValue(BigDecimal value);

}
