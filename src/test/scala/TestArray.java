import java.io.FileWriter;

public class TestArray {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {

        int[] reversedArr = new int[a.length];
        int indicator = 0;
        for(int i = a.length - 1; i >= 0; i--){
            reversedArr[indicator] = a[i];
            indicator++;
        }
        return reversedArr;
    }

    public static void main(String[] args) {
       int[] arr = {2,4,1,3};

        int[] res = rotateLeft(arr, 2);

        for(int i = 0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }

    static int[] rotateLeft(int[] arr, int d){
        int[] finalArray = new int[arr.length];

        for(int i = 0; i < d; i++){
            int j, first;
            //Stores the first element of the array
            first = arr[0];
            for(j = 0; j < arr.length-1; j++){
                //Shift element of array by one
                arr[j] = arr[j+1];
            }
            //First element of array will be added to the end
            arr[j] = first;
        }
        return arr;
    }
}
