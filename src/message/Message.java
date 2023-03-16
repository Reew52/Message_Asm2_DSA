/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

/**
 *
 * @author Dell
 */
import java.time.LocalDateTime;

public class Message {
    private Message next;
    private String message;
    private String sender;
    private String receiver;
    private LocalDateTime sendTime;
    private LocalDateTime receiveTime;
    
    public Message() {
        next = null;
        message = "";
        sender = "";
        receiver = "";
        sendTime = LocalDateTime.now();
        receiveTime = null;
    }

    public Message(String message, String sender, String receiver) {
        this.next = null;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.sendTime = LocalDateTime.now();
        this.receiveTime = null;
    }

    public Message getNext() {
        return next;
    }

    public void setNext(Message next) {
        this.next = next;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return String.format("|%-10s| %-10s | %-40s | %-25s | %-25s |", 
        sender, receiver, message, sendTime, receiveTime);
    }
}
