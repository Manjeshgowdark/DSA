package Easy;

public class SumOfDigits {
    public static void main(String[] args) {
//        System.out.println(sumOfDigits(1342));
        System.out.println(digitProduct(1342));
    }
    static int sumOfDigits(int n){
        if(n%10 == n){
            return n;
        }
        return sumOfDigits(n/10) + n%10;
    }
    static int digitProduct(int n){
        if(n%10 == n){
            return n;
        }
        return  n%10 * digitProduct(n/10);
    }
}
