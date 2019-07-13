package com.obss.generics.review;

import java.util.Collections;

public class MaasHesaplama implements IMaasHesaplama {
    
    @Override
    public void hesapla(double parameter) {
        Double.compare(parameter, 2.0d);

    }

}
