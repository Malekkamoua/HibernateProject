package com.tn.beans;

public class Message {

	private int idMessage;
	private String text;
	private Client client;

	public Message(String text, Client client) {
		this.text = text;
		this.client = client;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
