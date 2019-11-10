/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.model.jdbc;

import gr.webchat.model.entities.Message;
import gr.webchat.model.entities.User;
import gr.webchat.web.messenger.main.MessengerException;
import gr.webchat.web.messenger.model.dao.MessageDAO;
import java.util.List;

/**
 *
 * @author Nikolas
 */
public class MessageDAOImpl implements MessageDAO {

   @Override
   public Message create(User sender, User receiver, String text) throws MessengerException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void update(Message msg) throws MessengerException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void delete(Message msg) throws MessengerException {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Message getMessageById(long id) throws MessengerException {
       Message msg = DatabaseHelper.fetchMessageOrNull("select * from message where id = ?", id);
       if (msg == null) {
           throw new MessengerException("Invalid message id: " + id);
       }
       return msg;
   }

   @Override
   public List<Message> getAllMessages() throws MessengerException {
       return DatabaseHelper.fetchMessages("select * from message");
   }

   @Override
   public List<Message> getMessagesSentBy(User sender) throws MessengerException {
       return DatabaseHelper.fetchMessages("select * from message where sender_id = ?", sender.getId());
   }

   @Override
   public List<Message> getMessagesSentTo(User receiver) throws MessengerException {
       return DatabaseHelper.fetchMessages("select * from message where receiver_id = ?", receiver.getId());
   }

   @Override
   public List<Message> getMessagesOfUser(User senderOrReceiver) throws MessengerException {
       long id = senderOrReceiver.getId();
       return DatabaseHelper.fetchMessages("select * from message where sender_id = ? or receiver_id = ?", id, id);
   }



}
