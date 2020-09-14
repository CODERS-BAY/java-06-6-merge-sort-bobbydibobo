import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {

        int[] unsortedArray = {1,23,493,2130,7};


        mergesort(unsortedArray);
        System.out.println("Sorted Array: " + Arrays.toString(unsortedArray));

    }

    private static int[] mergesort(int[] unsortedArray) {

        if(unsortedArray.length == 1){
            return unsortedArray;
        }

        int [] sortedArrayOne = new int[(int) Math.floor(unsortedArray.length/2)];
        int [] sortedArrayTwo = new int[(int) Math.ceil(unsortedArray.length/2)];

        for ( int i = 0; i < unsortedArray.length; i++){
            if ( i < (int) Math.floor(unsortedArray.length/2)){
                sortedArrayOne[i] = unsortedArray[i];
            } else {
                sortedArrayTwo[i - (int) Math.floor(unsortedArray.length/2)] = unsortedArray[i];
            }
        }

        sortedArrayOne = mergesort(sortedArrayOne);
        sortedArrayTwo = mergesort(sortedArrayTwo);

        return merge (sortedArrayOne, sortedArrayTwo);
    }

    private static int[] merge(int[] sortedArrayOne, int[] sortedArrayTwo) {

        int[] mergeArray = new int[sortedArrayOne.length + sortedArrayTwo.length];

        int counterOne = 0;
        int counterTwo = 0;

        for (int i = 0; i < sortedArrayOne.length + sortedArrayTwo.length; i++){
            if (sortedArrayOne[counterOne] <= sortedArrayTwo[counterTwo]){
                mergeArray[i] = sortedArrayOne[counterOne];
                counterOne++;
            } else {
                mergeArray[i] = sortedArrayTwo[counterTwo];

            }
        }
        return mergeArray;
    }
}
