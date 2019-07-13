package com.obss.observer.listener;

import com.obss.observer.MouseClickEvent;

public class MailMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseClickEvent event) {
        System.out.println("*** MAIL SENDING ***  Event Source : " + event.getId() + ", Date: " + event.getDate());

    }
}
