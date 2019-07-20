package com.javasummerschool.observer.listener;

import com.javasummerschool.observer.MouseClickEvent;

public class SmsMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseClickEvent event) {
        System.out.println("*** SENDING SMS ***  Event Source : " + event.getId() + ", Date: " + event.getDate());
    }
}
