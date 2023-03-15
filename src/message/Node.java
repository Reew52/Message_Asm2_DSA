/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

/**
 *
 * @author Dell
 */
public class Node {
    private Node next;
    private String message;
    
    public Node() {
        next = null;
        message = "";
    }

    public Node(String message) {
        this.next = null;
        this.message = message;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
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
        return "MessageDemo{" + "message=" + message + '}';
    }
}
