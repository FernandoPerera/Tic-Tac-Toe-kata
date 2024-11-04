package org.example;

import java.util.List;

public class Printer {

    private static final String HORIZONTAL_DIVISION = "----------";
    private static final String VERTICAL_VALUES_DIVISION = " | ";

    public static String display(List<String> valuesToPrinting) {
        StringBuilder representation = new StringBuilder();

        for (int i = 0; i < valuesToPrinting.size(); i++){
            boolean isLastRow = i == valuesToPrinting.size() - 1;
            boolean mustPlaceHorizontalDivision = (i + 1) % 3 == 0;

            if (isLastRow){
                representation.append(valuesToPrinting.get(i));
            }else if (mustPlaceHorizontalDivision) {
                representation.append(valuesToPrinting.get(i)).append("\n" + HORIZONTAL_DIVISION + "\n");
            } else {
                representation.append(valuesToPrinting.get(i)).append(VERTICAL_VALUES_DIVISION);
            }
        }
        return representation.toString();
    }
}
