package org.halilkrkn.oopWithLayeredApp.core.log;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logged to file: " + message);
    }
}
