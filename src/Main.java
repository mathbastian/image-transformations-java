import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Main {
	
	static BufferedImage bufferedImage = null;
	static File file = null;

	public static void main(String[] args) {
		
		try {
			file = readFile();
			bufferedImage = readImage(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<ImageModifier> imageModifiers = ImageModifiersAssembler.create();
		
		for (ImageModifier imageModifier : imageModifiers) {
			saveImage(imageModifier.modify(bufferedImage), imageModifier.getName());
		}
		
	}
	
	private static File readFile() throws Exception {
		String path = FileSystems.getDefault().getPath("").toAbsolutePath() + "\\images\\image.png";
		System.out.println("reading file from " + path);
		return new File( path );
	}
	
	private static BufferedImage readImage( File file ) throws Exception {
		return ImageIO.read(file);
	}
	
	private static void saveImage( BufferedImage image, String name ) {
		try {
			String fileName = name + ".png";
			System.out.println("trying to save file " + fileName);
			File file = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "\\images\\" + fileName );
			if(image != null) {
				ImageIO.write(image, "png", file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
