package com.obss.jdbc;

public class StaticInitializerBlock {

    static {
        System.out.println("This is a static initializer block");
    }

    {
        System.out.println("This is a instance initializer block ");
    }

    public StaticInitializerBlock() {
        System.out.println("This is a constructor call");
    }


    public static void main(String[] args) {
        new StaticInitializerBlock();
        new StaticInitializerBlock();
        new StaticInitializerBlock();
    }
}
