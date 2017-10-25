/**
 * Created by stsymb on 10/24/17.
 */
public class Sorting {
    public static int[] randomArray(int length, int min, int max) {
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = (int)((float)min + Math.random() * (float)(max - min));
        }
        return arr;
    }

    public static String printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            sb.append(' ').append(arr[i]);
        }
        return sb.toString();
    }

    public static int[] insertSort(int[] arr) {
        for(int i=0;i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if (arr[i]> arr[j]) {
                    //swap
                    int a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }
        return arr;
    }

    public static int[] hSort(int[] arr, int step) {
        for(int i=step; i<arr.length; i++) {
            int temp = arr[i];
            int j;
            for(j=i; j>=step && arr[j-step]>temp; j-=step) {
                arr[j] = arr[j-step];
            }
            arr[j] = temp;
        }
        return arr;
    }


    public static int[] shellSort(int[] arr) {
        int[] gaps = {
                1, 2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 27, 32, 36, 48, 54, 64, 72, 81, 96, 108, 128, 144, 162, 192, 216,
                243, 256, 288, 324, 384, 432, 486, 512, 576, 648, 729, 768, 864, 972, 1024, 1152, 1296, 1458, 1536,
                1728, 1944, 2048, 2187, 2304, 2592, 2916, 3072, 3456, 3888};
        for (int gap_i=gaps.length-1; gap_i>=0; gap_i--){
            int gap = gaps[gap_i];
//            for (int i=gap; i<arr.length; i++) {
//                int temp = arr[i];
//                int j;
//                for (j=i; j>=gap && arr[j-gap]>temp; j-=gap){
//                    arr[j] = arr[j-gap];
//                }
//                arr[j] = temp;
//            }
            hSort(arr, gap);
        }

        return arr;
    }
}
