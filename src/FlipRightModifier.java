import java.awt.image.BufferedImage;

public class FlipRightModifier implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {
		
		int width = source.getWidth();
		int height = source.getHeight();
		
		BufferedImage image = new BufferedImage(width, height, source.getType());
		
		
		
		return image;
		
	}

	@Override
	public String getName() {
		return "Virado para a direita";
	}

}
