package converter;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<Unit> units = new ArrayList<>();
        List<String> result = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sofronov\\bespoke\\converter\\src\\resources\\input.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (StringUtils.isNotBlank(line)) {
                    String[] split = line.split(" ");
                    if (!split[3].equals("?")) {

                        String firstUnitName = split[1];
                        Unit unit1 = getOrCreateUnit(units, firstUnitName);

                        String secondUnitName = split[4];
                        Unit unit2 = getOrCreateUnit(units, secondUnitName);

                        Double firstValue = Double.valueOf(split[0]);
                        Double secondValue = Double.valueOf(split[3]);

                        unit1.getRelatesMap().put(unit2.getName(), secondValue / firstValue);
                        unit2.getRelatesMap().put(unit1.getName(), firstValue / secondValue);

                    } else {

                        String firstUnitName = split[1];
                        Unit unit1 = getUnit(units, firstUnitName);

                        String secondUnitName = split[4];
                        Unit unit2 = getUnit(units, secondUnitName);



                    }
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }

    private static Unit getUnit(List<Unit> units, String unitName) {
        Unit result = null;
        Optional<Unit> unitOptional = units.stream().filter(unit -> unit.getName().equals(unitName)).findFirst();
        if (unitOptional.isPresent()) {
            result = unitOptional.get();
        }
        return result;
    }

    private static Unit getOrCreateUnit(List<Unit> units, String unitName) {
        Unit result = null;

        if (!isExist(units, unitName)) {
            result = new Unit(unitName);
            units.add(result);
        } else {
            Optional<Unit> unitOptional = units.stream().filter(unit -> unit.getName().equals(unitName)).findFirst();
            if (unitOptional.isPresent()) {
                result = unitOptional.get();
            }
        }
        return result;
    }

    private static boolean isExist(List<Unit> units, String unitName) {
        return units.stream().anyMatch(unit -> unit.getName().equals(unitName));
    }
}
