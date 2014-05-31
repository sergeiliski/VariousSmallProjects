package util;

import java.util.HashSet;

import domain.ImageType;

public class DataUtils {

	public static String[][] convertImageArrayListTo2DArray(HashSet<ImageType> list) {
		String[][] result = new String[list.size()][2];
		int count = 0;

		for (ImageType currentImage : list) {
			result[count][0] = currentImage.getImageURL().getURL();
			result[count][1] = currentImage.getImageName();
			count++;
		}
		return result;
	}
}
