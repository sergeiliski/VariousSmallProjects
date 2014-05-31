package domain;

public class ImageURL {

	private String imageURL;

	public ImageURL(String url) {
		imageURL = url;
	}

	public String getURL() {
		return imageURL;
	}

	public boolean isJPG() {
		if (imageURL.toLowerCase().endsWith("jpg")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isJPEG() {
		if (imageURL.toLowerCase().endsWith("jpeg")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPNG() {
		if (imageURL.toLowerCase().endsWith("png")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isGIF() {
		if (imageURL.toLowerCase().endsWith("gif")) {
			return true;
		} else {
			return false;
		}
	}

	private String trimURL(int charactersFromEnd) {
		return imageURL.substring(imageURL.lastIndexOf("/") + 1, imageURL.length() - charactersFromEnd);
	}

	public String getImageName() {
		if (isJPG() || isPNG() || isGIF()) {
			return trimURL(4);
		} else if (isJPEG()) {
			return trimURL(5);
		} else {
			return null;
		}
	}

}
