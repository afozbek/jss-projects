package com.javasummerschool.exception.hr.operations;

import com.javasummerschool.exception.hr.entity.Kisi;

import java.util.ArrayList;
import java.util.List;

public class DbOperations {

    public static List<Kisi> getKisiListfromDB() {
        List<Kisi> kisiler = new ArrayList<>();
        // Assume that these valeus are coming from DB
        kisiler.add(new Kisi(1, "ahmet", "mehmet", -1));
        kisiler.add(new Kisi(2, "fikri", "candemir", 1));
        kisiler.add(new Kisi(3, "coskun", "sahin", 2));

        return kisiler;
        // throw new DbException("DB'den veri okunurken hata olustu!");
    }
}
