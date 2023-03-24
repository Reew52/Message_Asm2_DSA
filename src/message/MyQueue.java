/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

/**
 *
 * @author Dell
 */
public class MyQueue {
    private int length;
    private Message front;
    private Message rear;

    public MyQueue() {
        length = 0;
        front = rear = null;
    }
     
    // adds
    public void enQueue(Message message){
        if (isEmpty()) {
            front = message;
        }else{
            rear.setNext(message);
        }
        rear = message;
        length++;
    }
    
    public String deQueue(){
        if (isEmpty()) {
            return "Queue is empty";
        }else{
            String result = front.getMessage();
            front = front.getNext();
            length--;
            if (isEmpty()) {
                rear = null;
            }
        return result;
        }
    }
    
    public boolean isEmpty(){
        return(length == 0);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Message getFront() {
        return front;
    }

    public void setFront(Message front) {
        this.front = front;
    }

    public Message getRear() {
        return rear;
    }

    public void setRear(Message rear) {
        this.rear = rear;
    }
}
