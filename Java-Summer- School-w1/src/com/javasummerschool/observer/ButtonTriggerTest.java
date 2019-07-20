package com.javasummerschool.observer;

import com.javasummerschool.observer.listener.MailMouseListener;
import com.javasummerschool.observer.listener.MouseListener;
import com.javasummerschool.observer.listener.PhoneMouseListener;
import com.javasummerschool.observer.listener.SmsMouseListener;

public class ButtonTriggerTest {

    public static void main(String[] args) {
        Button button = new Button(23);

        MouseListener mouseListener = new PhoneMouseListener();
        MouseListener smsListener = new SmsMouseListener();
        MouseListener mailListener = new MailMouseListener();

        button.addClickListener(mouseListener);
        button.addClickListener(smsListener);
        button.addClickListener(mailListener);

        button.click();

    }
}
