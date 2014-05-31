package core;

import interfaces.Observer;
import interfaces.Subject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import util.OutputUtil;

public class Server implements Runnable, Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	private ServerSocket serverSocket;
	private Socket clientSocket;

	private ObjectInputStream inbound;

	private int port;

	public Server(int port) throws IOException {
		this.port = port;
	}

	private void createConnection() throws IOException {
		clientSocket = serverSocket.accept();
	}

	private void initiateIO() throws IOException {
		inbound = new ObjectInputStream(clientSocket.getInputStream());
	}

	public void closeConnection() {
		try {
			inbound.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("An unexpected IO error occurred when closing connections", "IO Error");
		} catch (NullPointerException npe){
			OutputUtil.showErrorMessage("No connections found to be closed", "No connections");
		}
	}

	private void processConnection() throws IOException {
		while (Connection.getInstance().isRunning()) {
			Message message = null;
			try {
				message = (Message) inbound.readObject();
			} catch (ClassNotFoundException e) {
				OutputUtil.showErrorMessage("Couldn't retrieve incoming message!", "Class not found");
			}
			setNewIncomingMessage(message);
		}
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			try {
				createConnection();
				initiateIO();
				processConnection();
			} catch (IOException e) {
				OutputUtil.showErrorMessage("An unexpected IO error occurred", "IO Error");
			} finally {
				Connection.getInstance().closeConnections();
			}
		} catch (IOException e) {
			OutputUtil.showErrorMessage("ServerSocket couldn't be created", "IO Error");
		}
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
		for (Observer obs : observers) {
			obs.newIncomingMessage(message);
		}
	}

	@Override
	public void setNewOutgoingMessage(Message message) {
		throw new NotImplementedException();
	}
}
