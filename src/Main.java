import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

public class Main {
	
	static BufferedImage bufferedImage = null;
	static File file = null;

	public static void main(String[] args) {

		List<ImageModifier> imageModifiers = ImageModifiersAssembler.create();
		
		try {
			Iterator<Path> paths = getPaths();
			
			while(paths.hasNext()) {
				Path path = paths.next();
				File file = path.toFile();
				int counterForFileName = 1;
				
				bufferedImage = readImage(file);
				
				for (ImageModifier imageModifier : imageModifiers) {
					String fileName = file.getName() + " " + imageModifier.getName() + " " + counterForFileName;
					saveImage(imageModifier.modify(bufferedImage), fileName);
					counterForFileName++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static BufferedImage readImage( File file ) throws Exception {
		return ImageIO.read(file);
	}
	
	private static void saveImage( BufferedImage image, String name ) {
		try {
			String fileName = name + ".png";
			System.out.println("trying to save file " + fileName);
			File file = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "\\newimages\\" + fileName );
			if(image != null) {
				ImageIO.write(image, "png", file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Iterator<Path> getPaths() throws IOException{
		String path = FileSystems.getDefault().getPath("").toAbsolutePath() + "\\images";
		return Files.walk(Paths.get(path)).filter(Files::isRegularFile).iterator();
	}

}
