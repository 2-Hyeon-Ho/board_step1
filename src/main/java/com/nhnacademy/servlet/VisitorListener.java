package com.nhnacademy.servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class VisitorListener implements HttpSessionListener {
    private int visitorCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }
}
