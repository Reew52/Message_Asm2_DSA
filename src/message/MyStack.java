/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

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

    public String toString() {
        String result = "";
        Message current = top;
        while (current != null) {
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
}
