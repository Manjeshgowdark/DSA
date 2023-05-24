package com.mrk;

public class SumOfDigits {
    public static void main(String[] args) {
        int sum = sumOfDigits(1342);
        System.out.println(sum);
        int product = productOfDigits(55);
        System.out.println(product);
    }
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return sumOfDigits(n/10)+n%10;
    }
    static int productOfDigits(int n){
        if(n%10 == n){
            return n;
        }
        return n%10 * productOfDigits(n/10);
    }
}
