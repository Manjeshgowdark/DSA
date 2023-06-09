package BinarySearch1;

public class PivotElement {
    public static void main(String[] args){
        int arr[] = {3,4,5,0,1,2};
        int pivotElement = pivot(arr);
        System.out.println(pivotElement);
    }
    public static int pivot(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid] < arr[mid-1]){
                return mid - 1;
            }else if(arr[start] > arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
