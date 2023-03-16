/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MyQueue mQueue = new MyQueue();
    private static MyStack mStack = new MyStack();
    
    public static void main(String[] args) {              
        int option;
        do {
            option = printMenu();
            switch (option) {
                case 1:
                    inputMessage();
                    break;
                case 2: 
                    messageReceived();
                break;
                case 3: 
                break;
                case 4: 
                    messageReceived();
                break;
                case 5:{
                    System.out.println("Closing!");
                    break;
                }
                    
                default:
                    throw new AssertionError();
            }
        } while (option != 5);
        sc.close();
        
    }
    
    public static int printMenu() {
        // Print Menu
        System.out.println("+-------------------------------------------------+");
        System.out.println("|                       Menu                      |");
        System.out.println("+-------------------------------------------------+");
        System.out.println("| Select an option:                               |");
        System.out.println("|                                                 |");
        System.out.println("|     1. Send Message                             |");
        System.out.println("|     2. Received message                         |");
        System.out.println("|     3. Message not sent                         |");
        System.out.println("|     4. Delete messages                          |");
        System.out.println("|     5. Exit                                     |");
        System.out.println("|                                                 |");
        System.out.println("+-------------------------------------------------+");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }
    
    public static void sendMessage(boolean sendNow, String sender, String receiver) {
        try {
            while (!mQueue.isEmpty()) {
                String message = mQueue.deQueueDemo();
                if (sendNow) {
                    Message node = new Message(message, sender, receiver);
                    node.setSendTime(LocalDateTime.now());
                    mStack.push(node);
                    node.setReceiveTime(LocalDateTime.now());
                }
            }
            if (sendNow) {
                System.out.println("Messages sent to Stack.");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public static void inputMessage() {
        try {
            System.out.println("Enter the message (less than 250 characters):");
            String message = sc.nextLine();
            if (message.length() > 250) {
                System.out.println("Error: Message length should be less than 250 characters.");
            } else {
                System.out.println("Enter the sender:");
                String sender = sc.nextLine();
                System.out.println("Enter the receiver:");
                String receiver = sc.nextLine();
                Message node = new Message(message,sender, receiver);
                mQueue.enQueueDemo(node);
                System.out.println("Message added to the queue.");

                // Ask user if they want to send the message right away
                System.out.println("Do you want to send the message now? (Y/N/Enter to exit)");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    // Call Case 2 to send the message
                    System.out.println("Sending message...");
                    sendMessage(true, sender, receiver);
                    response();
                } else if (response.equalsIgnoreCase("N")) {
                    sendMessage(false, sender, receiver); // don't send the message now
                    System.out.println("Message not sent!");
                    response();
                } else {
                    sendMessage(false, sender, receiver); // don't send the message now
                    System.out.println("Exit");
                }
            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public static void messageReceived() {
        try {
            System.out.println("Message in Stack is :");
            System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
            String format = "|%-10s| %-10s | %-40s | %-25s | %-25s |\n";
            System.out.format(format, "Sender", "Receiver", "Message", "Send Time", "Receive Time");
            System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
            System.out.println(mStack.toString());
            System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
            System.out.println("End!");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public static void response(){
        System.out.println("Do you want to send another message? (Y/N)");
        String response = sc.nextLine();
        if (response.equalsIgnoreCase("Y")) {
            inputMessage();
        } else {
            return;
        }
    }
    
}
