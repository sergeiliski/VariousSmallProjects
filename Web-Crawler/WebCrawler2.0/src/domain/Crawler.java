package domain;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;

public class Crawler {

	public Crawler() {

	}

	public void createConnection(String url) throws IOException {
		Connection.getInstance().initWebpage(url);
		loadImages();
	}

	public boolean hasConnection() {
		return Connection.getInstance().hasConnection();
	}

	// Returns all images for overview. Note that this list isn't used to store
	// them locally.
	public HashSet<ImageType> getImages() {
		return ImageHandler.getInstance().getImages();
	}

	// Loads all images in a virtual representation.
	private void loadImages() {
		ImageHandler.getInstance().loadImagesFromLinks();
		ImageHandler.getInstance().loadImagesFromImageTags();
	}

	// Saves all images locally
	public void downloadImages() throws MalformedURLException, IOException {
		ImageHandler.getInstance().downloadAllImages();
	}

	// Sets the directory to where files should be saved
	public void setDirectory(File directory) {
		ImageHandler.getInstance().setDirectory(directory);
	}

	// Sets the chosen preferences concerning what types of image should be
	// downloaded
	public void selectImageFileTypes(ArrayList<String> fileTypes) {
		ImageHandler.getInstance().setImageFileTypes(fileTypes);
	}

	// Clears the existing images and file type preferences
	public void clearExistingPreferences() {
		ImageHandler.getInstance().clearExistingPreferences();
	}

	// Returns the size of the actual list (aka: the amount of images found)
	public int getListSize() {
		return ImageHandler.getInstance().getListSize();
	}

	// Decides whether or not small images will be downloaded
	public void downloadSmallImages(boolean bool) {
		ImageHandler.getInstance().downloadSmallImages(bool);
	}

	// Empties the currently selected folder
	public void emptyFolder() throws IOException {
		ImageHandler.getInstance().emptyFolder();
	}
}
