package com.obss.observer.listener;

import com.obss.observer.MouseClickEvent;

public class SmsMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseClickEvent event) {
        System.out.println("*** SENDING SMS ***  Event Source : " + event.getId() + ", Date: " + event.getDate());
    }
}
