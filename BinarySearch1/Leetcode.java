package BinarySearch1;

class Solution {
    public static void main(String[] args) {
        int arr[] = {3,5,1};
        int target = 0;
        int index = search(arr,target);
        System.out.println(index);
    }
    public static int search(int[] nums, int target) {
        int pivot = pivotElement(nums);
        int start = 0;
        if(pivot == -1){
            int index = binarySearch(nums, target,0,nums.length-1);
            return index;
        }
        else{
            if(nums[pivot] == target){
                return pivot;
            }
            else if(target > nums[start]){
                int index = binarySearch(nums,target,0,pivot-1);
                return index;
            }else{
                int index =binarySearch(nums, target, pivot+1, nums.length-1);
                return index;
            }
        }
    }

    public static int binarySearch(int[] nums, int target,int start,int end){
        while(start <= end){
            int mid = start+(end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start= mid + 1;
            }
        }
        return -1;
    }
    public static int pivotElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid < arr.length-1 && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(mid >0 && arr[mid] < arr[mid-1]){
                return mid - 1;
            }else if(arr[start] > arr[mid]){
                end = mid - 1;
            }else{
                start= mid+1;
            }
        }
        return -1;
    }
}
