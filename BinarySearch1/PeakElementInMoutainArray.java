package BinarySearch1;

public class PeakElementInMoutainArray {
    public static void main(String[] args){
          int arr[] = {1,3,2};
          int answer = binarySearch(arr);
        System.out.println(answer);
    }
    public static int binarySearch(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else if(arr[mid] < arr[mid+1]){
                start = mid + 1;
            }
        }
        return arr[start];
    }
}
