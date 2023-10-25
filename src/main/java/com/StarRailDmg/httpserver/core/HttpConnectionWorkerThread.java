package com.StarRailDmg.httpserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
       this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            //HTML page that we send to the browser
            String html = "<html><head><title>Simple Honkai Star Rail Damage Calculator</title></head><body><h1>Served by a simple java http server</h1></body></html>";

            File file new File("index.html");
            String newhtml = "";

            final String CRLF = "\n\r";
            String response =
                    "HTTP1.1 200 OK" + CRLF + //Status line
                            "Content-Length: " + html.getBytes().length + CRLF + //Headers
                            CRLF +
                            html +
                            CRLF + CRLF;

            outputStream.write(response.getBytes());

            LOGGER.info("Connection processing finished");

        } catch (IOException e) {
            LOGGER.info("Problem with communication.", e);
        } finally {
            try {
                if (inputStream!= null) {
                    inputStream.close();
                }
            } catch (IOException e) {}

            try {
                if (outputStream!= null) {
                    outputStream.close();
                }
            } catch (IOException e) {}

            try {
                if (socket!= null) {
                    socket.close();
                }
            } catch (IOException e) {}
        }

    }
}
