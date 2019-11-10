/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Nikolas
 */
public class MessengerContextListener implements ServletContextListener {

   @Override
   public void contextInitialized(ServletContextEvent sce) {
       MessengerConfig.getInstance().setup(sce.getServletContext());
   }

   @Override
   public void contextDestroyed(ServletContextEvent sce) {

   }

}
