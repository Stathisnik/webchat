/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.main;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 *
 * @author Nikolas
 */
public class MessengerConfig {

   private final Map<String, String> props = new HashMap<>();

   private static final MessengerConfig instance = new MessengerConfig();

   private MessengerConfig() {
       //do nothing
   }

   public static MessengerConfig getInstance() {
       return instance;
   }

   public void setup(ServletContext ctx) {

       Enumeration<String> keys = ctx.getInitParameterNames();
       while(keys.hasMoreElements()) {
           String key   = keys.nextElement();
           String value = ctx.getInitParameter(key);
           props.put(key, value);
       }
   }

   public String getProperty(String key) {
       return props.get(key);
   }
}
