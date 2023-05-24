package com.mrk;

public class nto1 {
    public static void main(String[] args) {
        fun(8);
    }

    static void fun(int num){
        if(num == 0){
            return;
        }
        System.out.println(num);
        fun(num-1);
    }
}
