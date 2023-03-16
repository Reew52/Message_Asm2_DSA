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

    public String peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return top.getMessage();
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public String toString() {
        String result = "";
        Message current = top;
        while (current != null) {
            result = result + current.toString();
            current = current.getNext();
        }
        return result;
    }

    public Message getTop() {
        return top;
    }

    public void print_top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top: " + top.getMessage()); // thêm thông tin để in giá trị của top
        }
    }
}
