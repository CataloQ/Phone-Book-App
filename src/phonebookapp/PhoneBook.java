/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonebookapp;

class Contact {
     // Attributes to store the contact's name and phone number
    String name;
    String phoneNumber;

    // Constructor to initialize the contact object with a name and phone number
    Contact(String name, String phoneNumber) {
        this.name = name; // Assign the provided name to the instance variable 'name'
        this.phoneNumber = phoneNumber;// Assign the provided phone number to the instance variable 'phoneNumber'
    }

    // Override the toString() method to provide a readable format for displaying contact details
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

class PhoneBook {
    // Define a Node class that contains the contact and the next node
    private class Node {
        Contact contact;// Stores the contact details in this node
        Node next; // Reference to the next node in the list

        // Constructor to initialize the node with a contact and set the next reference to null
        Node(Contact contact) {
            this.contact = contact;// Initialize contact with the given Contact object
            this.next = null; // By default, the next node is set to null (end of the list)
        }
    }

    private Node head; // The first node in the list

    public PhoneBook() {
        this.head = null; // Initially, the phonebook is empty, so head is set to null
    }

    // Method to add a contact to the phonebook
    public void addContact(String name, String phoneNumber) {
        // Create a new Contact object with the provided name and phone number
        Contact newContact = new Contact(name, phoneNumber);
       // Create a new Node to hold the new contact
        Node newNode = new Node(newContact);
        // If the list is empty (head is null), make the new node the head of the list
        if (head == null) {
            head = newNode;
        } else {
          // Traverse the list to find the last node (where next is null)
            Node current = head;
            while (current.next != null) {
                current = current.next;// Move to the next node
            }
             // Set the next of the last node to the new node, thus adding it to the end
            current.next = newNode;
        }
        // Print a message indicating that the contact was added
        System.out.println("Contact added: " + newContact);
    }

    // Method to display all contacts
    public void displayContacts() {
        // If the list is empty (head is null), print a message and return
        if (head == null) {
            System.out.println("Phonebook is empty.");
            return;
        }
        // Start at the head node and traverse the list
        Node current = head;
        // Loop through all nodes in the list
        while (current != null) {
           // Print the contact details for the current node
            System.out.println(current.contact);
            // Move to the next node in the list
            current = current.next;
        }
    }

    // Method to search for a contact by name
    public void searchContact(String name) {
        // Start at the head node
        Node current = head;
      // Traverse the list while the current node is not null
        while (current != null) {
            // Check if the current contact's name matches the provided name (case-insensitive)
            if (current.contact.name.equalsIgnoreCase(name)) {
              // If a match is found, print the contact details and return from the method
                System.out.println("Found: " + current.contact);
                return;
            }
            // Move to the next node in the list
            current = current.next;
        }
        // If no match is found, print that the contact was not found
        System.out.println("Contact not found.");
    }

    // Method to delete a contact by name
    public void deleteContact(String name) {
        // Check if the phonebook (list) is empty by verifying if head is null
        if (head == null) {
            System.out.println("Phonebook is empty.");
            return;// Exit the method if there are no contacts
        }

        // Check if the contact to be deleted is the first contact (head node)
        if (head.contact.name.equalsIgnoreCase(name)) {
           // If the head's contact name matches the provided name (case-insensitive)
            System.out.println("Deleted: " + head.contact);// Print confirmation of deletion
            head = head.next;// Update head to point to the next node, effectively removing the head
            return;// Exit the method since the contact has been deleted

        }
        // Start traversing the list from the head node
        Node current = head;
        // Check if the next node's contact name matches the provided name (case-insensitive)
        while (current.next != null) {
           // Check if the next node's contact name matches the provided name (case-insensitive)
            if (current.next.contact.name.equalsIgnoreCase(name)) {
              // If a match is found, print confirmation of deletion
                System.out.println("Deleted: " + current.next.contact);
                // Remove the node by bypassing it: set the current node's next to skip over the node to be deleted
                current.next = current.next.next;
                return; // Exit the method as the contact has been deleted
            }
             // Move to the next node in the list
            current = current.next;
        }
// If the loop completes and no match is found, print a message that the contact was not found
        System.out.println("Contact not found.");
    }
}