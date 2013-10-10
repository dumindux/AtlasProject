/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.logging.Logger;

/**
 *
 * @author Cosmox Software Developers
 */
public class Notification {
    
    private String sender;
    private String receiver;
    private String description;
    private boolean is_resolved=false;
    private int batch;
    private int amount;
    private int notificationID=-1;
    
    public Notification() {
    }

    public Notification(String sender, String receiver, String description, int batch, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.batch = batch;
        this.amount = amount;
        
    }
    public Notification(int id,String sender, String receiver, String description, int batch, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.batch = batch;
        this.amount = amount;
        this.notificationID=id;
    }
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_resolved() {
        return is_resolved;
    }

    public void setIs_resolved(boolean is_resolved) {
        this.is_resolved = is_resolved;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }
    
    
    
}
