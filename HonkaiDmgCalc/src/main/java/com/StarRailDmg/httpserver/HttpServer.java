package com.StarRailDmg.httpserver;

import com.StarRailDmg.httpserver.config.Configuration;
import com.StarRailDmg.httpserver.config.ConfigurationManager;
import com.StarRailDmg.httpserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {

        LOGGER.info("Server starting");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration config = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Using port: " + config.getPort());
        LOGGER.info("Using webroot: " + config.getWebroot());

        ServerListenerThread serverListenerThread = null;
        try {
            serverListenerThread = new ServerListenerThread(config.getPort(), config.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

