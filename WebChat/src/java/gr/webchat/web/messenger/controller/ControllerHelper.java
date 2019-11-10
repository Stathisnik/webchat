/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.controller;

import gr.webchat.model.entities.User;
import gr.webchat.web.messenger.main.MessengerException;
import gr.webchat.web.messenger.model.dao.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nikolas
 */
public class ControllerHelper {

   static User getLoggedInUserFromCookie(HttpServletRequest req, UserDAO userDao) throws MessengerException {
       HttpSession session = req.getSession(false);
       if (session == null) {
           throw new MessengerException("Not authorized");
       }
       Long id = (Long)session.getAttribute("userId");
       if (id == null) {
           throw new MessengerException("Invalid session");
       }
       return userDao.getUserById(id);
   }

}
