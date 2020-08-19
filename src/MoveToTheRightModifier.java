import java.awt.image.BufferedImage;

public class MoveToTheRightModifier implements ImageModifier {

	@Override
	public BufferedImage modify(BufferedImage source) {
		
		float spaceToIgnoreFloat = (source.getWidth() * 20) / 100;
		int spaceToIgnore = (int) spaceToIgnoreFloat;
		int width = source.getWidth();
		int height = source.getHeight();
		
		BufferedImage image = new BufferedImage(width + spaceToIgnore, height, source.getType());
		
		for( int y = 0; y < height; y++ ) {
			for( int x = 0; x < width; x++ ) {
				
				int pixel = source.getRGB(x, y);
				image.setRGB(x + spaceToIgnore, y, pixel);
			}
		}
		
		return image;
		
	}

	@Override
	public String getName() {
		return "Deslocado para a direita";
	}

}
