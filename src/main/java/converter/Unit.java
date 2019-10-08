package converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sofronov
 * Created: 08.10.2019
 */
public class Unit {

    private String name;
    private Map<String, Double> relatesMap;

    public Unit(String unitName) {
        name = unitName;
        relatesMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getRelatesMap() {
        return relatesMap;
    }

    public void setRelatesMap(Map<String, Double> relatesMap) {
        this.relatesMap = relatesMap;
    }
}
