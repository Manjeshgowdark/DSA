package com.mrk;

public class Recursion {
    public static void main(String[] args){
    int result = fib(4);
        System.out.println(result);
    }
    static int fib(int n){
        if(n<2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
