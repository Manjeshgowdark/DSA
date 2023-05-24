package com.mrk;

public class Reverse_num {
    public static void main(String[] args) {
        rev1(1234);
        System.out.println(sum);
//        int reverse = rev2(1234);
//        System.out.println(reverse);
//        int reverse_helper = helper(1234,4);
//        System.out.println(reverse_helper);
    }
    static int sum = 0;
    static void rev1(int n){
        if(n == 0){
            return;
        }
        int rem = n % 10;
        sum = sum*10 + rem;
        rev1(n/10);
    }
    static int rev2(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        if(n%10 == n){
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10,digits-1)) + helper(n/10,digits-1);
    }

}
