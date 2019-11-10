/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.view;

import gr.webchat.model.entities.Message;
import gr.webchat.model.entities.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikolas
 */
public class ForwardToJSPView extends View {

   public ForwardToJSPView(ServletConfig config, HttpServletRequest req, HttpServletResponse res) {
       super(config, req, res);
   }

   @Override
   public void showErrorMessage(String message) {
       try {
           req.setAttribute("errorMessage", message);
           req.getRequestDispatcher("error.jsp").forward(req, res);
       }
       catch(ServletException | IOException e) {
           e.printStackTrace();
       }
   }

   @Override
   public void displayLoginScreen(String errorMessage) {
       try {
           req.setAttribute("errorMessage", errorMessage);
           req.getRequestDispatcher("login.jsp").forward(req, res);
       }
       catch(ServletException | IOException e) {
           e.printStackTrace();
       }
   }

   @Override
   public void displayHomePage(User user) {
       try {
           req.setAttribute("user", user);
           req.getRequestDispatcher("home.jsp").forward(req, res);
       }
       catch(ServletException | IOException e) {
           e.printStackTrace();
       }
   }

    @Override
    public void displayMessageList(User user, String type, List<Message> messages) {
        try {
            req.setAttribute("user", user);
            req.setAttribute("type", type);
            req.setAttribute("messages", messages);
            req.getRequestDispatcher("messages.jsp").forward(req, res);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
