package comp271.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortPriorityQueue implements PriorityQueue {

    private final List<Integer> integers;

    public InsertionSortPriorityQueue(Integer... integers) {
        this.integers = new ArrayList<>();
        for (Integer integer : integers) {
            this.integers.add(integer);
        }
    }

    @Override
    public Integer removeMin() {
        throw new UnsupportedOperationException("not implemented yet!");
    }
}
