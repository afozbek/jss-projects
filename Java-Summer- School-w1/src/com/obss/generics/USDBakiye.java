package com.obss.generics;

import com.obss.generics.currency.TL;
import com.obss.generics.currency.USD;

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
