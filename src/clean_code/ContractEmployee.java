package clean_code;

import java.util.List;

public class ContractEmployee implements Employee {
    @Override
    public List<Integer> holidayList() {
        return List.of(new Integer[]{1,23,4,24});
    }

    @Override
    public double salary() {
        return 24000;
    }

    @Override
    public double bonus() {
        return 2500;
    }
}
