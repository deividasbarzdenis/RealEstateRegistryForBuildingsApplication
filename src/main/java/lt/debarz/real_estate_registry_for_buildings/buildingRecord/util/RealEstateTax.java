package lt.debarz.real_estate_registry_for_buildings.buildingRecord.util;

import java.math.BigDecimal;

public class RealEstateTax implements TaxConstants{
/*
Fizinių asmenų valdomų gyvenamosios, sodų, garažų, fermų, šiltnamių, ūkio, pagalbinio ūkio, mokslo, religinės
ir poilsio paskirties statinių ar patalpų, taip pat žuvininkystės ir inžinerinių statinių bendros vertės daliai,
viršijančiai 150 tūkst. eurų, taikomi progresiniai tarifai:

- 0,5 procento – kai turto mokestinė vertė nuo 150 tūkst. eurų iki 300 tūkst. eurų;

- 1 procentas – kai turto mokestinė vertė nuo 300 tūkst. eurų iki 500 tūkst. eurų;

 - 2 procentai – kai turto mokestinė vertė virš 500 tūkst. eurų.
*/
    @Override
    public BigDecimal calculateTaxFromValue(BigDecimal value) {
        if (value.compareTo(VALUE_MAX) == 1){
            value = value.multiply(new BigDecimal(1+PRECENT_VALUE_MAX));
        }else if (value.compareTo(VALUE_MIDDLE) >= 0){
            value = value.multiply(new BigDecimal(1+PRECENT_VALUE_MIDDLE));
        }else {
            value = value.multiply(new BigDecimal(1+PRECENT_VALUE_MIN));
        }
        return value;
    }

}
