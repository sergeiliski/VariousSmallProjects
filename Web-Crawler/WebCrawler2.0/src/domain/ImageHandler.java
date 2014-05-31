package domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageHandler {

	private static ImageHandler imageHandler;

	private HashSet<ImageType> images = new HashSet<ImageType>();
	private ArrayList<String> imageFileTypes = new ArrayList<String>();
	private File directory;
	private boolean downloadSmallImages = false;

	private ImageHandler() {

	}

	public static ImageHandler getInstance() {
		if (imageHandler == null) {
			imageHandler = new ImageHandler();
		}
		return imageHandler;
	}

	public HashSet<ImageType> getImages() {
		return images;
	}

	public int getListSize() {
		return images.size();
	}

	public void clearExistingPreferences() {
		images.clear();
		imageFileTypes.clear();
	}

	public void downloadSmallImages(boolean bool) {
		downloadSmallImages = bool;
	}

	// Retrieves all images from the connected URL. Only images that
	// are represented as a link (<a>) are affected by this method. Each image
	// that is not in the list of allowed types, isn't added.
	public void loadImagesFromLinks() {
		Document webpage = Connection.getInstance().getWebpage();
		Elements links = webpage.select("a[href]");

		for (Element currentLink : links) {
			if (currentLink.tagName().equalsIgnoreCase("a")) {
				loadImage(currentLink, "abs:href");
			}
		}
	}

	// Retrieves all images from image tags (<img>) from the connected webpage.
	// Only images with an allowed tag are saved in the list.
	public void loadImagesFromImageTags() {
		Document webpage = Connection.getInstance().getWebpage();
		Elements tags = webpage.select("[src]");

		for (Element currentImageTag : tags) {
			if (currentImageTag.tagName().equalsIgnoreCase("img")) {
				loadImage(currentImageTag, "abs:src");
			}
		}
	}

	// Loads a single image into the local list. General method used by all
	// different sources of images.
	private void loadImage(Element currentElement, String query) {
		String url = currentElement.attr(query);
		ImageURL imageURL = new ImageURL(url);

		if (isAllowedImageURL(imageURL)) {
			ImageType newImage = new ImageType(imageURL.getImageName(), imageURL, directory);

			if (!(imageAlreadyLoaded(newImage))) {
				images.add(newImage);
			}
		}
	}

	private boolean imageAlreadyLoaded(ImageType image) {
		for (ImageType currentImage : images) {
			if (currentImage.getImageURL().getURL().equals(image.getImageURL().getURL())) {
				return true;
			}
		}

		return false;
	}

	public void downloadAllImages() throws MalformedURLException, IOException {
		for (ImageType currentImage : images) {
			saveImage(currentImage);
		}
	}

	private void saveImage(ImageType image) throws IOException, MalformedURLException {
		String formattedURL = image.getImageURL().getURL();
		formattedURL = formattedURL.replace(" ", "%20");
		URL url = new URL(image.getImageURL().getURL());
		BufferedImage bi = ImageIO.read(url);

		String type = "";
		if (image.getImageURL().isJPG()) {
			type = "jpg";
		} else if (image.getImageURL().isJPEG()) {
			type = "jpeg";
		} else if (image.getImageURL().isPNG()) {
			type = "png";
		} else if (image.getImageURL().isGIF()) {
			type = "gif";
		}

		if (!(bi.getHeight() < 250 && bi.getWidth() < 250 && downloadSmallImages == false)) {
			ImageIO.write(bi, type, new File(directory + "\\" + image.getImageName() + "." + type));
		}
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	// Checks whether or not the given image has a filetype which is selected by
	// the user as an allowed type.
	private boolean isAllowedImageURL(ImageURL url) {
		for (String type : imageFileTypes) {
			if (type.equalsIgnoreCase("JPG Images")) {
				if (url.isJPG() || url.isJPEG()) {
					return true;
				}
			} else if (type.equalsIgnoreCase("PNG Images")) {
				if (url.isPNG()) {
					return true;
				}
			} else if (type.equalsIgnoreCase("GIF Images")) {
				if (url.isGIF()) {
					return true;
				}
			}
		}

		return false;
	}

	public void setImageFileTypes(ArrayList<String> fileTypes) {
		this.imageFileTypes = fileTypes;
	}

	public void emptyFolder() throws IOException {
		FileUtils.cleanDirectory(directory);
	}
}
