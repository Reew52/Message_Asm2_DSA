/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package message;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("=============== Login ==============");
            System.out.print("Enter username: ");
            String username = sc.next();

            System.out.print("Enter password: ");
            String password = sc.next();

            boolean invalidPassword = false; // Add this variable to check password match

            try {
                File file = new File("login.txt");
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] tokens = line.split(":");

                    if (tokens[0].equals(username) && tokens[1].equals(password)) {
                        System.out.println("Login successful!");
                        loggedIn = true;
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
                                    search();
                                    break;
                                case 4: 
                                    deleteTopStack();
                                    break;
                                case 5: 
                                    deleteAllStack();
                                    break;
                                case 6: 
                                    System.out.println("Closing!");
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        } while (option != 6);
                        sc.close();

                    } else if (tokens[0].equals(username)) { // if username is correct but password is wrong
                        invalidPassword = true;
                    }
                }

                if (!loggedIn) {
                    if (invalidPassword) {
                        System.out.println("Invalid password. Please try again.");
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
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
        System.out.println("|     3. Message Search                           |");
        System.out.println("|     4. Delete the message you just sent         |");
        System.out.println("|     5. Delete all sent messages                 |");
        System.out.println("|     6. Exit                                     |");
        System.out.println("|                                                 |");
        System.out.println("+-------------------------------------------------+");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }
    
    public static void sendMessage(boolean sendNow, String sender, String receiver) {
        try {
            while (!mQueue.isEmpty()) {
                String message = mQueue.deQueue();
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
                mQueue.enQueue(node);
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
            if (!mStack.isEmpty()) {
                System.out.println("Sent messages list :");
                System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                String format = "|%-10s| %-10s | %-40s | %-25s | %-25s |\n";
                System.out.format(format, "Sender", "Receiver", "Message", "Send Time", "Receive Time");
                System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                System.out.println(mStack.toString());
                System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                System.out.println("End!");
            } else {
                System.out.println("Sent message list is empty!");
            }
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
    
    public static void search() {
        try {
            System.out.println("Enter keyword to search:");
            String keyword = sc.nextLine();
            ArrayList<Message> searchResults = mStack.search(keyword);
            if (searchResults.isEmpty()) {
                System.out.println("No matching messages found.");
            } else {
                System.out.println("Matching messages:");
                for (Message result : searchResults) {
                    System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                    String format = "|%-10s| %-10s | %-40s | %-25s | %-25s |\n";
                    System.out.format(format, "Sender", "Receiver", "Message", "Send Time", "Receive Time");
                    System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                    System.out.println(result.toString());
                    System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                    System.out.println("End!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public static void deleteTopStack() {
        try {
            if (!mStack.isEmpty()) {
                System.out.println("Message just sent :");
                System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                String format = "|%-10s| %-10s | %-40s | %-25s | %-25s |\n";
                System.out.format(format, "Sender", "Receiver", "Message", "Send Time", "Receive Time");
                System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                mStack.printTop();
                System.out.println("+----------+------------+------------------------------------------+---------------------------+---------------------------+");
                System.out.println("Are you sure to delete sent messages? (Y/N)");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    String message = mStack.pop();
                    System.out.println("Deleted message: " + message);
                    System.out.println("End!");
                } else {
                    System.out.println("Operation canceled.");
                }
            } else {
                System.out.println("Sent message list is empty!!");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public static void deleteAllStack() {
        try {
            System.out.println("Are you sure to delete all sent messages? (Y/N)");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                mStack.clear();
            } else {
                System.out.println("Operation canceled.");
            }
            // Print a message if the stack is empty
            if (mStack.isEmpty()) {
                System.out.println("Sent message list is empty!");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

}
