/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nikolas
 */
public class I18N {
    
    private static final List<String> LANGS = Arrays.asList("el", "en");

   private final Map texts;

   public I18N(Map texts) {
       this.texts = texts;
   }

   public String translate(String key, String lang) {
       if (key == null) {
           return "";
       }

       try {
           Map m = (Map) texts.get(key);
           String s = (String) m.get(lang);
           return (s == null ? key : s);
       }
       catch(NullPointerException | ClassCastException e) {
           //log the exception
           return key;
       }
   }

   public static boolean isSupported(String lang) {
       return LANGS.contains(lang);
   }
}
