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

        Integer[] numbers = this.integers.toArray(new Integer[this.integers.size()]);

        sort(numbers);

        Integer minimumValue = numbers[0];
        this.integers.remove(minimumValue);
        return minimumValue;
    }

    private void sort(Integer[] numbers) {

        mergeSort(numbers, 0, numbers.length-1);
    }

    private void mergeSort(Integer[] numbers, int startIndex, int endIndex) {
        int midPoint = 0;

        if (startIndex < endIndex) {
            midPoint = (startIndex + endIndex)/2;

            mergeSort(numbers, startIndex, midPoint);
            mergeSort(numbers, midPoint+1, endIndex);

            merge(numbers, startIndex, midPoint, endIndex);
        }
    }

    private void merge(Integer[] numbers, int startIndex, int midPoint, int endIndex) {

        int sizeOfMergedNumbers = endIndex - startIndex + 1;
        int leftPosition = startIndex;
        int rightPosition = midPoint + 1;
        int mergePosition = 0;
        Integer[] mergedNumbers = new Integer[sizeOfMergedNumbers];

        while (leftPosition <= midPoint && rightPosition <= endIndex) {
            if (numbers[leftPosition] < numbers[rightPosition]) {
                mergedNumbers[mergePosition] = numbers[leftPosition];
                leftPosition++;
            } else {
                mergedNumbers[mergePosition] = numbers[rightPosition];
                rightPosition++;
            }
            mergePosition++;
        }

        while (leftPosition <= midPoint) {
            mergedNumbers[mergePosition] = numbers[leftPosition];
            leftPosition++;
            mergePosition++;
        }

        while (rightPosition <= endIndex) {
            mergedNumbers[mergePosition] = numbers[rightPosition];
            rightPosition++;
            mergePosition++;
        }

        for (mergePosition = 0; mergePosition < sizeOfMergedNumbers; mergePosition++) {
            numbers[startIndex + mergePosition] = mergedNumbers[mergePosition];
        }
    }
}
