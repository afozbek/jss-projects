package com.javasummerschool.generics.primitive;

import com.javasummerschool.generics.currency.TL;
import com.javasummerschool.generics.currency.USD;

public class TLBakiye implements PrimitiveGeneric {
    @Override
    public Object getBakiye() {
        return new TL();
    }

    @Override
    public void addBakiye(Object para) {
        TL tl = (TL) para;

    }
    @Override
    public Object convertBalance() {
        return new USD();
    }
}
