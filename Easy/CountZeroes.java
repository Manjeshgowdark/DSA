package Easy;

public class CountZeroes {
    public static void main(String[] args) {
        System.out.println(count(90000,0));
    }

    static int count(int n, int count){
        if(n%10 == n){
            return count;
        }
        if(n%10 == 0){
            return count(n/10,count+1);
        }
        return count(n/10,count);
    }
}
