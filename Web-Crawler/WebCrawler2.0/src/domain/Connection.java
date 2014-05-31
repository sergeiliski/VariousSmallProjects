package domain;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Connection {

	private static Connection connection;
	private String webpageURL;
	private Document webpage;
	private boolean activeConnection = false;

	private Connection() {

	}

	public static Connection getInstance() {
		if (connection == null) {
			connection = new Connection();
		}
		return connection;
	}

	public void initWebpage(String url) throws IOException {
		webpage = Jsoup.connect(url).get();
		webpageURL = url;
		activeConnection = true;
	}

	public Document getWebpage() {
		return webpage;
	}

	public String getWebpageUrl() {
		return webpageURL;
	}

	public boolean hasConnection() {
		return activeConnection;
	}
}
