package com.obss.generics;

import java.util.Collection;
import java.util.List;

public interface Bakiye<T, Y> {
    T getBakiye();
    void addBakiye(T para);
    Y convertBalance();

}
