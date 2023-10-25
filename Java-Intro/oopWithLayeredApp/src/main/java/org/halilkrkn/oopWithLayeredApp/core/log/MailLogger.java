package org.halilkrkn.oopWithLayeredApp.core.log;

public class MailLogger implements Logger{
    @Override
    public void log(String message) {
        System.out.println("Logged to mail: " + message);
    }
}
