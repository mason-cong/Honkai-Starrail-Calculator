package com.StarRailDmg.httpserver.config;

import com.StarRailDmg.httpserver.util.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpsConfigurator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputFilter;

public class ConfigurationManager {

    /**
     * Instance of class
     */

    private static ConfigurationManager myConfigManager;
    private static Configuration myCurrentConfgiuration;

    private ConfigurationManager() {
    }

    /**
     * Generates configurationmanager if we do not have one
     */

    public static ConfigurationManager getInstance() {
        if (myConfigManager == null)
            myConfigManager = new ConfigurationManager();
        return  myConfigManager;
    }

    /**
     * Loads configuration file based on path provided
     */

    public void loadConfigurationFile(String filePath) {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigurationException();
        }
        StringBuffer sb = new StringBuffer();

        int i;
        try {
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            throw new HttpConfigurationException();
        }

        JsonNode conf = null;
        try {
            conf = Json.parse(sb.toString());
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing configuration file", e);
        }

        try {
            myCurrentConfgiuration = Json.fromJson(conf, Configuration.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing configuration file, internal", e);
        }
    }

    /**
     * Returns current loaded configuration
     */
    public Configuration getCurrentConfiguration() {
        if (myCurrentConfgiuration == null) {
            throw new HttpConfigurationException("No current configuration set.");
        }
        return myCurrentConfgiuration;
    }

}