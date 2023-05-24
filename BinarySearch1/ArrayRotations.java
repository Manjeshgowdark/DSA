package BinarySearch1;

public class ArrayRotations {
    public static void main(String[] args) {
        int arr[] = {4,5,6,0,1,2,3};
        int rotations = countRotations(arr);
        System.out.println(rotations);
    }
    public static int countRotations(int[] arr){
        int pivotElement = pivot(arr);
        return pivotElement + 1;
    }

    public static int pivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }else if(mid > 0 && arr[mid-1] > arr[mid]){
                return mid - 1;
            }else if(arr[start] > arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
