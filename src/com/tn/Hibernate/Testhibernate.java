package com.tn.Hibernate;


import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tn.DAO.MessageDAO;
import com.tn.beans.Client;
import com.tn.beans.Message;
public class Testhibernate {

	public static void main(String[] args) {

		SessionFactory sessionf=HibernateUtil.getSessionFactory();		
		
		Transaction tx =null;
		MessageDAO myObject = new MessageDAO(sessionf);
	    Client client = new Client("Malek");

		/*Scanner myObj = new Scanner(System.in);
	    System.out.println("Type 1 to create, Type 2 to update");

	    String opt = myObj.nextLine();

	    switch(opt) {
	    
	    case "1":
			System.out.println("Type your message text");
	    	String text = myObj.nextLine();
			Message message1 = new Message(text, client);
			myObject.Create(message1);
			System.out.println("Message created with success");
	      break;
	      
	    case "2":
			System.out.println("Type your updat message text");
	    	String text_update = myObj.nextLine();
			Message message_updated = new Message(text_update, client);
			myObject.Update(1, "updated");
			System.out.println("Message updated with success");

	      break;
	    default:
	    	System.out.println("Unvalid choice");
	    }*/
	    
	    
		Message message1 = new Message("Bonjour", client);
		Message message2 = new Message("Hello world", client);

		myObject.Create(message1);
		myObject.Create(message2);
		System.out.println(message1.getIdMessage());
		myObject.Update(1, "news wooo");
		
		}

}