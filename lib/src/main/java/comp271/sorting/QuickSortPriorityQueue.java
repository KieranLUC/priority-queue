package comp271.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortPriorityQueue implements PriorityQueue {

    private final List<Integer> integers;

    public QuickSortPriorityQueue(Integer... integers) {
        this.integers = new ArrayList<>();
        for (Integer integer : integers) {
            this.integers.add(integer);
        }
    }

    @Override
    public Integer removeMin() {

        Integer[] numbers = this.integers.toArray(new Integer[this.integers.size()]);

        sort(numbers);

        Integer minimumValue = numbers[0];
        this.integers.remove(minimumValue);
        return minimumValue;
    }

    private void sort(Integer[] numbers) {

        // implement with quick sort algorithm
        throw new UnsupportedOperationException("not implemented yet!");
    }
}
