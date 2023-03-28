/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class MyStack {

    private int length;
    private Message top;

    public MyStack() {
        length = 0;
        top = null;
    }

    public void push(Message message) {
        message.setNext(top);
        top = message;
        length++;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
    public String toString() {
        String result = "";
        Message current = top;
        while (current != null) {
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
    
    public String pop() {
        if (isEmpty()) {
            return "Stack is empty";
        } else {
            String result = top.getMessage();
            top = top.getNext();
            length--;
            return result;
        }
    }
    
    public void clear() {
        length = 0;
        top = null;
    }
    
    public ArrayList<Message> search(String keyword) {
        ArrayList<Message> results = new ArrayList<Message>();
        Message current = top;
        while (current != null) {
            if (current.getMessage().contains(keyword)) {
                results.add(current);
            }
            current = current.getNext();
        }
        return results;
    }
    
    public void printTop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(top.toString());
        }
    }

    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public Message getTop() {
        return top;
    }
    
    public void setTop(Message top) {
        this.top = top;
}
    
    
}
