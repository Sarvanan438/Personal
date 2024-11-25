package clean_code;

import java.util.List;

public class VoidEmployee implements Employee {
    @Override
    public List<Integer> holidayList() {
        return List.of();
    }

    @Override
    public double salary() {
        return 0;
    }

    @Override
    public double bonus() {
        return 0;
    }
}
