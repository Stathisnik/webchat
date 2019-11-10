/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.model.jdbc;

import gr.webchat.web.model.entities.Role;
import gr.webchat.model.entities.User;
import gr.webchat.web.messenger.main.MessengerException;
import gr.webchat.web.messenger.model.dao.UserDAO;
import java.util.List;

/**
 *
 * @author Nikolas
 */
public class UserDAOImpl implements UserDAO {

   @Override
   public User create(String name, String password, Role role) throws MessengerException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void update(User user) throws MessengerException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void delete(User user) throws MessengerException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public User getUserById(long id) throws MessengerException {
       User user = DatabaseHelper.fetchUserOrNull("select * from user where id = ?", id);
       if (user == null) {
           throw new MessengerException("Invalid user id: " + id);
       }
       return user;
   }

   @Override
   public User getUser(String username, String password) throws MessengerException {
       User user = DatabaseHelper.fetchUserOrNull("select * from user where name = ? and password = ?", username, password);
       if (user == null) {
           throw new MessengerException("Invalid username / password");
       }
       else {
           return user;
       }
   }

   @Override
   public List<User> getAllUsers() throws MessengerException {
       return DatabaseHelper.fetchUsers("select * from user");
   }


}
