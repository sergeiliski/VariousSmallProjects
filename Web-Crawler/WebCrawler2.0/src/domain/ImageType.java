package domain;

import java.io.File;

public class ImageType {

	private String imageName;
	private ImageURL imageURL;
	private File directory;

	public ImageType(String imageName, ImageURL imageURL, File directory) {
		this.imageName = imageName;
		this.imageURL = imageURL;
	}

	public String getImageName() {
		return imageName;
	}

	public ImageURL getImageURL() {
		return imageURL;
	}

	public File getDirectory() {
		return directory;
	}
}
