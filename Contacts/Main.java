import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Contact;
import models.ContactManager;

public class Main {
    public static void main(String[] args) {
    	ContactManager manager = new ContactManager();
    	try {
    		loadContacts("/Users/nurdanemin/Desktop/contacts.txt", manager);
    		manageContacts(manager);
    		
    	}catch (FileNotFoundException e) {
    		System.out.println(e.getMessage());
    	}finally {
    		System.out.println("\nProcess Complete.");
    	}	
    }

    public static void manageContacts (ContactManager manager) {
    	Scanner scan = new Scanner(System.in);
    	while(true) {
    		System.out.println(manager);
    		System.out.println("Would you like to:\n\t"
    				+ "1) add another contact\n\t"
    				+ "2) remove a contact\n\t"
    				+ "3) exit\n");
    		int userResponse = scan.nextInt();
    		scan.nextLine();
    		if (userResponse ==1) {
    			System.out.println("\tLet's add a new contact.");
    			System.out.println("\tEnter the name:");
    			String contactName = scan.nextLine();
    			
    			System.out.println("\tPhone number:");
    			String phoneNumber = scan.nextLine();
    			System.out.println("\tEnter the birthday in YYYY-MM-DD format:");
    			String birthDate = scan.next();
    			
    			if (contactName.isBlank() || phoneNumber.isBlank()  || phoneNumber.length()>5) {
    				System.out.println("Name and phone cannot be blank and also  phone cannot be with less than 5 digits.\n");
    				continue;
    			}else {
    				Contact contact = new Contact(contactName,phoneNumber, birthDate);
        			manager.addContact(contact);	
    			}
    				
    				
    		}else if (userResponse ==2) {
    			System.out.println("Lets remove a contact.\n\t"
    					+ "The name of person you want to remove:\n");
    			manager.removeContact(scan.next());
 
    		}else {
    			break;
    		}
    	}
    	scan.close();
    }
    
    public static void loadContacts(String fileName, ContactManager manager) throws FileNotFoundException {
    	FileInputStream fis = new FileInputStream(fileName);
    	Scanner scan = new Scanner(fis);
    	while(scan.hasNextLine()) {
    		String[] line = scan.nextLine().split(" ");
    		Contact contact = new Contact (line[0], line[1], line[2]);
    		manager.addContact(contact);
    		
    		
    		
    	}
    	
    }
    	
    }
