package com.obss.generics.wildcard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class AccountTransactions {

    public static <T extends Currency> void addMoney(T t) {
        t.addMoney();
    }

    public static void printList(List<?> myList) {
        for(Object object : myList) {
            System.out.println(object.toString());
        }
    }

    public static void printSubList(List<? super String> currencyList) {
        for(Object object : currencyList) {
            System.out.println(object.toString());
        }
    }

    public static void main(String[] args) {
        AccountTransactions.addMoney(new TL());

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        printList(stringList);
        printList(integerList);

        List<String> currencyList = new ArrayList<>();
        printSubList(currencyList);

        List<Serializable> serializableList = new ArrayList<>();
        printSubList(serializableList);

    }

}
