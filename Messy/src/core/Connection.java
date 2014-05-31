package core;

import java.io.IOException;
import java.net.UnknownHostException;

import ui.templates.PersonalTextPane;
import util.OutputUtil;
import exceptions.ForbiddenActionException;

public class Connection {
	private static Connection connection;

	private Client client;
	private Server server;
	private String targetHostname;
	private int targetPort;
	private int localPort;

	private boolean running = true;
	private boolean connectionSet = false;

	private Connection() {

	}

	public static synchronized Connection getInstance() {
		if (connection == null) {
			connection = new Connection();
		}

		return connection;
	}

	public void startClientConnection() throws UnknownHostException, IOException {
		if (client == null) {
			client = new Client(targetHostname, targetPort);
			new Thread(client).start();
		} else {
			OutputUtil.showErrorMessage("Connection already active", "Forbidden action");
		}
	}

	public void startLocalServer() throws IOException {
		if (server == null) {
			server = new Server(localPort);
			new Thread(server).start();
		} else {
			throw new ForbiddenActionException("Server already running");
		}
	}

	public void setUsername(String user) {
		if (client != null) {
			client.setUsername(user);
		}
	}

	public String getUsername() {
		return client.getUsername();
	}

	public String getClientHostname() {
		return targetHostname;
	}

	public int getClientPort() {
		return targetPort;
	}

	public int getServerPort() {
		return localPort;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isConnectionSet() {
		return connectionSet;
	}

	public void closeConnections() throws IOException {
		if (server != null) {
			server.closeConnection();
		}
		if (client != null) {
			client.closeConnection();
		}
	}

	public void sendMessage(String message) {
		if (client != null) {
			client.sendMessage(message);
		} else {
			OutputUtil.showWarningMessage("Connect before you talk!", "IO error");
		}
	}

	public void setTargetPreferences(String host, int port) {
		this.targetHostname = host;
		this.targetPort = port;
		connectionSet = true;
	}

	public void setLocalPreferences(int port) {
		this.localPort = port;
	}

	public void addObserver(PersonalTextPane pane) {
		client.addObserver(pane);
		server.addObserver(pane);
	}
}
