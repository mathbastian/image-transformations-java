import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ResizeTo1024 implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {
		
		int width = source.getWidth();
		int height = source.getHeight();
		int newWidth = 0;
		int newHeight = 0;
		
		//paisagem
		if(width > height) {
			newWidth = 1024;
			float resizeFactor = (float) newWidth / width;
			newHeight = (int) (height * resizeFactor);
		}//retrato
		else {
			newHeight = 1024;
			double resizeFactor = newHeight / height;
			newWidth = (int) Math.ceil( (width * resizeFactor) );
		}
		
		BufferedImage image = new BufferedImage(newWidth, newHeight, source.getType());
		
		Image temporaryImage = source.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		
		Graphics2D g2d = image.createGraphics();
        g2d.drawImage(temporaryImage, 0, 0, null);
        g2d.dispose();
		
		return image;
		
	}

	@Override
	public String getName() {
		return "Redimensionado para 1024";
	}

}
