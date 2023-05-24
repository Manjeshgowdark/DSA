package BinarySearch1;

public class BinarySearch {
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int index = binarySearch(arr, 7,0,arr.length-1);
        System.out.println(index);
    }
    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == arr[mid]){
                return mid;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
