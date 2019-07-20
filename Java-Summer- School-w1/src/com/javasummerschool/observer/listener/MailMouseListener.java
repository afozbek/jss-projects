package com.javasummerschool.observer.listener;

import com.javasummerschool.observer.MouseClickEvent;

public class MailMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseClickEvent event) {
        System.out.println("*** MAIL SENDING ***  Event Source : " + event.getId() + ", Date: " + event.getDate());

    }
}
