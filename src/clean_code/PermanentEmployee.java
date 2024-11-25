package clean_code;

import java.util.List;

public class PermanentEmployee implements Employee {
    @Override
    public List<Integer> holidayList() {
        return List.of(new Integer[]{1,5,4,23,25,24});
    }

    @Override
    public double salary() {
        return 45000;
    }

    @Override
    public double bonus() {
        return 10000;
    }
}
