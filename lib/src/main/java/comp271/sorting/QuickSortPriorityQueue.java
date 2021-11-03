package comp271.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSortPriorityQueue implements PriorityQueue {

    /**
     *    quickSort(A, lowIndex, highIndex) {
     *      if (lowIndex >= highIndex) {
     *       return
     *      }
     *     indexWhereLowEndEnds = partition(A, lowIndex, highIndex)
     *     quickSort(A, lowIndex, indexWhereLowEndEnds)
     *     quickSort(A, indexWhereLowEndEnds+1, highIndex)
     *    }
     *
     * partition(A, lowIndex, highIndex) {
     *
     *   indexOfPivot = lowIndex + (highIndex - lowIndex)/2
     *   pivotValue = A[indexOfPivot]
     *
     *   done = false
     *   while (!done) {
     *
     *     while (A[lowIndex] < pivotValue) {
     *       lowIndex++
     *     }
     *
     *     while (pivotValue < A[highIndex]) {
     *       highIndex--
     *     }
     *
     *     if (lowIndex >= highIndex) {
     *       done = true
     *     } else {
     *       swap(A[lowIndex], A[highIndex])
     *       lowIndex++
     *       highIndex--
     *     }
     *     return highIndex
     *   }
     *
     */

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

    private int partition(Integer[] numbers, int lowIndex, int highIndex) {

        int indexOfPivot = lowIndex + (highIndex - lowIndex) / 2;
        int pivotValue = numbers[indexOfPivot];
        int temp = 0;

        boolean done = false;
        while (!done) {

            while (numbers[lowIndex] < pivotValue) {
                lowIndex++;
            }

            while (pivotValue < numbers[highIndex]) {
                highIndex--;
            }

            if (lowIndex >= highIndex) {
                done = true;
            } else {
                temp = numbers[lowIndex];
                numbers[lowIndex] = numbers[highIndex];
                numbers[highIndex] = temp;
                lowIndex++;
                highIndex--;
            }
        }
        return highIndex;
    }

    private void sort(Integer[] numbers) {



        quickSort(numbers, 0, numbers.length - 1);
    }

    private void quickSort(Integer[] numbers, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int rightMostIndexOfLowEnd = partition(numbers, lowIndex, highIndex);

        quickSort(numbers, lowIndex, rightMostIndexOfLowEnd);
        quickSort(numbers, rightMostIndexOfLowEnd+1, highIndex);
    }


}
