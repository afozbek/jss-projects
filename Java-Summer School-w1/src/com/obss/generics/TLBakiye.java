package com.obss.generics;

import com.obss.generics.currency.TL;
import com.obss.generics.currency.USD;

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
