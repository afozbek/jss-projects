package com.javasummerschool.observer.listener;

import com.javasummerschool.observer.MouseClickEvent;

import java.util.EventListener;

public interface MouseListener extends EventListener {
    /**
     * This is a mousecliked method
     * This default keyword is only applicable after Java 9
     */
       default void mouseClicked(MouseClickEvent event) {
           System.out.println("Event is triggered! Event Source : " + event.getId() + " Time : " + event.getDate() );
       }
}
