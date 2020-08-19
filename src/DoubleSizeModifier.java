import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class DoubleSizeModifier implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {
		
		int width = source.getWidth() * 2;
		int height = source.getHeight() * 2;
		
		BufferedImage image = new BufferedImage(width, height, source.getType());
		
		Image temporaryImage = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		Graphics2D g2d = image.createGraphics();
        g2d.drawImage(temporaryImage, 0, 0, null);
        g2d.dispose();
        
        return image;
	}

	@Override
	public String getName() {
		return "Dobro do tamanho";
	}

}
