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
    private int numberOfComparisons=0 ; // stores the vaule of the number of comparisons
    private int runningTime=0;  // stores the vaule of the running time or time complexity
    public QuickSortPriorityQueue(int[] integer) {
        this.integers = new ArrayList<>();
        for (Integer numbers : integer) {
            this.integers.add(numbers);
        }
        Integer[] numbers = this.integers.toArray(new Integer[this.integers.size()]);
        sort(numbers);// sorts the numbers
        System.out.println("the number of comparisons are :"+numberOfComparisons); // displays the number of comparisons
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

            numberOfComparisons++;
            while (numbers[lowIndex] < pivotValue) {
                lowIndex++;
                numberOfComparisons++;
            }

            numberOfComparisons++;
            while (pivotValue < numbers[highIndex]) {
                highIndex--;
                numberOfComparisons++;
            }

            numberOfComparisons++;
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

        runningTime = (int) (numbers.length + (numbers.length)*(Math.log(numbers.length)/Math.log(2))); // computes the running time of merge sort
        System.out.println("the running time is "+runningTime);
        quickSort(numbers, 0, numbers.length - 1);
    }

    private void quickSort(Integer[] numbers, int lowIndex, int highIndex) {

        numberOfComparisons++;
        if (lowIndex >= highIndex) {
            return;
        }

        int rightMostIndexOfLowEnd = partition(numbers, lowIndex, highIndex);

        quickSort(numbers, lowIndex, rightMostIndexOfLowEnd);
        quickSort(numbers, rightMostIndexOfLowEnd+1, highIndex);
    }


}
