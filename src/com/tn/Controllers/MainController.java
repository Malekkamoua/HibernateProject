package com.tn.Controllers;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tn.DAO.ClientDAO;
import com.tn.DAO.MessageDAO;
import com.tn.Hibernate.HibernateUtil;
import com.tn.beans.Client;
import com.tn.beans.Message;

public class MainController {

	public static void main(String[] args) {

		SessionFactory sessionf = HibernateUtil.getSessionFactory();

		Transaction tx = null;
		MessageDAO messageDAO = new MessageDAO(sessionf);
		ClientDAO clientDAO = new ClientDAO(sessionf);

		Client client1 = new Client("Malek");
		Client client2 = new Client("Ghada");

		/* Scanner myObj = new Scanner(System.in);
		System.out.println("Type 1 to create, Type 2 to update");

		String opt = myObj.nextLine();

		switch (opt) {

		case "1":
			System.out.println("Type your message text");
			String text = myObj.nextLine();
			Message message1 = new Message(text, client);
			myObject.create(message1);
			System.out.println("Message created with success");
			break;

		case "2":
			System.out.println("Type your update message text");
			String text_update = myObj.nextLine();
			Message message_updated = new Message(text_update, client);
			myObject.update(1, "updated");
			System.out.println("Message updated with success");

			break;
		default:
			System.out.println("Invalid choice");
		} */

		clientDAO.create(client1);
		Message message1 = new Message("Bonjour");
		client1.addMessage(message1);
		client1.removeMessage(message1);
		//messageDAO.create(message1);

		clientDAO.create(client2);
		Message message2 = new Message("Hello world");
		message2.setClient(client2);
		messageDAO.create(message2);

		System.out.println("Done");
		//messageDAO.update(1, "news woo");

	}

}