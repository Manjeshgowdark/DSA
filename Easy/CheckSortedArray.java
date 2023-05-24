package Easy;

public class CheckSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,8,3,4};
        System.out.println(arrsort(arr, 0));
    }
    static boolean arrsort(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] && arrsort(arr,index+1);
    }
}
