package com.obss.inner_class;

public class InnerStaticClassVisibilityTest {

    public static void main(String[] args) {
        InnerClasses.ConcreteComparable concreteComparable = new InnerClasses.ConcreteComparable();


        InnerClasses anonymous = new InnerClasses();
        InnerClasses.NonStaticConcreteComparable nonStaticConcreteComparable = anonymous.new NonStaticConcreteComparable();

        new InnerClasses().new NonStaticConcreteComparable();

    }
}
