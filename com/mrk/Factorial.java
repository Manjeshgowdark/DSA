package com.mrk;

public class Factorial {
    public static void main(String[] args) {
        int ans = fact(5);
        System.out.println(ans);
        int result = sum(10);
        System.out.println(result);
    }

    private static int fact(int n) {
        if(n<=1){
            return 1;
        }
        return n * fact(n-1);
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }
        return n + sum(n-1);
    }
}
