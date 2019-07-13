package com.obss.collections;

import com.obss.staticusage.Student;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();

        Set<String> set = new HashSet<>();

        Map<String, Integer> map = new LinkedHashMap<>();

        arrayList.add("mert");
        arrayList.add("batuhan");
        arrayList.add("müge");
        arrayList.add("müge");
        arrayList.add(null);
        arrayList.add("valueAfterNull");

        Map<Student, String> hashMapWithObject=  new HashMap<>();

        set.add("mert");
        set.add("batuhan");
        set.add("müge");
        set.add("müge");

        for (String element : arrayList) {
            System.out.println(element);
        }

        System.out.println("*** Set example ***");
        System.out.println();
        for (String element : set) {
            System.out.println(element);
        }

        map.put("obss", 2018);
        map.put("turkcell", 2017);
        map.put("vodafone", 2016);
        map.put("avea",2302);
        map.put("turkTelekom", 2323);
        map.put("AT&T", 1212);
        map.put("obss", 3030);



        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            System.out.println("Entry Key : " + mapEntry.getKey() + " , Value : " + mapEntry.getValue());
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(23);
        queue.add(18);


        System.out.println("First element of the queue : " + queue.element());

        queue.remove();

        System.out.println("First element after removal : " + queue.element());



        // These following statements will throw ClassCastException
        // Because Student does not implements Comparable interface
        // and you can not add any object into TreeSet
        // if it doesn't implement Comparable interface

       // Set<Student> setStudents = new TreeSet<>();
       // setStudents.add(new Student());


        List<String> list = new ArrayList<>();
        list.add("ahmet");
        list.add("ceyhun");
        list.add("berk");
        list.add("xavier");
        list.add("mehmet");

        Object[] objects = list.toArray();

        Arrays.sort(objects);

        System.out.println("Isim siralamasi: ");
        for(Object object : objects) {
            System.out.println(object);
        }

        List<Object> objects1 = Arrays.asList(objects);

        Integer[] intArray = new Integer[10];
        intArray[0] = 1;

        List<Integer> ints = Arrays.asList(intArray);


    }
}
