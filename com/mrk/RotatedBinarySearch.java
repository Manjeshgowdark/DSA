package com.mrk;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,1,2,3};
        System.out.println(rotateBinarySearch(arr,8,0, arr.length-1));
    }
    static int rotateBinarySearch(int[] arr,int target, int s , int e){
        int mid = s+ (e-s)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[s] <= arr[mid]){
            if(target >= arr[s] && target <= arr[mid]){
                return rotateBinarySearch(arr,target,s,mid-1);
            }
            else{
                return rotateBinarySearch(arr, target, mid+1, e);
            }
        }
        if(target >= arr[mid] && target<=arr[e]){
            return rotateBinarySearch(arr, target,mid+1,e);
        }
        return rotateBinarySearch(arr, target, s, mid-1);
    }
}
