package com.obss.generics.primitive;

import com.obss.generics.currency.TL;
import com.obss.generics.currency.USD;

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
