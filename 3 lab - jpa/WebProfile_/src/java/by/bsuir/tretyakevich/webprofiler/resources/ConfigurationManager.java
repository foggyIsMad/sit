/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.tretyakevich.webprofiler.resources;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Kira
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config", Locale.ROOT);
    
    private ConfigurationManager(){
    }
    public static String getProperty(String key)
    {
        return resourceBundle.getString(key);
    }
}

