package com.mrk;
import java.util.*;

public class LInearSearch {
    public static void main(String[] args) {
        int[] arr = {0,3,4,55,44,55,64,643};
        int result = linear(arr,63,0);
        System.out.println(result);
        System.out.println(findAllIndex2(arr,55,0));
    }
    static int linear(int[] arr, int target, int i){
        if(i == arr.length){
            return -1;
        }
       if(arr[i] == target){
           return i;
       }
       return linear(arr, target,i+1);
    }
    static ArrayList<Integer> findAllIndex(int[] arr, int target,int i, ArrayList<Integer> list){
        if(i == arr.length){
            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }
        return findAllIndex(arr, target,i+1,list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target,int i){
        ArrayList<Integer> list = new ArrayList<>();
        if(i == arr.length){
            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }
       ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr, target, i+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }


}
