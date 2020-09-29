

public class MergeSort {

    public static void main( String args[] ) {


        int[] arraytoSort = {18, 3, 12, 67, 5, 15, 45, 122, 78};
        System.out.println("Unsorted Array:");
        for(int i = 0; i < arraytoSort.length;i++){
            System.out.print(arraytoSort[i] + " ");
        }

        mergeSort(arraytoSort, arraytoSort.length);

        System.out.println();
        System.out.println("Sorted Array:");
        for (int i = 0; i < arraytoSort.length; ++i) {
            System.out.print(arraytoSort[i] + " ");
        }
    }

    public static void merge(int[] uArrayLeft,int[] uArrayRight, int[] unsortedArray,int leftExtent, int rightExtent){

        int i=0,l=0,r = 0;

        while(l<leftExtent && r<rightExtent){

            if(uArrayLeft[l]<uArrayRight[r]){
                unsortedArray[i++] = uArrayLeft[l++];
            }
            else{
                unsortedArray[i++] = uArrayRight[r++];
            }
        }
        while(l<leftExtent){
            unsortedArray[i++] = uArrayLeft[l++];
        }
        while(r<rightExtent){
            unsortedArray[i++] = uArrayRight[r++];
        }
    }

    public static void mergeSort(int [] newArray, int length){
        if (length < 2){
            return;
        }

        int midOfArray = length / 2;
        int [] ArrayLeft = new int[midOfArray];
        int [] ArrayRight = new int[length-midOfArray];

        int k = 0;
        for(int i = 0;i<length;++i){
            if(i<midOfArray){
                ArrayLeft[i] = newArray[i];
            }
            else{
                ArrayRight[k] = newArray[i];
                k = k+1;
            }
        }
        mergeSort(ArrayLeft,midOfArray);
        mergeSort(ArrayRight,length-midOfArray);
        merge(ArrayLeft,ArrayRight,newArray,midOfArray,length-midOfArray);
    }
}
