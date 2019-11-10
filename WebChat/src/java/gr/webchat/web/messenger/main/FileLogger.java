/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.webchat.web.messenger.main;

import gr.webchat.model.entities.Message;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nikolas
 */
public class FileLogger {

   private FileWriter writer;
   private static final String FILENAME = "messenger.log";

   //Open the file or create it if not found
   public void initFile() throws MessengerException {
       try {
           writer = new FileWriter(FILENAME, true);
       }
       catch(IOException ex) {
           throw new MessengerException(ex.getMessage(), ex);
       }
   }

   public void writeToFile(Message msg) throws MessengerException, IOException{
       try {
           writer.append(msg.getId() + ", "
                   + msg.getSender().getName()
                   +" , "+ msg.getReceiver().getName()
                   +" , "+ msg.getWhen()+ " , "
                   + msg.getText()
           );
       } catch (IOException ex) {
           throw new MessengerException(ex.getMessage(), ex);
       }
   }
}
