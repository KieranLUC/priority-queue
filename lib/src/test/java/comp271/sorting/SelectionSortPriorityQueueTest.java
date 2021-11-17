package comp271.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionSortPriorityQueueTest {

  /*  @Test
    public void getsMinimum() {

        PriorityQueue priorityQueue = new SelectionSortPriorityQueue(34, 5, 12, 8, 35, 99, 1, 28,54);

        assertEquals(1, priorityQueue.removeMin());
        assertEquals(5, priorityQueue.removeMin());
        assertEquals(8, priorityQueue.removeMin());
        assertEquals(12, priorityQueue.removeMin());
        assertEquals(28, priorityQueue.removeMin());
        assertEquals(34, priorityQueue.removeMin());
        assertEquals(35, priorityQueue.removeMin());
        assertEquals(54, priorityQueue.removeMin());
        assertEquals(99, priorityQueue.removeMin());
    }
    */

    public static void main(String[] args) {
        int [] interArray = new int [50];
        for(int x =0;x<50;x++){
            if(x%2==0 && x!=0){
                interArray[x]=x;
            }
            else {
                interArray[x] = 2*x + 3;
            }

        }


       PriorityQueue priorityQueue = new SelectionSortPriorityQueue(interArray);

    }
}
