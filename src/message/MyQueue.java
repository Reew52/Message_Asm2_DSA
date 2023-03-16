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
    public void enQueueDemo(Message message){
        if (isEmpty()) {
            front = message;
        }else{
            rear.setNext(message);
        }
        rear = message;
        length++;
    }
    
    public String deQueueDemo(){
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
    
    public String first() throws Exception{
        if(isEmpty()){
            throw new Exception();
        }
        return front.getMessage();
    }
    public int size(){
        return length;
    }
    
    public boolean isEmpty(){
        return(length == 0);
    }
    
    public String toString(){
        String result = "";
        Message current = front;
        while(current != null){
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }
    
    public void print_frontRear(){
        System.out.println("Front: " + front.getMessage() + ", Rear: " + rear.getMessage()); // thêm thông tin để in giá trị front và rear
    }
}
