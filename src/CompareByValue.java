import java.util.Comparator;
import java.util.Map;

public class CompareByValue  implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Map.Entry entre1 = (Map.Entry) o1;
        Map.Entry entre2 = (Map.Entry) o2;
        return  (Integer) entre2.getValue() - (Integer) entre1.getValue();
    }
}
