package comp271.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortPriorityQueue implements PriorityQueue {

    private final List<Integer> integers;

    public MergeSortPriorityQueue(Integer... integers) {
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
