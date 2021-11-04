package com.tn.beans;

import java.util.ArrayList;

public class Client {

	private String name;
	private ArrayList<Message> messages;
	private int idClient;

	public Client(String name) {
		this.name = name;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

}
