package models;

import java.util.ArrayList;

public class ContactManager {
	private  ArrayList<Contact> contacts;
	
	
	public ContactManager() {   //constructor
	this.contacts =  new ArrayList<Contact>();
}
	public Contact getContact(int index) {
		return new Contact(this.contacts.get(index));
	}
	
	public void setContact(int index, Contact contact) {
		this.contacts.set(index, new Contact(contact));
	}
	
	public void addContact(Contact contact) {   //add a copy of contact not contact directly so that eliminates reference trap.
		this.contacts.add(new Contact(contact));
	}
	
	public void removeContact(String contactName) {  // it was not  not working with arraylist  size because when you remove an item size does not decrease.
		if (this.contacts.isEmpty()) {
			throw new IllegalStateException("The contacts are already empty!");
		}else {
			for (int i=0; i<contacts.size(); i++) {
				if (contacts.get(i).getName().equalsIgnoreCase(contactName)) {
					this.contacts.remove(i);
					System.out.println(contactName + " was removed.\n");
				}
			}
		}
	}
	
	
	public String toString() {
		String temp = "";
		for (int i =0; i<this.contacts.size(); i++) {
			temp += this.contacts.get(i).toString() + "\n\n";
		}
		return temp;
	}
}
