/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.model.dao;

import gr.webchat.web.model.entities.Role;
import gr.webchat.model.entities.User;
import gr.webchat.web.messenger.main.MessengerException;
import java.util.List;

/**
 *
 * @author Nikolas
 */
public interface UserDAO {

   User create(String name, String password, Role role) throws MessengerException;

   void update(User user) throws MessengerException;

   void delete(User user) throws MessengerException;

   User getUserById(long id) throws MessengerException;

   User getUser(String username, String password) throws MessengerException;

   List<User> getAllUsers() throws MessengerException;

}