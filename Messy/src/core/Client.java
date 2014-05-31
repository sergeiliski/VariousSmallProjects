package core;

import interfaces.Observer;
import interfaces.Subject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import util.OutputUtil;

public class Client implements Runnable, Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	private Socket socket;
	private ObjectOutputStream outbound;

	private String host;
	private int port;
	private String username;

	public Client(String host, int port) throws UnknownHostException, IOException {
		this.host = host;
		this.port = port;
	}

	private void createConnection() {
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			OutputUtil.showErrorMessage("Couldn't bind socket to unknown host", "Unknown host");
		} catch (IOException e) {
			OutputUtil.showErrorMessage("General IO error at creating client socket", "IO error");
		}
	}

	private void initiateIO() {
		try {
			outbound = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't load IO streams from client", "IO Error");
		}
	}

	public void closeConnection() {
		try {
			outbound.close();
			socket.close();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("An unexpected IO error occurred when closing connections", "IO Error");
		}
	}

	public void sendMessage(String message) {
		Message mess = new Message(username, message);
		try {
			outbound.writeObject(mess);
			outbound.flush();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't send message!", "IO error");
		} catch (NullPointerException npe){
			OutputUtil.showErrorMessage("Establish a working connection first!", "No outbound connection");
		}
		setNewOutgoingMessage(mess);
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public void run() {
		createConnection();
		initiateIO();
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void setNewIncomingMessage(Message message) {
		throw new NotImplementedException();
	}

	@Override
	public void setNewOutgoingMessage(Message message) {
		for (Observer obs : observers) {
			obs.newOutgoingMessage(message);
		}
	}
}
