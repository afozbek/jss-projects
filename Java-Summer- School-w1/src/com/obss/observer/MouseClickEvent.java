package com.obss.observer;

import java.util.Date;
import java.util.EventObject;

public class MouseClickEvent extends EventObject {

    private int id;
    private Date date;

    public MouseClickEvent(Object source, int id, Date date) {
        super(source);
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public MouseClickEvent(Object source) {
        super(source);
    }
}
