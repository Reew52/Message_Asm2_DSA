/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

import java.time.LocalDateTime;

/**
 *
 * @author Dell
 */
public class PersonMessage extends Message {
    private String sender;
    private String receiver;
    private LocalDateTime sendTime;
    private LocalDateTime receiveTime;
    
    public PersonMessage(String message, String sender, String receiver) {
        super(message);
        this.sender = sender;
        this.receiver = receiver;
        this.sendTime = LocalDateTime.now();
        this.receiveTime = null;
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

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }
    
    @Override
    public String toString() {
        return String.format("|%-10s| %-10s |" +  super.toString() + "| %-25s | %-25s |", 
        sender, receiver, sendTime, receiveTime);
    }
    
}
