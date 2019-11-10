package gr.webchat.web.messenger.controller;

import gr.webchat.model.entities.User;
import gr.webchat.web.messenger.controller.ControllerHelper;
import gr.webchat.web.messenger.main.MessengerException;
import gr.webchat.web.messenger.model.dao.UserDAO;
import gr.webchat.web.messenger.model.jdbc.UserDAOImpl;
import gr.webchat.web.messenger.view.ForwardToJSPView;
import gr.webchat.web.messenger.view.View;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class LoginServlet extends HttpServlet {

   UserDAO userDao = new UserDAOImpl();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       View view = new ForwardToJSPView(this.getServletConfig(), req, resp);

       User user = null;
       try {
           user = ControllerHelper.getLoggedInUserFromCookie(req, userDao);
           view.displayHomePage(user);
       }
       catch(MessengerException me) {
           view.displayLoginScreen();
       }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String username = req.getParameter("username");
       String password = req.getParameter("password");

       View view = new ForwardToJSPView(this.getServletConfig(), req, resp);

       try {
           view.prepareI18N();

           User user = userDao.getUser(username, password);
           HttpSession session = req.getSession(true);
           session.setAttribute("userId", user.getId());
           session.setAttribute("lang", "el");
           view.displayHomePage(user);
       }
       catch(MessengerException me) {
           me.printStackTrace(System.out);
           view.displayLoginScreen(me.getMessage());
       }
   }
}