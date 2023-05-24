package com.mrk;

public class one_to_n {
    public static void main(String[] args) {
            funboth(5);
    }
    static void fun(int n){
        if(n == 0){
            return;
        }
        fun(n-1);
        System.out.println(n);
    }
    static void funboth(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funboth(n-1);
        System.out.println(n);
    }
}
