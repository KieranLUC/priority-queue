package comp271.sorting;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortPriorityQueue  implements PriorityQueue {

    private final List<Integer> integers;

    public SelectionSortPriorityQueue(Integer... integers) {
        this.integers = new ArrayList<>();
        for (Integer integer : integers) {
            this.integers.add(integer);
        }
    }

    @Override
    public Integer removeMin() {

        Integer[] numbers = this.integers.toArray(new Integer[this.integers.size()]);

        selectionSort(numbers);

        Integer minimumValue = numbers[0];
        this.integers.remove(minimumValue);
        return minimumValue;
    }

    private void selectionSort(Integer[] numbers) {

        /**
         *   i = 0
         *   j = 0
         *   temp = 0
         *   indexOfTheSmallestElement = 0
         *
         *   for(i = 0..n) {
         *     indexOfTheSmallestElement = i
         *     for(j = i+1..n) {
         *       if(A[j] < A[indexOfTheSmallestElement]) {
         *         indexOfTheSmallestElement = j
         *       }
         *     }
         *
         *     temp = A[i]
         *     A[i] = A[indexOfTheSmallestElement]
         *     A[indexOfTheSmallestElement] = temp
         *   }
         */

        int temp = 0;
        int indexOfSmallest = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            indexOfSmallest = i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j] < numbers[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[indexOfSmallest];
            numbers[indexOfSmallest] = temp;
        }
    }
}
