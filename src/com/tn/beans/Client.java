package com.tn.beans;

import java.util.HashSet;
import java.util.Set;

public class Client {

	private String name;
	private Set<Message> messages = new HashSet<Message>();

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

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(Message message) {
		if (message == null) {
			throw new IllegalArgumentException("null");
		}
		if (message.getClient() != null) {
			message.getClient().removeMessage(message);
		}
		message.setClient(this);
		messages.add(message);
	}

	public void removeMessage(Message message) {
		if (message == null)
			throw new IllegalArgumentException("null");
		message.setClient(null);
		messages.remove(message);
	}

}
