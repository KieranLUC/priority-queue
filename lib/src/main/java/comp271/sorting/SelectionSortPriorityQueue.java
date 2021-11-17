package comp271.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class SelectionSortPriorityQueue  implements PriorityQueue {

    private final List<Integer> integers;
    private int runningTime=0;

    public SelectionSortPriorityQueue(int [] integer)  {
        this.integers = new ArrayList<>();
        for (Integer numbers : integer) {
            this.integers.add(numbers);
        }
        Integer[] numbers = this.integers.toArray(new Integer[this.integers.size()]);
        selectionSort(numbers); // sorts the arry
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
         int numberOfComparisons =0;

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
                numberOfComparisons++;
            }
            temp = numbers[i];

            numbers[i] = numbers[indexOfSmallest];

            numbers[indexOfSmallest] = temp;
        }
        runningTime = (int) (3 * Math.pow(numbers.length,2)+7*(numbers.length) -4);
        System.out.println("the time complexity is "+ runningTime);
        System.out.println("The number of comparions are :"+numberOfComparisons);
    }
}
