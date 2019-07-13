package com.obss.observer;

import com.obss.observer.listener.MouseListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Button {

    private List<MouseListener> clickListenerList = new ArrayList<>();

    private int id;

    public Button(int id) {
        this.id = id;
    }

    public void click() {
        Object x = "Web Client";
        for (MouseListener listener : clickListenerList) {
            MouseClickEvent mouseClickEvent = new MouseClickEvent(x, this.getId(), new Date());
            listener.mouseClicked(mouseClickEvent);
        }
    }

    public void addClickListener(MouseListener listener) {
        this.clickListenerList.add(listener);
    }

    public void removeClickListener(MouseListener listener) {
        this.clickListenerList.remove(listener);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
