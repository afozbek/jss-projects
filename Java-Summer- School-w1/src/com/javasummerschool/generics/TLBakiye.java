package com.javasummerschool.generics;

import com.javasummerschool.generics.currency.TL;
import com.javasummerschool.generics.currency.USD;

public class TLBakiye implements Bakiye<TL, USD> {

    @Override
    public TL getBakiye() {
        return null;
    }

    @Override
    public void addBakiye(TL para) {

    }

    @Override
    public USD convertBalance() {
        return null;
    }
}
