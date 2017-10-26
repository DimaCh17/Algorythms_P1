import java.util.*;

/**
 * Created by stsymb on 10/24/17.
 */
public class TestSorting {


    public static void main(String[] argv) {
        int numArrays = 1000;
        int arraysLength = 1000;
        int min = 0, max = 1005;

        int[][] arrays1 = new int[numArrays][];
        int[][] arrays2 = new int[numArrays][];

        for (int i=0; i<numArrays; i++) {
            arrays1[i] = Sorting.randomArray(arraysLength, min, max);
            arrays2[i] = (int[])arrays1[i].clone();
        }

        System.out.print("Insert Sort");
        long startTime = System.nanoTime();
        for (int i=0; i<numArrays; i++) {
            Sorting.insertSort(arrays1[i]);
        }
        System.out.println("Execution time: \t" + (System.nanoTime() - startTime));

        System.out.print("Shell Sort");
        startTime = System.nanoTime();
        for (int i=0; i<numArrays; i++) {
            Sorting.shellSort(arrays2[i]);
        }
        System.out.println("Execution time: \t" + (System.nanoTime() - startTime));
//        int[] arr = Sorting.randomArray(50,0,100);
//        System.out.println(Sorting.printArray(arr));
//        System.out.println(Sorting.printArray(Sorting.shellSort(arr)));
//        arr = Sorting.randomArray(50,0,100);
//        System.out.println(Sorting.printArray(arr));
//        System.out.println(Sorting.printArray(Sorting.insertSort(arr)));
    }
}
