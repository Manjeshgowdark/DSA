package BinarySearch1;

public class OrderAgnostic {
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8};
        int arr2[] = {9,8,7,6,5,4,3,2,1};
        int target = 8;
        int index = orderAgnostic(arr2,target);
        System.out.println(index);
    }

    static int orderAgnostic(int arr[], int target){
        int start= 0, end = arr.length-1;
        boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target ==arr[mid]){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

        }
        return -1;
    }

}
