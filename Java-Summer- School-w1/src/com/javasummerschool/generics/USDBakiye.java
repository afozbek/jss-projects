package com.javasummerschool.generics;

import com.javasummerschool.generics.currency.TL;
import com.javasummerschool.generics.currency.USD;

public class USDBakiye implements Bakiye<USD, TL> {

    @Override
    public USD getBakiye() {
        return null;
    }

    @Override
    public void addBakiye(USD para) {

    }

    @Override
    public TL convertBalance() {
        return null;
    }


}
