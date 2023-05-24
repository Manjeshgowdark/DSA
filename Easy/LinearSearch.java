package Easy;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {2,3,5,2,6,7};
        int target = 2;
//        System.out.println(Linear(arr,0,2));
//        FindAllIndex(arr,0,2);
//        System.out.println(list);
        ArrayList<Integer> ans =  AllIndex(arr,0,target,new ArrayList<>());
        System.out.println(ans);
    }

    private static ArrayList<Integer> AllIndex(int[] arr, int i, int target, ArrayList<Integer> list) {
        if(i== arr.length){
            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }
        return AllIndex(arr, i+1,target,list);
    }

    private static int Linear(int[] arr, int i, int target) {
        if(i==arr.length){
            return -1;
        }
        if(arr[i] == target){
            return i;
        }
        return Linear(arr,i+1,target);
    }
    static ArrayList<Integer> list = new ArrayList<>();
    private static void FindAllIndex(int[] arr, int i, int target) {
        if(i==arr.length){
            return;
        }
        if(arr[i] == target){
            list.add(i);
        }
         FindAllIndex(arr,i+1,target);
    }
}
