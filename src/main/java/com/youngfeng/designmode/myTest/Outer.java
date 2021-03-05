package com.youngfeng.designmode.myTest;

class Outer{
    public static void main(String[] args){
        Outer out = new Outer();
        Object obj = out.method();
    }

    Object method(){
        final int locvar = 1;
        class Inner{
            void displayLocvar(){
                System.out.println("locvar = " + locvar);
            }
        }
        Object in = new Inner();
        return in;
    }
}
