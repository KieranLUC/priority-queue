package comp271.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class MergeSortPriorityQueue implements PriorityQueue {

    private final List<Integer> integers;
    private int numberOfComparisons=0 ; // computes the number of comparisons
    private int runningTime =0; // computes the running time
    public MergeSortPriorityQueue(int [] integer) {
        this.integers = new ArrayList<>();
        for (Integer numbers : integer) {
            this.integers.add(numbers);
        }
        Integer[] numbers = this.integers.toArray(new Integer[this.integers.size()]);

        sort(numbers);// sorts the array
        System.out.println("the number of comparisons are :"+numberOfComparisons);
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
        runningTime = (int) (numbers.length + (numbers.length)*(Math.log(numbers.length)/Math.log(2))); // computes the running time of merge sort
        System.out.println("the running time is "+runningTime);
    }

    private void mergeSort(Integer[] numbers, int startIndex, int endIndex) {
        int midPoint = 0;
         numberOfComparisons++;
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

        numberOfComparisons+=2;
        while (leftPosition <= midPoint && rightPosition <= endIndex) {
            numberOfComparisons+=3;
            if (numbers[leftPosition] < numbers[rightPosition]) {
                mergedNumbers[mergePosition] = numbers[leftPosition];
                leftPosition++;
            } else {
                mergedNumbers[mergePosition] = numbers[rightPosition];
                rightPosition++;
            }
            mergePosition++;
        }
         numberOfComparisons++;
        while (leftPosition <= midPoint) {
            mergedNumbers[mergePosition] = numbers[leftPosition];
            leftPosition++;
            mergePosition++;
            numberOfComparisons++;
        }
        numberOfComparisons++;
        while (rightPosition <= endIndex) {
            mergedNumbers[mergePosition] = numbers[rightPosition];
            rightPosition++;
            mergePosition++;
            numberOfComparisons++;
        }

        for (mergePosition = 0; mergePosition < sizeOfMergedNumbers; mergePosition++) {
            numbers[startIndex + mergePosition] = mergedNumbers[mergePosition];
        }


    }
}
