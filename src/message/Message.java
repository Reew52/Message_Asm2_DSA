/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

/**
 *
 * @author Dell
 */

public abstract class Message {
    private Message next;
    private String message;
    
    public Message() {
        next = null;
        message = "";
    }

    public Message(String message) {
        this.next = null;
        this.message = message;
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

    @Override
    public String toString() {
        return String.format(" %-40s ", message);
    }
}
